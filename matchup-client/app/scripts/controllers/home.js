'use strict';

/**
 * @ngdoc function
 * @name matchupApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the matchupApp
 */
angular.module('matchupApp')
.controller('HomeCtrl', function ($scope) {
    $scope.events = [
        {
            team: 'TUES',
            datetime: '11-11-2014 8:00 pm',
            status: 'INVITED',
            details: 'Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.'
        }
    ]
});
