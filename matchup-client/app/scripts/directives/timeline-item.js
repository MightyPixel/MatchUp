'use strict';

/**
 * @ngdoc directive
 * @name matchupApp.directive:timelineItem
 * @description
 * # timelineItem
 */
angular.module('matchupApp')
  .directive('timelineItem', function () {
    return {
      templateUrl: 'views/directives/timeline-item.html',
      restrict: 'E',
      link: function postLink(scope, element, attrs) {
      }
    };
  });
