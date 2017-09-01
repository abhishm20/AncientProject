/**
* @author abhishek.sharma
* created on 29.05.2016
*/
(function () {
  'use strict';

  angular.module('DBAdmin.pages.purchases', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('purchases', {
          url: '/purchases',
          templateUrl: 'app/pages/purchases/purchases.html',
          title: 'Purchases',
          controller: 'PurchasesCtrl',
          sidebarMeta: {
            icon: 'ion-ios-cart',
            order: 2,
          },
        });
  }

})();
