'use strict';

angular.module('misApp').controller('loginController',function($scope, $http) {
	$scope.user = {};
	// $scope.formData.username = '';
	$scope.login = function() {
		console.log('entering login function:' + $scope.user.username);
		var data = {"username":$scope.user.username,"password":$scope.user.password};
		$scope.visible = false;
		$http.post("http://localhost:8080/login/",data)
		  .success(function (response) {
			  console.log('result:' + response.status);
			  if(response.status == "1"){
				 $window.location.href = 'http://localhost:8080/admins/news/news.html';
				 // $state.go('news');
			  }else{
				  $scope.visible=!$scope.visible;
			  }
			  
		  });
	};
	
	
});


