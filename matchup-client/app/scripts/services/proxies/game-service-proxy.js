'use strict';

angular.module('matchupApp')
.service('gameServiceProxy', function($http, auth, APP_CONFIG) {
    return {
        create: function(game) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'game/create', game, {
                headers: {'Content-Type': 'application/json'}
            });
        },

        gameCancel: function(game) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'game/cancel', game, {
                headers: {'Content-Type': 'application/json'}
            });
        },

        gameConfirmation: function(game) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'game/confirmation', {
                game: game
            });
        },

        captainDecision: function(gameId, eventId, accept) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'game/captain-decision', {
                gameId: gameId,
                eventId: eventId,
                accept: accept
            });
        },

        declareScore: function(gameId, score) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'game/declare-score/' + auth.getPlayerId(), {
                gameId: gameId,
                gameScore: score
            });
        },
        // TODO: Add fields score Fields
    };
});

