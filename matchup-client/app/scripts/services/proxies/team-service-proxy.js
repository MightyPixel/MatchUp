'use strict';

angular.module('matchupApp')
.service('teamServiceProxy', function($http, APP_CONFIG) {
    return {
        create: function(game) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'team/create', game, {
                headers: {'Content-Type': 'application/json'}
            });
        },
    };
});

