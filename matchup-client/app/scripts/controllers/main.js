'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
.controller('MainCtrl', function ($scope, auth) {

    $scope.isUserLogged = false;

    auth.registerObserverCallback('updateMain', function() {
        $scope.isUserLogged = auth.isUserLogged();
    });

    $scope.logout = function() {
        auth.logout();
    }

});
