var refresh = require('google-refresh-token');


var mailConfig = {
    email:"contact@daybox.in",
    refreshToken: "1/50r51AqZPDumLeiCZ1Um5B4Omi82DCF-pqbuA2IZVUEMEudVrK5jSpoR30zcRFq6",
    clientid: "511024988743-bigi3s2fub88j6ciok8m8mbk4kedr2iq.apps.googleusercontent.com",
    clientSecret: "Eof_w_hi4s4UfgEdJl9yIKQ-"
}
module.exports = {
    getCredentials : function(cb){
        refresh(mailConfig.refreshToken, mailConfig.clientid, mailConfig.clientSecret, function (err, json, res) {
            if(!err){
                mailConfig.accessToken = json.accessToken;
                cb(mailConfig)
            }
        });
    }
}
