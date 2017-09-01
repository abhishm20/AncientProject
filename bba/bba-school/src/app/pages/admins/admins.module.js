/**
* @author abhishek.sharma
* created on 29.05.2016
*/
(function () {
  'use strict';

  angular.module('DBAdmin.pages.admins', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('admins', {
          url: '/admins',
          templateUrl: 'app/pages/admins/admins.html',
          title: 'Admins',
          controller: 'AdminsCtrl',
          sidebarMeta: {
            icon: 'ion-cash',
            order: 1,
          },
        });
  }

})();
