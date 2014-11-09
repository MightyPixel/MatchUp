'use strict';

angular.module('matchupApp')
.service('teamServiceProxy', function($http, auth, APP_CONFIG) {
    return {
        create: function(game) {
            return $http.post(APP_CONFIG.serviceBaseUrl + 'team/create/' + auth.getPlayerId()
, game, {
                headers: {'Content-Type': 'application/json'},
            });
        },

        getMatchingTeams: function(gameId, eventId, accept) {
            return $http.get(APP_CONFIG.serviceBaseUrl + 'timeline/find', {
                params: {
                    playerId: auth.getPlayerId()
                }
            });
        },

 
    };
});

