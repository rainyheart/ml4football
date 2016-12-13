'use strict';

angular.module('misApp',[]).controller('loginController', function($scope, $http, $window) {
	$scope.user = {};
	// $scope.formData.username = '';
	$scope.login = function() {
		console.log('entering login function:' + $scope.user.abc);
		var data = {"username":$scope.user.abc,"password":$scope.user.password};
		$scope.visible = false;
		$http.post("http://localhost:8080/login/",data)
		  .success(function (response) {
			  console.log('result:' + response.status);
			  if(response.status == "1"){
				  $window.location.href = '/views/news.html';
			  }else{
				  $scope.visible=!$scope.visible;
			  }
			  
		  });
	};
	
	
});


