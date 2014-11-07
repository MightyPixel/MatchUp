'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
