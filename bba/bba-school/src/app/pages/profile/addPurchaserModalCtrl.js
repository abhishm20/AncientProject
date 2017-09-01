/**
* @author abhishek.sharma
* created on 24.05.2016
*/
(function () {
    'use strict';

    angular.module('DBAdmin.pages.profile')
    .controller('AddPurchaserModalCtrl', AddPurchaserModalCtrl);

    /** @ngInject */
    function AddPurchaserModalCtrl($scope, $state, toastr, $uibModalInstance, param, Clients) {
        $scope.purchaser = {};
        
        $scope.create = function () {
            Clients.createPurchaser({id:param.clientId}, $scope.purchaser, function(data){
                toastr.success( $scope.purchaser.name+" added successfully");
                $uibModalInstance.close();
                $state.go('profile', {}, {reload: true});
            }, function (err) {
                toastr.error(err.data.error.message);
            })
        }
    }

})();
