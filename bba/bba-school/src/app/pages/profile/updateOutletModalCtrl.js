/**
* @author abhishek.sharma
* created on 24.05.2016
*/
(function () {
    'use strict';

    angular.module('DBAdmin.pages.profile')
    .controller('UpdateOutletModalCtrl', UpdateOutletModalCtrl);

    /** @ngInject */
    function UpdateOutletModalCtrl($scope, $state, toastr, $uibModalInstance, param, SessionData, ConstantData, Outlets) {
        $scope.rateSlabs = ConstantData.getRateSlabs();
        $scope.deliverySlots = ConstantData.getDeliverySlots();

        $scope.outlet = param.outlet;

        $scope.update = function(){
            //check optional emails
            //$scope.outlet.emails = ($scope.outlet.emails && $scope.outlet.emails.length > 0) ? $scope.outlet.emails.split(',') : [];

            Outlets.update({id:SessionData.getClientId(), fk:param.outlet.id}, $scope.outlet, function(data){
                toastr.success( $scope.outlet.name+" updated successfully");
                $uibModalInstance.close();
                $state.go('profile', {}, {reload: true});
            }, function(error){
                 toastr.error(error.data.error.message);
            });
        }
    }
})();
