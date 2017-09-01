/**
* @author abhishek.sharma
* created on 29.05.2016
*/
(function () {
  'use strict';

  angular.module('DBAdmin.pages.sales', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('sales', {
          url: '/sales',
          templateUrl: 'app/pages/sales/sales.html',
          title: 'Sales',
          controller: 'SalesCtrl',
          sidebarMeta: {
            icon: 'ion-clipboard',
            order: 3,
          },
        });
  }

})();
