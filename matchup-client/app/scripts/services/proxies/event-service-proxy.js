'use strict';

angular.module('matchupApp')
.service('eventServiceProxy', function($http, APP_CONFIG) {
    return {
        getTimelineEvents: function(id) {
            return $http.get(APP_CONFIG.serviceBaseUrl + 'timeline/find', {
                params: {
                    playerId: id
                }
            });
        },

        invitationResponse: function(game, response) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'game/invitation-response', {
                game: game,
                response: response
            });
        },

// rate game - game, score
    };
});

