'use strict';

angular.module('misApp',[]).controller('headerController', function($scope, $window) {
	$scope.viewProjects = function() {
		console.log('entering about function:' );
		$window.location.href = '/views/projects.html';
			  
	};
});


