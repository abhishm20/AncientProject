var util = require('../util');

module.exports = function(Secret) {

  function softDelete(id, cb) {
    var cb = cb || function(){};
    id = this.id || id;
    Secret.findById(id, function(err, instance){
      if(err){
        cb(util.getInternalServerError(err));
        return;
      }
      if(instance && instance.id) {
        instance.isDeleted = true;
        instance.save();
        cb(null, {count:1});
      }else{
        cb(util.getGenericError("Error: Not Found", 404, "Secret Not Found"));
      }
    });
  }
  /*
   * Built-in Methods override
   * */
  Secret.on('dataSourceAttached', function(obj){
    Secret.deleteById = softDelete;
    Secret.prototype.destroy = softDelete;
    Secret.prototype.destroyAll = softDelete;
  });


  /*
   * Operation hooks
   * */


  Secret.observe('before save', function updateTimestamps(ctx, next) {
    if (ctx.isNewInstance) {
      ctx.instance.createdAt = new Date().getTime();
    } else {
      if(ctx.instance)
        ctx.instance.updatedAt = new Date().getTime();
      if(ctx.data)
        ctx.data.updatedAt = new Date().getTime();
    }
    next();
  });


  /*
   * Remote Methods
   * */
};
