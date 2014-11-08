'use strict';

/**
 * @ngdoc directive
 * @name matchupApp.directive:showErrors
 * @description
 * # showErrors
 */
angular.module('matchupApp')
.directive('showErrors', function() {
    return {
        restrict: 'A',
        link: function(scope, el) {
            el.bind('blur', function() {
                var valid = // is valid logic
                el.toggleClass('has-error', valid);
            });
        }
    }
});
