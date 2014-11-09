'use strict';

angular.module('matchupApp')
.service('eventServiceProxy', function($http, auth, APP_CONFIG) {
    return {
        getTimelineEvents: function() {
            return $http.get(APP_CONFIG.serviceBaseUrl + 'timeline/find', {
                params: {
                    playerId: auth.getPlayerId()
                }
            });
        },

        invitationResponse: function(gameId, eventId, accept) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'game/invitation', {
                gameId: gameId,
                eventId: eventId,
                accept: accept
            });
        }
    };
});

