'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:AuthCtrl
 * @description
 * # AuthCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
.controller('AuthCtrl', function ($scope, $location, auth, playerServiceProxy) {
    $scope.isCoolUserName = false;

    $scope.login = function() {
        console.log('Logging in with the username/pass:');
        console.log($scope.username);
        console.log($scope.password);

        auth.loginUser($scope.username, $scope.password);

        $location.url('/home');
    };

    $scope.register = function() {
        playerServiceProxy.createPlayer($scope.player).then(function(response) {
            console.log(response);
            auth.setUser(response.data);
        });
    }

});
