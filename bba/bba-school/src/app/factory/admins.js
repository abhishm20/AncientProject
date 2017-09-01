/**
 * @author abhishek.sharma
 * created on 29.05.2016
 */

(function () {
    'use strict';

    angular.module('dbResource')

        .factory('Admins', function($resource, ConstantsConfig, AuthConfig, ErrorHandler) {
            var Admins = $resource(
                ConstantsConfig.getHostName()+'/Admins/:id',
                {id: "@id"},
                {
                    get : {
                        method: "GET",
                        headers: { 'Authorization': AuthConfig.getData()},
                        interceptor : {responseError : ErrorHandler.handle}
                    },
                    create : {
                        method: "POST",
                        headers: { 'Authorization': AuthConfig.getData()},
                        interceptor : {responseError : ErrorHandler.handle}
                    },
                    update : {
                        method: "PUT",
                        headers: { 'Authorization': AuthConfig.getData()},
                        interceptor : {responseError : ErrorHandler.handle}
                    },
                    delete : {
                        method: "DELETE",
                        headers: { 'Authorization': AuthConfig.getData()},
                        interceptor : {responseError : ErrorHandler.handle}
                    }
                }
            );
            return Admins;
        });
})();
