/**
 * @author abhishek.sharma
 * created on 29.05.2016
 */
(function () {
    'use strict';

    angular.module('DBAdmin.pages.account')
        .controller('SalesCtrl', SalesCtrl);

    /** @ngInject */
    function SalesCtrl($scope, $filter, $state, $location, $element, toastr, $uibModal, moment, NgTableParams, SessionData, Clients, Outlets, Transactions, Sales) {

        $scope.newSale = {
            date : moment().format("DD-MM-YYYY"),
            createdAt : new Date().getTime()
        }
        $scope.sales = []
        Clients.get({id:SessionData.getClientId()}, function (data) {
            $scope.client = data.response;
            var startDate = new Date($scope.client.createdAt);
            var endDate = new Date();
            var sales = [];
            startDate = moment(startDate).startOf('day');
            endDate = moment(endDate).endOf('day');
            while(endDate >= startDate){
                $scope.sales.push({
                    date:startDate.format('DD-MM-YYYY'),
                    createdAt: startDate.valueOf(),
                    isNew: true
                })
                startDate = startDate.add(1, 'days');
            }

            Outlets.get({id: SessionData.getClientId(), filter: JSON.stringify({include:["sales"]})}, function (data) {
                $scope.outlets = data.response;
                $scope.outlets.forEach(function (outlet) {
                    outlet.sales.forEach(function (sale) {
                        for(var i=0; i<$scope.sales.length; i++){
                            $scope.sales[i][outlet.name] = $scope.sales[i][outlet.name] || {}
                            if(sale.date == $scope.sales[i].date && sale.amount && $scope.sales[i][outlet.name] && $scope.sales[i][outlet.name]){
                                $scope.sales[i][outlet.name]['amount'] = sale.amount;
                                $scope.sales[i][outlet.name]['isSet'] = true;
                            }
                        }
                    })
                })

                $scope.saleList =  new NgTableParams({count:20, sorting: { createdAt: "desc" }}, {counts:[], dataset: $scope.sales});
            }, function (err) {
                toastr.error(err.data.error.message);
                return;
            });
        })
        
        // $scope.add = function (t) {
        //     Sales.create({id: SessionData.getClientId()}, $scope.newSale, function (data) {
        //         $state.go('sales', {}, {reload: true});
        //     }, function (err) {
        //         toastr.error(err.data.error.message);
        //         return;
        //     });
        // }
        
        
        $scope.createSale = function (t, name, id) {
            console.log(t, name, id);
            var data = {
                date: t.date,
                createdAt: t.createdAt,
                amount: t[name]['amount']
            }
            Sales.create({id: id}, data, function (data) {
                toastr.success("Created !!!")
                $state.go('sales', {}, {reload: true});
            }, function (err) {
                toastr.error(err.data.error.message);
                return;
            });
        }
    }

})();
