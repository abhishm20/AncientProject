/**
* @author abhishek.sharma
* created on 29.05.2016
*/
(function () {
  'use strict';

  angular.module('DBAdmin.pages.dashboard', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('dashboard', {
          url: '/dashboard',
          templateUrl: 'app/pages/dashboard/dashboard.html',
          title: 'Dashboard',
          controller: 'DashboardCtrl',
          sidebarMeta: {
            icon: 'ion-stats-bars',
            order: 0,
          },
        });
  }

})();
