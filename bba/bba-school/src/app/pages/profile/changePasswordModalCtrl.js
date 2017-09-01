/**
 * @author abhishek.sharma
 * created on 24.05.2016
 */
(function () {
    'use strict';

    angular.module('DBAdmin.pages.profile')
        .controller('ChangePasswordModalCtrl', ChangePasswordModalCtrl);

    /** @ngInject */
    function ChangePasswordModalCtrl($scope, $state, toastr, $uibModalInstance, param, Managers) {
        //$scope.newOutlets = [];
        $scope.manager = param.manager;
        $scope.data = {};
        
        $scope.update = function () {
            if($scope.data.newPassword != $scope.data.confirmPassword){
                toastr.info("Password didn't match");
                return;
            }
            Managers.updatePassword({id: $scope.manager.id}, $scope.data, function (data) {
                toastr.success("Successfully Changed");
                $uibModalInstance.close();
                $state.go('profile', {}, {reload: true});
            }, function (err) {
                toastr.error(err.data.error.message);
            });
        }
        
    }
})();
