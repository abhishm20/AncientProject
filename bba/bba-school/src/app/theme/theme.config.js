/**
 * Created by k.danovsky on 13.05.2016.
 */

(function () {
  'use strict';

  angular.module('DBAdmin.theme')
    .config(config);

  /** @ngInject */
  function config(baConfigProvider, colorHelper) {
    //baConfigProvider.changeTheme({blur: true});
    //
    baConfigProvider.changeColors({
     default: 'rgba(#F0F3F4, 0.2)',
     defaultText: '#ffffff',
     dashboard: {
       white: '#F0F3F4',
     },
    });
  }
})();
