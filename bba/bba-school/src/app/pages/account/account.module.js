/**
* @author abhishek.sharma
* created on 29.05.2016
*/
(function () {
  'use strict';

  angular.module('DBAdmin.pages.account', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('account', {
          url: '/account',
          templateUrl: 'app/pages/account/account.html',
          title: 'Accounts',
          controller: 'AccountCtrl',
          sidebarMeta: {
            icon: 'ion-cash',
            order: 1,
          },
        });
  }

})();
