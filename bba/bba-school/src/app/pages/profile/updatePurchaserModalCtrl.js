/**
* @author abhishek.sharma
* created on 24.05.2016
*/
(function () {
    'use strict';

    angular.module('DBAdmin.pages.profile')
    .controller('UpdatePurchaserModalCtrl', UpdatePurchaserModalCtrl);

    /** @ngInject */
    function UpdatePurchaserModalCtrl($scope, $state, toastr, $uibModalInstance, param, SessionData, Purchasers) {
        $scope.purchaser = param.purchaser;
        
        $scope.update = function () {
            Purchasers.update({id:$scope.purchaser.id}, $scope.purchaser, function(data){
                toastr.success( $scope.purchaser.name+" updated successfully");
                $uibModalInstance.close();
                $state.go('profile', {}, {reload: true});
            }, function (err) {
                toastr.error(err.data.error.message);
            })
        }
    }

})();
