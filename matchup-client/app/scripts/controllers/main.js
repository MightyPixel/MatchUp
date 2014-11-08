'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
.controller('MainCtrl', function ($scope, $location, auth) {

    $scope.isUserLogged = false;

    auth.registerObserverCallback('updateMain', function(user) {
        $scope.isUserLogged = (user != null);
        if ($scope.isUserLogged == false) {
            $location.url('/');
        }
    });

    $scope.logout = function() {
        auth.logout();
    };

    $scope.setActiveTab = function(tab) {
        $scope.activeTab = tab;
        $location.url('/' + tab);
    }

});
