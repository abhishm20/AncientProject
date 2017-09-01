'use strict';

angular.module('DBAdmin', [
  'ngAnimate',
  'ui.bootstrap',
  'ui.sortable',
  'ui.router',
  'ngTouch',
  'toastr',
  'smart-table',
  "xeditable",
  'ui.slimscroll',
  'ngJsTree',
  'angular-progress-button-styles',
    'ngTable',
  'angularMoment',

    'angular.morris-chart',
    'nvd3',
  'DBAdmin.directive',
  'DBAdmin.theme',
  'DBAdmin.pages'
])
    .controller('SetupController', ['$scope', '$state', '$rootScope', '$location', 'SessionData', 'Admins', 'AuthConfig', 'CookieUtil',

    function ($scope, $state, $rootScope, $location, SessionData, Admins, AuthConfig, CookieUtil) {

      console.log(SessionData.getAdminId())
      console.log(SessionData.getSchoolId())
        if(!(SessionData.getAdminId() || SessionData.getSchoolId())){
            alert(1)
            window.location.href = "/auth.html";
        }

        Admins.get({id:SessionData.getAdminId(), filter: JSON.stringify({include:["school"]})}, function (data) {
            console.log(data)
            alert(2)
            if(data && data.response){
                SettingData.setAdmin(data.response);
            }else{
                window.location.href = "/auth.html";
            }
        }, function (err) {
            console.log(err)
        });
    }
]);