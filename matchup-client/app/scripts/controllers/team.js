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
	/*$scope.selectedPlayers = ['Ivan Ivanov', 'Martin Petrov', 'Valeri Nikolov', 'Nikolai Stefanov'];*/
	
	$scope.selectedPlayers = [];
	
	$scope.selectPlayer = function(player){
		if (!_.find($scope.selectedPlayers, function(plr) { plr == player; })) {
			 $scope.selectedPlayers.push(player);
		}
	}

	
  });
