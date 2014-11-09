'use strict';

angular.module('matchupApp')
.service('eventServiceProxy', function($http, APP_CONFIG) {
    return {
        getTimelineEvents: function() {
            return $http.get(APP_CONFIG.serviceBaseUrl + 'events');
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

