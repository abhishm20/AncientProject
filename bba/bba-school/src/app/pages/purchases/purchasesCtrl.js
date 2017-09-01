/**
 * @author abhishek.sharma
 * created on 29.05.2016
 */
(function () {
    'use strict';

    angular.module('DBAdmin.pages.purchases')
        .controller('PurchasesCtrl', PurchasesCtrl);

    /** @ngInject */
    function PurchasesCtrl($scope, $filter, $state, $location, $element, toastr, $uibModal, $stateParams, SessionData, NgTableParams, Outlets) {

        Outlets.get({id: SessionData.getClientId(), filter: JSON.stringify({include:"client"}), include:"purchases"}, function (data) {
            $scope.outlets = data.response;
            if($scope.outlets.length > 0){
                $scope.outlets.forEach(function (outlet) {
                        outlet.purchases = new NgTableParams({count:15, sorting: { createdAt: "desc" }}, {counts:[], dataset: outlet.purchases});
                })
            }
        }, function (err) {
            toastr.error(err.data.error.message);
        });
        
        $scope.checkInvoice = function (purchase) {
            $uibModal.open({
                animation: true,
                templateUrl: 'app/pages/purchases/checkInvoiceModal.html',
                windowClass: "large-Modal",
                controller: 'CheckInvoiceModalCtrl',
                resolve: {
                    param: function () {
                        return {'data':"Invoice of Order (Delivery Date: "+purchase.deliveryDate + ", Order ID: "+ purchase.orderId+")",
                        "link":purchase.mergedLink};
                    }
                }
            });
        }
    }

})();
