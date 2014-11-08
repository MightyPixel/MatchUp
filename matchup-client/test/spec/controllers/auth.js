'use strict';

describe('Controller: AuthCtrl', function () {

  // load the controller's module
  beforeEach(module('matchupApp'));

  var AuthCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AuthCtrl = $controller('AuthCtrl', {
      $scope: scope
    });
  }));
});
