'use strict';

angular.module('matchupApp')
.service('playerServiceProxy', function($http, APP_CONFIG) {
    return {
        createPlayer: function(player) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'player/create', player);
        },

    };
});

