'use strict';

angular.module('misApp',[]).controller('articleCtrl', function($scope, $http) {
	var basicUrl = "http://localhost:8080/article/";
	$http.get(basicUrl)
	  .success(function (response) {
		  console.log('response:' + response);
		  $scope.list = response.list;
	  });
});


