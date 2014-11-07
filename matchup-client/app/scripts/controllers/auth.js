'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:AuthCtrl
 * @description
 * # AuthCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
  .controller('AuthCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $scope.login = function() {
        console.log($scope.username);
        console.log($scope.password);
    }
  });
