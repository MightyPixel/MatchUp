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

	$scope.team = {};
	
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

    $scope.createTeam = function() {
        $scope.team.city = 'Sofia';
        $scope.team.membersIds = [
            '545f859c0364d80b37264a1f',
            '545f85bc0364d80b37264a20',
            '545f85d90364d80b37264a21'
        ];
        $scope.team.schedule = [
            {
                day: 'TUESDAY',
                    hour: 18
            },
            {
                day: 'THURSDAY',
                hour: 19
            }
        ]
        teamServiceProxy.create($scope.team).then(function(response){
            console.log(response.data);
            $location.url('/home');
        });
    };
});
