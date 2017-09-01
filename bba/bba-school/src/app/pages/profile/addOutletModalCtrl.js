/**
* @author abhishek.sharma
* created on 24.05.2016
*/
(function () {
    'use strict';

    angular.module('DBAdmin.pages.profile')
    .controller('AddOutletModalCtrl', AddOutletModalCtrl);

    /** @ngInject */
    function AddOutletModalCtrl($scope, $state, toastr, $uibModalInstance, param, ConstantData, Clients) {
        $scope.rateSlabs = ConstantData.getRateSlabs();
        $scope.deliverySlots = ConstantData.getDeliverySlots();

        $scope.outlet = {
            address:{state:"Delhi"}
        };

        $scope.create = function(){
            //check optional emails
            $scope.outlet.emails = ($scope.outlet.emails && $scope.outlet.emails.length > 0) ? $scope.outlet.emails.split(',') : [];

            Clients.createOutlet({id:param.clientId}, $scope.outlet, function(data){
                toastr.success( $scope.outlet.name+" added successfully");
                $uibModalInstance.close();
                $state.go('profile', {}, {reload: true});
            }, function(error){
                 toastr.error(error.data.error.message);
            });
        }
    }
})();
