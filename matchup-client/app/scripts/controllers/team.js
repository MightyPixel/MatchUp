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
<<<<<<< HEAD
	
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
		//console.log(playTime)
//		var d=document.getElementById("time");
//		d.innerHTML+="<div class=\"row\" id=\"time\"><select class=\"form-control\"><option>Monday</option><option>Tuesday</option><option>Wednesday</option><option>Thursday</option><option>Friday</option><option>Saturday</option><option>Sunday</option></select><timepicker class=\"time\" hour-step=\"1\" minute-step=\"1\" show-meridian=\"false\" ng-model=\"mytime\" ng-change=\"changed()\"></timepicker><button type=\"button\" class=\"btn btn-success\" onclick=\"addTime()\"><bold>+</bold></button></div>";
	}
	
=======

    $scope.selectedPlayers = [];

    $scope.selectPlayer = function(player){
        if (!_.find($scope.selectedPlayers, function(plr) { plr == player; })) {
            $scope.selectedPlayers.push(player);
        }
    }


    $scope.createTeam = function() {
        console.log(matchDate);
    }
>>>>>>> 4a942bed845f5c9ab8ce2f25c6d834adf6cf8f4c
});
