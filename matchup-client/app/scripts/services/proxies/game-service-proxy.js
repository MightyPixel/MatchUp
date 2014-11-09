'use strict';

angular.module('matchupApp')
.service('gameServiceProxy', function($http, APP_CONFIG) {
    return {
        create: function(game) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'game/create', game, {
                headers: {'Content-Type': 'application/json'}
            });
        },

        update: function(game) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'game/update', game);
        },

        gameConfirmation: function(game) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'game/confirmation', {
                game: game
            });
        },
    };
});

