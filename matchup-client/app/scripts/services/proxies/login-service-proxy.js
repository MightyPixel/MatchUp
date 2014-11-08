'use strict';

angular.module('matchupApp')
.service('loginServiceProxy', function($http, APP_CONFIG) {
    return {
        login: function(username, password) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'login/login', {
                    username: username,
                   password: password,
                   rememberMe: false
            }, {
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            });
        },

        getAuthenticatedUser: function() {
            return $http.get(APP_CONFIG.serviceBaseUrl + 'login/authenticated');
        },

        logout: function() {
            return $http.get(APP_CONFIG.serviceBaseUrl + 'logout', {
            });
        },
    };
});

