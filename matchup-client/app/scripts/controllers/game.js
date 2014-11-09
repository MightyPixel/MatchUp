'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:GameCtrl
 * @description
 * # GameCtrl
 * Controller of the matchupApp
 */


angular.module('matchupApp')
.controller('GameCtrl', function ($scope, $location, gameServiceProxy) {

    $scope.today = function() {
        $scope.dt = new Date();
    };

    $scope.mytime = new Date();
    $scope.hstep = 1;
    $scope.mstep = 15;

    $scope.game = {};

    $scope.options = {
        hstep: [1, 2, 3],
        mstep: [1, 5, 10, 15, 25, 30]
    };

    $scope.ismeridian = true;
    $scope.toggleMode = function() {
        $scope.ismeridian = ! $scope.ismeridian;
    };

    $scope.update = function() {
        var d = new Date();
        d.setHours( 14 );
        d.setMinutes( 0 );
        $scope.mytime = d;
    };

    $scope.changed = function () {
        console.log('Time changed to: ' + $scope.mytime);
    };

    $scope.clear = function() {
        $scope.mytime = null;
    };
    $scope.today();

    $scope.clear = function () {
        $scope.dt = null;
    };

    // Disable weekend selection
    $scope.disabled = function(date, mode) {
        return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
    };

    $scope.toggleMin = function() {
        $scope.minDate = $scope.minDate ? null : new Date();
    };
    $scope.toggleMin();

    $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
    };
	
	$scope.chosenOpponent;
	$scope.chooseOponent = function(opponent) {
		$scope.chosenOpponent = opponent;
		
	}

    $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1
    };

    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
	
	$scope.team = 'My Team';
	$scope.teams = [
        { 'name': 'The 1337 Team', 'id': '545fa4fb03647959e2edb81d'}
    ];
	$scope.players = [
	{'name':'Ivan Ivanov', 'response': 'DENIED'}, 
	{'name':'Martin Petrov', 'response': 'PENDING'}, 
	{'name':'Valeri Nikolov', 'response': 'ACCEPTED'}, 
	{'name':'Nikolai Stefanov', 'response':'PENDING'}
	];
	
	$scope.opponentTeam = "Opponent Team";
	$scope.opponents = [
	{'name':'THE HATTERS', 'rank':'0', 'opponentId': '123' },
	{'name': 'The Cobras', 'rank':'37', 'opponentId': '123' },
	{'name': 'The Stones', 'rank': '98'}
	];
	$scope.opponentPlayers = $scope.players;
	$scope.isCollapsed = true;

	//$scope.players = ['Ivan Ivanov', 'Martin Petrov', 'Valeri Nikolov', 'Nikolai Stefanov'];
	$scope.places = [
        { name:'Sofia', gameFieldId: '545f9f5a120d1c734f95cf2e'},
        { name: 'Plovdiv', gameFieldId: '124'},
        { name: 'Burgas', gameFieldId: '125'}
    ];

    $scope.create = function() {
        $scope.game.startDate = '1515557966523';
        $scope.game.gameFieldId = '545f9f5a120d1c734f95cf2e';
        $scope.game.challengerTeam = '545fa4fb03647959e2edb81d';
        $scope.game.challengedTeam = '545fb0ffedaf2c80d47b11a5';


        gameServiceProxy.create($scope.game).then(function(response) {
            console.log(response);
            $location.url('/game/' + '545fbb6c0364f0d75f80581a');
        });
    }

});

