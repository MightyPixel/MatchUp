'use strict';

/**
 * @ngdoc service
 * @name matchupApp.auth
 * @description
 * # auth
 * Service in the matchupApp.
 */
angular.module('matchupApp')
.service('auth', function auth($q, $rootScope, loginServiceProxy) {
    var user;

    function setUser(newUser) {
        var oldUser = user;
        user = newUser;
        $rootScope.currentLoggedUser = user;

        var userChanged = !angular.equals(oldUser, user);
        if (userChanged) {
            notifyObservers();
        }
    }

    var observerCallbacks = [];

    function notifyObservers() {
        angular.forEach(observerCallbacks, function(observer){
            if (!!user || observer.notifyIfNull) {
                observer.callback();
            }
        });
    }


    function updateUserResponse(response) {
        // TODO
        setUser(response);
    }

    function handleServiceError(response) {
        return $q.reject(response.data);
    }

    function getIsUserLogged() {
        return !!(user);
    }

    return {
        getIsUserLogged: getIsUserLogged,

        loginUser: function(username, password) {
            return loginServiceProxy.login(username, password).then(updateUserResponse, handleServiceError);
        },

        getHomeState: function() {
            if (!getIsUserLogged()) {
                return {name: 'login'};
            } else {
                return {name: 'unauthorized'};
            }
        },

    };
});
