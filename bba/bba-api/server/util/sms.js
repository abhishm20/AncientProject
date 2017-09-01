var request = require('request');

const SMS_OPTION = "http://123.63.33.43/blank/sms/user/urlsmstemp.php?"+
                "username=dayboxtech&pass=kap@user!123&senderid=DAYBOX&dest_mobileno=MOBILE_HERE&"+
                "tempid=TEMP_ID_HERE&PARAMS_STRING";

module.exports = {
    send: function(mobile, templateId , params){
		var sms_option = SMS_OPTION;
		sms_option = sms_option.replace('MOBILE_HERE', mobile);
		sms_option = sms_option.replace('TEMP_ID_HERE', templateId);

        var paramString = "";
        for (i = 1; i <= params.length; i++) {
	    	paramString += "F" + i + "=" + params[i-1]+"&";
		}

		paramString = paramString.substring(0, paramString.length - 1);
		paramString = encodeURI(paramString);

		sms_option = sms_option.replace('PARAMS_STRING', paramString);

		request(sms_option, function (error, response, body){
			if (error){
				console.log(error);
			}
		});
	}
}
