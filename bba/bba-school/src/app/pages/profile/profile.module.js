/**
* @author abhishek.sharma
* created on 29.05.2016
*/
(function () {
  'use strict';

  angular.module('DBAdmin.pages.profile', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('profile', {
          url: '/profile',
          templateUrl: 'app/pages/profile/profile.html',
          title: 'Profile',
          controller: 'ProfileCtrl',
          sidebarMeta: {
            icon: 'ion-person',
            order: 4
          }
        });
  }

})();
