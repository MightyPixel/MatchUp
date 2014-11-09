'use strict';

/**
 * @ngdoc directive
 * @name matchupApp.directive:timelineItem
 * @description
 * # timelineItem
 */
angular.module('matchupApp')
.directive('timelineItem', function ($location, gameServiceProxy) {
    return {
        scope: {
            event: '='
        },
        templateUrl: 'views/directives/timeline-item.html',
        restrict: 'E',
        link: function postLink(scope, element, attrs) {

        },
        controller: function($scope) {
            $scope.goToGame = function() {
                $location.url('/game/' + $scope.event.id);
            },

            $scope.score = function() {
                gameServiceProxy.declareScore($scope.event.gameId, $scope.gameScore).then(function(response) {
                    console.log(response);
                });
            }
        }
    };
});
