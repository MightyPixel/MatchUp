'use strict';

describe('Directive: enter', function () {

  // load the directive's module
  beforeEach(module('matchupApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<enter></enter>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the enter directive');
  }));
});
