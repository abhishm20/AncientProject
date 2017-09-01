/**
* @author abhishek.sharma
* created on 29.05.2016
*/
(function () {
    'use strict';

    angular.module('DBAdmin.pages.dashboard')
    .controller('DashboardCtrl', DashboardCtrl);

    /** @ngInject */
    function DashboardCtrl($scope, $filter, $state, $location, $element, toastr, $uibModal, $stateParams, SessionData, Admins, AuthConfig) {

        // $scope.date = {
        //     start: new Date().getTime()-(1000*60*60*24*30),
        //     end: new Date().getTime()
        // }
        //
        // $scope.open1 = function() {
        //     $scope.popup1.opened = true;
        // };
        //
        // $scope.altInputFormats = ['d!/M!/yyyy'];
        //
        // $scope.popup1 = {
        //     opened: false
        // };
        //
        // $scope.open2 = function() {
        //     $scope.popup2.opened = true;
        // };
        //
        // $scope.popup2 = {
        //     opened: false
        // };
        //
        //
        // $scope.getReport1 = function () {
        //     if($scope.date.start && $scope.date.start.getTime && $scope.date.start.getTime() && $scope.date.end && $scope.date.end.getTime && $scope.date.end.getTime()){
        //         Managers.getReport1({id: SessionData.getManagerId(), startDate:$scope.date.start.getTime(), endDate: $scope.date.end.getTime()}, function (data) {
        //             window.open(
        //                 data.response,
        //                 '_blank' // <- This is what makes it open in a new window.
        //             );
        //         }, function (err) {
        //             toastr.error(err.data.error.message);
        //         });
        //     }else{
        //         Managers.getReport1({id: SessionData.getManagerId()}, function (data) {
        //             window.open(
        //                 data.response,
        //                 '_blank' // <- This is what makes it open in a new window.
        //             );
        //         }, function (err) {
        //             toastr.error(err.data.error.message);
        //         });
        //     }
        // }
        //
        // $scope.getReport2 = function () {
        //     if($scope.date.start && $scope.date.start.getTime && $scope.date.start.getTime() && $scope.date.end && $scope.date.end.getTime && $scope.date.end.getTime()){
        //         Managers.getReport2({id: SessionData.getManagerId(), startDate:$scope.date.start.getTime(), endDate: $scope.date.end.getTime()}, function (data) {
        //             window.open(
        //                 data.response,
        //                 '_blank' // <- This is what makes it open in a new window.
        //             );
        //         }, function (err) {
        //             toastr.error(err.data.error.message);
        //         });
        //     }else{
        //         Managers.getReport2({id: SessionData.getManagerId()}, function (data) {
        //             window.open(
        //                 data.response,
        //                 '_blank' // <- This is what makes it open in a new window.
        //             );
        //         }, function (err) {
        //             toastr.error(err.data.error.message);
        //         });
        //     }
        // }
        //
        // $scope.updateGraph = function () {
        //     if($scope.date.start && $scope.date.start.getTime && $scope.date.start.getTime() && $scope.date.end && $scope.date.end.getTime && $scope.date.end.getTime()){
        //         Clients.getSalesPurchaseData({id: SessionData.getClientId(), startDate:$scope.date.start.getTime(), endDate: $scope.date.end.getTime()},function (data) {
        //             $scope.graph1.setData(data.response.data);
        //         }, function (err) {
        //             toastr.error(err.data.error.message);
        //         })
        //         Clients.getAmountKgData({id: SessionData.getClientId(), startDate:$scope.date.start.getTime(), endDate: $scope.date.end.getTime()},function (data) {
        //             $scope.graph2.setData(data.response.data);
        //         }, function (err) {
        //             toastr.error(err.data.error.message);
        //         })
        //     }else{
        //         Clients.getSalesPurchaseData({id: SessionData.getClientId()},function (data) {
        //             $scope.graph1.setData(data.response.data);
        //         }, function (err) {
        //             toastr.error(err.data.error.message);
        //         })
        //         Clients.getAmountKgData({id: SessionData.getClientId()},function (data) {
        //             $scope.graph2.setData(data.response.data);
        //         }, function (err) {
        //             toastr.error(err.data.error.message);
        //         })
        //     }
        // }
        //
        // function xLabel(x) {
        //     return x.label.substr(0,5);
        // }
        //
        // Clients.getSalesPurchaseData({id: SessionData.getClientId()},function (data) {
        //     $scope.graph1 = new Morris.Line({
        //         element: 'graph1',
        //         data:data.response.data,
        //         xkey:'dateValue',
        //         xLabelFormat: xLabel,
        //         ykeys:data.response.outlets,
        //         labels:data.response.outlets,
        //         parseTime: false
        //     })
        // }, function (err) {
        //     toastr.error(err.data.error.message);
        // })
        //
        //
        // Clients.getAmountKgData({id: SessionData.getClientId()},function (data) {
        //     $scope.graph2 =  new Morris.Line({
        //         element: 'graph2',
        //         data:data.response.data,
        //         xkey:'dateValue',
        //         xLabelFormat: xLabel,
        //         ykeys:data.response.outlets,
        //         labels:data.response.outlets,
        //         parseTime: false
        //     })
        // }, function (err) {
        //     toastr.error(err.data.error.message);
        // })
        
    }

})();
