'use strict';

/**
 * @ngdoc directive
 * @name matchupApp.directive:enter
 * @description
 * # enter
 */
angular.module('matchupApp')
  .directive('myEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if(event.which === 13) {
                scope.$apply(function (){
                    scope.$eval(attrs.ngEnter);
                });

                event.preventDefault();
            }
        });
    };
 });