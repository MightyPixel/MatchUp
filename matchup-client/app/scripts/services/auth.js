'use strict';

/**
 * @ngdoc service
 * @name matchupApp.auth
 * @description
 * # auth
 * Service in the matchupApp.
 */
angular.module('matchupApp')
.service('auth', function auth($q, $rootScope, $cookieStore, loginServiceProxy) {
    var user;

    function setUser(newUser) {
        user = newUser;

        if (user != null) {
            $cookieStore.put('playerId', user.id);
        } else {
            $cookieStore.remove('playerId');
        }

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
        return !!(user) || $cookieStore.get('playerId');;
    }

    return {
        getIsUserLogged: function() { isUserLogged() },
        setUser: function(user) { setUser(user); },

        loginUser: function(username, password) {
            // return loginServiceProxy.login(username, password).then(updateUserResponse, handleServiceError);
            updateUserResponse({
                'firstName': 'Rupert',
                'lastName': 'Bear',
            });
        },

        getPlayerId: function() {
            return $cookieStore.get('playerId') || user.id;
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
