'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:GameCtrl
 * @description
 * # GameCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
.controller('GameCtrl', function ($scope) {

	$scope.msg = "hello";

	$scope.updateMsg = function() {
		console.log('CALLED');
		$scope.msg = "Hiii";
	}

});
