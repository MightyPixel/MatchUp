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

        notifyObservers(user);
    }

    var observerCallbacks = [];

    function notifyObservers(user) {
        _.each(observerCallbacks, function(observer){
            observer.callback(user);
        });
    }

    function updateUserResponse(response) {
        console.log(response);
        setUser(response);
    }

    function handleServiceError(response) {
        return $q.reject(response.data);
    }

    function isUserLogged() {
        return !!(user);
    }

    return {
        getIsUserLogged: function() { isUserLogged() },

        loginUser: function(username, password) {
            // return loginServiceProxy.login(username, password).then(updateUserResponse, handleServiceError);
            updateUserResponse({
                'firstName': 'Rupert',
                'lastName': 'Bear',
            });
        },

        getHomeState: function() {
            if (!isUserLogged()) {
                return {name: 'login'};
            } else {
                return {name: 'unauthorized'};
            }
        },
        //register an observer
        registerObserverCallback: function(name, callback){
            if (!_.find(observerCallbacks, { name: name })) {
                observerCallbacks.push({
                    name: name,
                    callback: callback
                });
            }
        },

        logout: function() {
            setUser();
        },
    };
});
