'use strict';

describe('Directive: timelineItem', function () {

  // load the directive's module
  beforeEach(module('matchupApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<timeline-item></timeline-item>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the timelineItem directive');
  }));
});
