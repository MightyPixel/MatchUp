'use strict';

/**
 * @ngdoc directive
 * @name matchupApp.directive:timelineItem
 * @description
 * # timelineItem
 */
angular.module('matchupApp')
.directive('timelineItem', function ($location) {
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
                $location.url('/game/' + event.id);
            }
        }
    };
});
