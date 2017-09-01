'use strict';

var module = angular.module('config', []);


function createCookie(name,value,days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime()+(days*24*60*60*1000));
        var expires = "; expires="+date.toGMTString();
    }
    else var expires = "";
    document.cookie = name+"="+value+expires+"; path=/";
}
function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}
function eraseCookie(name) {
    createCookie(name,"",-1);
}

module.factory('ConstantsConfig',function(){
    return{
        getHostName:function(){
            return 'http://localhost:3000/api';
        }
    }
});


module.factory('CookieUtil', ['$rootScope', function ($rootScope) {
    return{
        createCookie: createCookie,

        readCookie: readCookie,

        eraseCookie: eraseCookie
    }
}]);


module.factory('AuthConfig', ['$rootScope', function ($rootScope) {
    return{
        getData:function(){
            return JSON.stringify({
                "secret": readCookie('_secret'),
                "id": readCookie('_id'),
                "schoolId": readCookie('_sd'),
                "role": "admin"
            })
        }
    }
}]);

module.factory('ErrorHandler', ['$rootScope', function ($rootScope) {
    return{
        handle:function resourceErrorHandler(error){
            if(error && error.data && error.data.error && error.data.error.status == "403"){
                console.log(3)
                window.location.href = "/auth.html";
            }
        }
    }
}]);

module.factory('SessionData', ['$rootScope', function ($rootScope) {
    return {
        getSchoolId: function () {
            return readCookie('_sd');
        },
        getAdminId: function () {
            return readCookie('_id');
        },
        getRole: function () {
            return 'admin';
        }
    }
}]);


//
// module.factory('ConstantData', ['$rootScope', '$state', 'RateSlabs', 'DeliverySlots', 'PaymentModes', function ($rootScope, $state, RateSlabs, DeliverySlots, PaymentModes) {
//     var rateSlabs = {};
//     var deliverySlots = {};
//     var paymentModes = {};
//     var paymentCycles = {};
//     var feedbackTitles = {};
//     var businessNatures = {};
//     var skus = {};
//     return {
//         getRateSlabs: function () {
//             return rateSlabs;
//         },
//         getBusinessNatures: function () {
//             return businessNatures;
//         },
//         getDeliverySlots: function () {
//             return deliverySlots
//         },
//         getPaymentModes: function () {
//             return paymentModes;
//         },
//         getFeedbackTitles: function () {
//             return feedbackTitles;
//         },
//         getPaymentCycles: function () {
//             return paymentCycles;
//         },
//         setPaymentCycles: function (a) {
//             paymentCycles = a;
//         },
//         setRateSlabs: function (a) {
//             rateSlabs = a;
//         },
//         setDeliverySlots: function (a) {
//             deliverySlots = a
//         },
//         setPaymentModes: function (a) {
//             paymentModes = a;
//         },
//         setFeedbackTitles: function (a) {
//             feedbackTitles = a;
//         },
//         setBusinessNatures: function (a) {
//             businessNatures = a;
//         },
//         setSkus: function (a) {
//             skus = a;
//         },
//         getSkus: function () {
//             return skus;
//         }
//     }
// }]);
//
//

module.factory('SettingData', ['$rootScope', 'Purchasers', 'SessionData', 'ConstantData',
    function ($rootScope, Purchasers, SessionData, ConstantData) {

        var admin = {};
        var school = {};

        return {
            getAdmin: function () {
                return admin;
            },
            setAdmin: function (a) {
                admin = a;
                $rootScope.admin = a;
            },
            getSchool: function () {
                return school;
            },
            setSchool: function (a) {
                school = a;
                $rootScope.school = a;
            }
        };
    }]);
