var _ = require('lodash')
var util = require('../util');
var async = require('async');

module.exports = function(School) {

  util.disableAllMethodsBut(School, ['create', 'updateAttributes', 'findById', 'deleteById', 'find']);



  School.beforeRemote('create', function(ctx, unused, next) {
    var data = ctx.req.body;
    if(_.isEmpty(data)){
      next(util.getGenericError('Error: Empty Request', 400, 'Couldn\'t process empty request'));
      return;
    }
    School.findOne({where: {name: data.name}}, function(err, foundInstance){
      if(foundInstance && foundInstance.id && foundInstance.name == data.name && foundInstance.branch == data.branch){
        next(util.getGenericError("Error: Already Exist", 400, data.name+' already exists with same branch'));
        return;
      }
      School.app.models.Admin.findOne({where: {email: data.admin.email}}, function(err, foundInstance){
        if(foundInstance && foundInstance.id){
          next(util.getGenericError("Error", 400, data.admin.email+' already exists'));
          return;
        }
        ctx['admin'] = data.admin;
        delete data.admin;
        next();
      });
      ctx['admin'] = data.admin;
      delete data.admin;
      next();
    });
  });

  School.afterRemote('create', function (ctx, instance, next) {
    var currentTime = new Date();
    var data = ctx.admin;
    if(instance && data){
      if(data.password){
        util.cryptPassword(data.password, function (err, hashedPassword) {
          data.password = hashedPassword;
          instance.admins.create(data, function (err, adminInstance) {
            if(err){
              instance.destroy();
              next(util.getInternalServerError(err));
              return;
            }
            var secretData = util.getSecret(currentTime);
            secretData.type = 'register-login';
            adminInstance.secrets.create(secretData, function (err, secretInstance) {
              if(err){
                next(util.getGenericError("Error", 400, "Sorry Could not create Account"));
                return;
              }
              ctx.result = {role: 'admin', secret: secretInstance.id, adminId: adminInstance.id, schoolId: instance.id}
              next();
              return;
            })
          })
        });
      }else{
        instance.destroy();
        next(util.getGenericError("Error", 400, "Password is required"));
        return;
      }
    }else{
      next();
    }
  });

};
