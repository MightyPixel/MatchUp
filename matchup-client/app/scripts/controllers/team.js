'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:TeamCtrl
 * @description
 * # TeamCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
  .controller('TeamCtrl', function ($scope) {
    $scope.availablePlayers = ['Ivan Ivanov', 'Martin Petrov', 'Valeri Nikolov', 'Nikolai Stefanov'];
	
	$scope.selectedPlayers = [];
	$scope.selectPlayer = function(player){
		if (!_.find($scope.selectedPlayers, function(plr) { plr == player; })) {
			 $scope.selectedPlayers.push(player);
		}
	}
	$scope.playDates = [{}];
	$scope.addPlayDate = function(playTime){
		$scope.playDates[$scope.playDates.length - 1] = playTime;
		$scope.playDates.push({});
	}
	
	$scope.removePlayDate = function(playDate) {
		var index = $scope.playDates.indexOf(playDate);
		if (index > -1) {
			 $scope.playDates.splice(index, 1);
		}

	}
	
	
	
	});
