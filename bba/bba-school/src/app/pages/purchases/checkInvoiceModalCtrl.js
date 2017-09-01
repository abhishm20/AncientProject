/**
 * @author abhishek.sharma
 * created on 24.05.2016
 */
(function () {
    'use strict';

    angular.module('DBAdmin.pages.purchases')
        .controller('CheckInvoiceModalCtrl', CheckInvoiceModalCtrl);

    /** @ngInject */
    function CheckInvoiceModalCtrl($sce, $scope, $state, toastr, $uibModalInstance, param) {
        $scope.trustSrc = function(src) {
            return $sce.trustAsResourceUrl(src);
        }
        $scope.title = param.data;
        $scope.link = param.link;

    }
})();
