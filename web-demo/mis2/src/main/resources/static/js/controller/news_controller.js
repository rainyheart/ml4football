'use strict';

angular.module('misApp',[]).controller('newsController', function($scope, $http) {
	console.log(' start to load data');
	$http.get("http://localhost:8080/news/")
	  .success(function (response) {
		  console.log('response:' + response);
		  $scope.newsList = response.list;
	  });
	$scope.editNews = function(type,subject,content,id) {
		  if (id == 'new') {
		    $scope.mSubject = '';
		    $scope.mContent = '';
		    $scope.mId = '';
		    } else {
		    $scope.mSubject = subject;
		    $scope.mContent = content;
		    $scope.mId = id;
		  }
	};
	
	$scope.addNews = function() {
		if($scope.mId == '' || angular.isUndefined($scope.mId)){
			// create news
			var data = {"subject":$scope.mSubject,"content":$scope.mContent};
			$http.post("http://localhost:8080/admin/news",data)
			.success(function (){
				$http.get("http://localhost:8080/admin/news/")
				.success(function (response) {
					$scope.newsList = response.list;
				});
			});
		}else{
			// update news
			var data = {"subject":$scope.mSubject,"content":$scope.mContent};
			$http.put("http://localhost:8080/admin/news/" + $scope.mId,data)
			.success(function (){
				$http.get("http://localhost:8080/admin/news")
				  .success(function (response) {
					  $scope.newsList = response.list;
				  });
			});
		}
	};
	
	$scope.deleteNews = function(id) {
		$http.delete("http://localhost:8080/admin/news/" + id + "/")
		.success(function (){
			$http.get("http://localhost:8080/admin/news/")
			  .success(function (response) {
				  $scope.newsList = response.list;
			  });
		});
	};
});


