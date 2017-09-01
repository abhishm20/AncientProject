/**
* @author abhishek.sharma
* created on 29.05.2016
*/
(function () {
    'use strict';

    angular.module('DBAdmin.pages.profile')
    .controller('ProfileCtrl', ProfileCtrl);

    /** @ngInject */
    function ProfileCtrl($scope, $filter, $state, $location, $element, toastr, $uibModal, $stateParams, RateSlabs, SessionData, ConstantData, Managers, Clients) {

        $scope.businessNatures = ConstantData.getBusinessNatures();
        $scope.paymentModes = ConstantData.getPaymentModes();
        $scope.rateSlabs = ConstantData.getRateSlabs();
        $scope.paymentCycles = ConstantData.getPaymentCycles();

        $scope.client = {};
        
        Clients.get({id:SessionData.getClientId(), filter: JSON.stringify({include:["managers", "outlets", "purchasers"]})}, function (data) {
            if(data.response && data.response.emails){
                data.response.emails = data.response.emails.join(", ")
            }
            $scope.client = data.response;
        }, function (err) {
            toastr.error(err.data.error.message);
        });

        Managers.get({id:SessionData.getManagerId()}, function (data) {
            $scope.manager = data.response;
        }, function(err){
            toastr.error(err.data.error.message);
        })





        $scope.addOutlet = function(){
            $uibModal.open({
                animation: true,
                templateUrl: 'app/pages/profile/addOutletModal.html',
                size: "lg",
                controller: 'AddOutletModalCtrl',
                resolve: {
                    param: function () {
                        return {'rateSlabs':$scope.rateSlab, 'clientId': SessionData.getClientId()};
                    }
                }
            });
        };

        $scope.addManager = function(){
            $uibModal.open({
                animation: true,
                templateUrl: 'app/pages/profile/addManagerModal.html',
                size: "md",
                controller: 'AddManagerModalCtrl'
            });
        };

        $scope.addPurchaser = function(){
            $uibModal.open({
                animation: true,
                templateUrl: 'app/pages/profile/addPurchaserModal.html',
                size: "md",
                controller: 'AddPurchaserModalCtrl',
                resolve: {
                    param: function () {
                        return {'clientId': SessionData.getClientId()};
                    }
                }
            });
        };
        
        $scope.updateOutlet = function (outlet) {
            $uibModal.open({
                animation: true,
                templateUrl: 'app/pages/profile/updateOutletModal.html',
                size: "lg",
                controller: 'UpdateOutletModalCtrl',
                resolve: {
                    param: function () {
                        return {'outlet': outlet};
                    }
                }
            });
        }
        
        $scope.updatePurchaser = function (purchaser) {
            $uibModal.open({
                animation: true,
                templateUrl: 'app/pages/profile/updatePurchaserModal.html',
                size: "md",
                controller: 'UpdatePurchaserModalCtrl',
                resolve: {
                    param: function () {
                        return {'purchaser': purchaser};
                    }
                }
            });
        }

        $scope.changePassword = function () {
            $uibModal.open({
                animation: true,
                templateUrl: 'app/pages/profile/changePasswordModal.html',
                size: "md",
                controller: 'ChangePasswordModalCtrl',
                resolve: {
                    param: function () {
                        return {'manager': $scope.manager};
                    }
                }
            });
        }
        
        $scope.assignOutlet = function (purchaser) {
            $uibModal.open({
                animation: true,
                templateUrl: 'app/pages/profile/assignOutletModal.html',
                size: "md",
                controller: 'AssignOutletModalCtrl',
                resolve: {
                    param: function () {
                        return {'purchaser': purchaser, 'outlets': $scope.client.outlets};
                    }
                }
            });
        }

    }

})();
