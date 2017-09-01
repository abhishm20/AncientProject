/**
 * @author abhishek.sharma
 * created on 24.05.2016
 */
(function () {
    'use strict';

    angular.module('DBAdmin.pages.profile')
        .controller('AddManagerModalCtrl', AddManagerModalCtrl);

    /** @ngInject */
    function AddManagerModalCtrl($scope, $state, toastr, $uibModalInstance, SessionData, Clients) {
        $scope.manager = {};

        $scope.create = function () {
            Clients.createManager({id:SessionData.getClientId()}, $scope.manager, function(data){
                toastr.success( $scope.manager.name+" added successfully");
                $uibModalInstance.close();
                $state.go('profile', {}, {reload: true});
            }, function (err) {
                toastr.error(err.data.error.message);
            })
        }
    }

})();
