'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
.controller('HomeCtrl', function ($scope, eventServiceProxy) {
    eventServiceProxy.getTimelineEvents("545f8a10120d2ccbb4352308").then(function(response) {
        $scope.events = response.data;
        console.log(response.data);
    });
});
