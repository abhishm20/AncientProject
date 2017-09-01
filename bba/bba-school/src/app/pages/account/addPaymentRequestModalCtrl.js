/**
* @author abhishek.sharma
* created on 24.05.2016
*/
(function () {
    'use strict';

    angular.module('DBAdmin.pages.account')
    .controller('AddPaymentRequestModalCtrl', AddPaymentRequestModalCtrl);

    /** @ngInject */
    function AddPaymentRequestModalCtrl($scope, $state, toastr, moment, $uibModalInstance, param, ConstantData, SessionData, Clients) {
        $scope.outlets = param.outlets;
        $scope.date = new Date();
        $scope.request = {
            "date": moment().format("DD-MM-YYYY"),
            managerId: SessionData.getManagerId()
        };

        $scope.open = function() {
            $scope.popup.opened = true;
        };

        $scope.altInputFormats = ['d!/M!/yyyy'];

        $scope.popup = {
            opened: false
        };

        $scope.create = function(){
            $scope.request.date = moment($scope.date).format("DD-MM-YYYY");
            Clients.createPaymentRequest({id:SessionData.getClientId()}, $scope.request, function(data){
                toastr.success("Request created successfully");
                $uibModalInstance.close();
                $state.go('account', {}, {reload: true});
            }, function(error){
                 toastr.error(error.data.error.message);
            });
        }
    }
})();
