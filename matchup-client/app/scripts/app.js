'use strict';

/**
 * @ngdoc overview
 * @name matchupApp
 * @description
 * # matchupApp
 *
 * Main module of the application.
 */
angular
.module('matchupApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
])
.config(function ($routeProvider) {
$routeProvider
    .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
    })
    .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'AuthCtrl'
    })
    .when('/register', {
        templateUrl: 'views/register.html',
        controller: 'AuthCtrl'
    })
    .when('/create-game', {
        templateUrl: 'views/create-game.html',
        controller: 'GameCtrl'
    })
    .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
    })
    .otherwise({
        redirectTo: '/'
    });
});
