'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
