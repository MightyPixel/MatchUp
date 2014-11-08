'use strict';

angular.module('matchupApp')
.service('loginServiceProxy', function($http, APP_CONFIG) {
    return {
        login: function(username, password) {
            return $http.get(APP_CONFIG.serviceBaseUrl + 'service/player/ivan', {
            }, {
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

