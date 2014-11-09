'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:TeamCtrl
 * @description
 * # TeamCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
  .controller('TeamCtrl', function ($scope, $location, teamServiceProxy) {
    $scope.availablePlayers = [
        {name: 'Ivan Nakov', id:''},
        {name: 'Ivan Stoichkov', id:''},
        {name: 'Andreya Kostov', id:''},
        {name: 'Adriana Stefanova', id:''},
        {name: 'Albert Einstein', id:'' }
    ];
	
	$scope.selectedPlayers = [];
	$scope.selectPlayer = function(player){
		if (!_.find($scope.selectedPlayers, function(plr) { plr.name == player.name; })) {
			 $scope.selectedPlayers.push(player);
		}
	};

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

	$scope.createGame = function() {
        var team = {
            teamName: 'TUES',
            city: 'Sofia',
            membersIds: [
                '',
                '',
                ''
            ],
            schedule: [
                {
                    day: 'TUESDAY',
                    hour: 18
                },
                {
                    day: 'THURSDAY',
                    hour: 19
                }
            ]
        };
        teamServiceProxy.create(team).then(function(response){
            console.log(response.data);
            $location.url('/home');
        });
    };
});
