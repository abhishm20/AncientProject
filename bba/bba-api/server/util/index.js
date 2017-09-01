'use strict'
// built in package, used for generating accessToken
var uuid = require('node-uuid');
var constants = require('./constants');
var moment = require('moment');
// var pushNotify = require('./pushNotify');
var bcrypt = require('bcrypt');
var Hashids = require("hashids");
var orderHashId = new Hashids("daybox_secret",6, '0123456789ABCDEF');
// qrCodeHashId = new Hashids("ainaa007QrCode",30);


module.exports = {

    getGenericError : function(name, statusCode, message){
        var error = new Error(message);
        error.name = name;
        error.statusCode = statusCode;
        return error;
    },

    getInternalServerError : function(err)
    {
        console.log(err);
        var error = new Error('Something went wrong, make a retry !');
        error.statusCode = 500;
        error.name = "Oh Ah";
        return err;
    },

    getOtp : function(){
        return Math.floor(Math.random() * (constants.MOBILE_OTP_HIGH - constants.MOBILE_OTP_LOW) + constants.MOBILE_OTP_LOW);
    },

    addTime : function(currentTime, duration){
        return new Date(currentTime.getTime() + duration);
    },


    getSecret : function(currentTime){
        var secret = {
            id : uuid.v1()
        }
        secret.expiry = new Date(currentTime.getTime() + constants.MOBILE_SECRET_TTL);
        return secret;
    },

    getCashback : function(amount){
        if(amount >= 10000 && amount < 25000){
            return 2;
        }else if(amount >= 25000 && amount < 50000){
            return 3;
        }else if(amount >= 50000){
            return 5;
        }
        return 0;
    },

    isStatusChangeable:  function(currentStatus){
        switch (currentStatus) {
            case 'recieved':
            case 'placed':
            case 'changed':
                return true;
            case 'packed':
            case 'dispatched':
            case 'delivered':
                return false;
            default:
                return false;
        }
    },

    getOrderNextStatus : function(current){
        switch (current) {
            case 'placed':
            case 'changed':
                return 'packed';
            case 'packed':
                return 'dispatched';
            case 'dispatched':
                return 'delivered';
            default:
                return '';
        }
    },

    getOrderId : function(){
        return (new Date().getTime()+"");
    },

    getNextWeekDays: function(freezeTime, daysPlan){
        var availableOrderSlot = [];
        var count = 1;
        var extraPrice = 0;
        var extraChargeName = '';
        var isActive = true
        for(count =1; count<8; count++){
            var currentDay = moment().startOf('day').add(count,'days')
            var weekDay = (currentDay.format('d')-1)<0?6:currentDay.format('d')-1
            if(daysPlan[weekDay] == 'y'){
                isActive  = true;
                extraPrice = 0;
            }else if(daysPlan[weekDay] == 'n'){
                isActive  = false;
                extraPrice = 0;
            }else{
                isActive = true;
                extraPrice = parseInt(daysPlan[weekDay]);
            }
            if(extraPrice){
                extraChargeName = 'Delivery';
            }else{
                extraChargeName = ''
            }
            availableOrderSlot.push({
                "day":currentDay.format('dddd'),
                "isActive": isActive,
                "date":currentDay.format('DD-MM-YYYY'),
                "extraChargeAmount":extraPrice,
                "extraChargeName":extraChargeName
            });
        }
        availableOrderSlot[0]['day']="Tomorrow";
        var hourLimit = freezeTime.split(":")[0];
        var minLimit = freezeTime.split(":")[1];
        var currentHour = moment().format("HH");
        var currentMin = moment().format("mm");
        if(hourLimit < currentHour && minLimit < currentMin){
            availableOrderSlot[0]['isActive'] = false;
        }
        return availableOrderSlot;
    },

    getLastMonths: function(orderTime){
        var lastMonths = [];
        var count = 1;
        for(count =1; count<12; count++){
            var currentMonth = moment().startOf('month').subtract(count-1, 'months');
            lastMonths.push({
                "name":currentMonth.format('MMMM YYYY'),
                "key": currentMonth.format('MMMM YYYY'),
            });
        }
        return lastMonths;
    },

    cryptPassword : function(password, callback) {
       bcrypt.genSalt(10, function(err, salt) {
           if (err) {
             return callback(err);
           }
           bcrypt.hash(password, salt, function(err, hash) {
               return callback(err, hash);
           });
       });
   },




   comparePassword : function(password, userPassword, callback) {
      bcrypt.compare(password, userPassword, function(err, isPasswordMatch) {
         if (err)
           return callback(err);
         return callback(null, isPasswordMatch);
      });
   },

    disableAllMethodsBut: function (model, methodsToExpose)
    {
        if(model && model.sharedClass)
        {
            methodsToExpose = methodsToExpose || [];

            var modelName = model.sharedClass.name;
            var methods = model.sharedClass.methods();
            var relationMethods = [];
            var hiddenMethods = [];

            try
            {
                Object.keys(model.definition.settings.relations).forEach(function(relation)
                {
                    relationMethods.push({ name: '__findById__' + relation, isStatic: false });
                    relationMethods.push({ name: '__destroyById__' + relation, isStatic: false });
                    relationMethods.push({ name: '__updateById__' + relation, isStatic: false });
                    relationMethods.push({ name: '__exists__' + relation, isStatic: false });
                    relationMethods.push({ name: '__link__' + relation, isStatic: false });
                    relationMethods.push({ name: '__get__' + relation, isStatic: false });
                    relationMethods.push({ name: '__create__' + relation, isStatic: false });
                    relationMethods.push({ name: '__update__' + relation, isStatic: false });
                    relationMethods.push({ name: '__destroy__' + relation, isStatic: false });
                    relationMethods.push({ name: '__unlink__' + relation, isStatic: false });
                    relationMethods.push({ name: '__count__' + relation, isStatic: false });
                    relationMethods.push({ name: '__delete__' + relation, isStatic: false });
                });
            } catch(err) {}

            methods.concat(relationMethods).forEach(function(method)
            {
                var methodName = method.name;
                if(methodsToExpose.indexOf(methodName) < 0)
                {
                    hiddenMethods.push(methodName);
                    model.disableRemoteMethod(methodName, method.isStatic);
                }
            });

            if(hiddenMethods.length > 0)
            {
                console.log('\nRemote mehtods hidden for', modelName, ':', hiddenMethods.join(', '), '\n');
            }
        }
    }
}
