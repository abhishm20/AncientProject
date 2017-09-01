/**
 * @author abhishek.sharma
 * created on 29.05.2016
 */
(function () {
    'use strict';

    angular.module('DBAdmin.pages.admins')
        .controller('AdminsCtrl', AdminsCtrl);

    /** @ngInject */
    function AdminsCtrl($scope, $filter, $state, $location, $element, toastr, $uibModal, $stateParams, NgTableParams, SessionData, Admins) {

        Admins.get({id:SessionData.getAdminId()}, function (data) {
            $scope.admins = data.response;
        }, function (err) {
            toastr.error(err.data.error.message);
        });
        //
        // $scope.makePaymentRequest = function () {
        //     Outlets.get({id: SessionData.getClientId()}, function (data) {
        //         $uibModal.open({
        //             animation: true,
        //             templateUrl: 'app/pages/account/addPaymentRequestModal.html',
        //             size: "md",
        //             controller: 'AddPaymentRequestModalCtrl',
        //             resolve: {
        //                 param: function () {
        //                     return {"outlets": data.response};
        //                 }
        //             }
        //         }); 
        //     }, function (err) {
        //         toastr.error(err.data.error.message);
        //     });
        // }
        //
        // $scope.export = function () {
        //     Clients.exportAccountExcel({id: SessionData.getClientId()}, function (data) {
        //         window.open(
        //             data.response,
        //             '_blank' // <- This is what makes it open in a new window.
        //         );
        //
        //     }, function (err) {
        //         toastr.error(err.data.error.message);
        //     })
        // }
    }

})();
