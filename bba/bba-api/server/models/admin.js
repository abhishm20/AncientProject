var _ = require('lodash')
var util = require('../util');
var async = require('async');


module.exports = function(Admin) {

  Admin.authenticate = function (ctx, authData, next) {
    var currentTime = new Date();
    if(authData.secret && authData.id){
      Admin.findById(authData.id, function(err, managerInstance){
        if(err){
          next(util.getInternalServerError(err));
          return;
        }
        if(managerInstance){
          managerInstance.secrets.findById(authData.secret, function(err, secretInstance){
            if(err){
              cb(util.getInternalServerError(err));
              return;
            }
            if(secretInstance && secretInstance.ttl > currentTime.getTime()){
              secretInstance.ttl = util.getSecret(currentTime).ttl;
              secretInstance.save(function(err){
                if(err){
                  next(util.getInternalServerError(err));
                  return;
                }
                next();
                return;
              });
            }else{
              ctx.res.header("Authorization", "required");
              next(util.getGenericError("Error", 403, "Authorization Required"));
              return;
            }
          });
        }else{
          ctx.res.header("Authorization", "Required");
          next(util.getGenericError("Error", 403, "Authorization Required"));
          return;
        }
      });
    }else{
      ctx.res.header("Authorization", "Required");
      next(util.getGenericError("Error", 403, "Authorization Required"));
      return;
    }
  };


  Admin.beforeRemote('**', function(ctx, unused, next){
    var currentTime = new Date();
    var methodName = ctx.method.name;
    if(methodName == 'login'){
      next();
      return;
    }
    var authData = ctx.req.header('Authorization');
    try {
      authData = JSON.parse(authData);
    }catch (e) {
      next(util.getGenericError("Error", 403, "Authorization Required"));
      return;
    }
    if(authData && authData.role == "teacher"){
      if(methodName === 'findById' || methodName === 'getReport1' || methodName === 'getReport2' || methodName === 'updatePassword'){
        Admin.authenticate(ctx, authData, function(err){
          if(err){
            next(err);
            return;
          }
          next();
          return;
        });
      }else{
        next(util.getGenericError("Error", 403, "Authorization Required"));
        return;
      }
    }else if(authData && authData.role == "admin"){
      Admin.authenticate(ctx, authData, function(err){
        if(err){
          next(err);
          return;
        }
        next();
        return;
      })
    }else{
      next(util.getGenericError("Error", 403, "Authorization Required"));
      return;
    }
  });

  Admin.afterRemote('findById', function (ctx, admin, next) {
    ctx.result = {response: admin};
    next();
  });
  Admin.afterRemote('find', function (ctx, admins, next) {
    ctx.result = {response: admins};
    next();
  })




  Admin.login = function(req, credentials, cb){
    var currentTime = new Date();
    if(!credentials.email || !credentials.password){
      cb(util.getGenericError("Error", "400", "Invalid data recieved"));
      return;
    }
    Admin.findOne({where:{email: credentials.email}, include:"school"}, function(err, adminInstance){
      if(err){
        cb(util.getInternalServerError(err));
        return;
      }
      if(adminInstance && adminInstance.id){
        util.comparePassword(credentials.password , adminInstance.password, function (err, matched) {
          if(err){
            cb(util.getInternalServerError(err));
            return;
          }
          if(matched){
            var secretData = util.getSecret(currentTime, "web");
            secretData.type = 'admin-login';
            adminInstance.secrets.create(secretData, function(err, secretInstance){
              if(err){
                cb(util.getInternalServerError(err));
                return;
              }
              cb(null, {"secret":secretInstance.id, "admin":adminInstance, schoolId:adminInstance.school().id, "statusCode":200});
              return;
            });
          }else{
            cb(util.getGenericError("Error", "400", "Invalid password"));
            return;
          }
        })
      }else{
        cb(util.getGenericError("Error", "400", "Email not registered"));
        return;
      }
    });
  }

  Admin.remoteMethod(
    'login',
    {
      description: "login admin",
      accepts: [
        {arg: 'req', type: 'object', http: {source: 'req'}},
        {arg: 'credentials', type: 'object', http: {source: 'body'}}
      ],
      returns: {arg:'response',type:'object'},
      http: {path: '/login', verb: 'post'}
    }
  );
};
