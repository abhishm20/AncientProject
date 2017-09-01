/**
 * @author abhishek.sharma
 * created on 24.05.2016
 */
(function () {
    'use strict';

    angular.module('DBAdmin.pages.profile')
        .controller('AssignOutletModalCtrl', AssignOutletModalCtrl);

    /** @ngInject */
    function AssignOutletModalCtrl($scope, $state, toastr, $uibModalInstance, param, Purchasers) {
        $scope.newOutlets = [];
        $scope.outlets = param.outlets;
        $scope.purchaser = JSON.parse(JSON.stringify(param.purchaser));

        $scope.isOne = false;
        $scope.remove = function(a){
            Purchasers.unlinkOutlet({id:param.purchaser.id, fk:a}, function (data) {
                toastr.success("Successfully removed");
                $scope.purchaser.outletIds.splice($scope.purchaser.outletIds.indexOf(a), 1);
            }, function(err){
                toastr.error(err.data.error.message);
            });
        }
        $scope.add = function(a){
            $scope.newOutlets.push({});
            $scope.isOne = true;
        }

        $scope.assign = function(){
            if($scope.newOutlets && $scope.newOutlets.length > 0){
                Purchasers.linkOutlet({id:param.purchaser.id, fk:$scope.newOutlets[0].id}, function (data) {
                    toastr.success("Successfully Assigned");
                    $uibModalInstance.close();
                    $state.go('profile', {}, {reload: true});
                }, function(err){
                    toastr.error(err.data.error.message);
                });
            }else{
                $uibModalInstance.close();
                $state.go('profile', {}, {reload: true});
            }
        }
    }
})();
