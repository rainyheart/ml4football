'use strict';

angular.module('misApp').controller('newsController', function($scope, $http,$window, $location) {
	console.log(' start to load data');
	var basicUrl = "http://localhost:8080/admins/news/";
	$http.get(basicUrl)
	  .success(function (response) {
		  $scope.newsList = response.list;
		  
		  //分页总数
		  $scope.pageSize = 10;
		  $scope.pages = Math.ceil($scope.newsList.length / $scope.pageSize); //分页数
		  $scope.newPages = $scope.pages > 10 ? 10 : $scope.pages;
		  $scope.pageList = [];
		  $scope.selPage = 1;
		  
		  //设置表格数据源(分页)
		  $scope.setData = function () {
			  $scope.items = $scope.newsList.slice(($scope.pageSize * ($scope.selPage - 1)), ($scope.selPage * $scope.pageSize));//通过当前页数筛选出表格当前显示数据
		  };
		  $scope.items = $scope.newsList.slice(0, $scope.pageSize);
		  //分页要repeat的数组
		  for (var i = 0; i < $scope.newPages; i++) {
			  $scope.pageList.push(i + 1);
		  }
		  //打印当前选中页索引
		  $scope.selectPage = function (page) {
			  //不能小于1大于最大
			  if (page < 1 || page > $scope.pages) return;
			  //最多显示分页数5
			  if (page > 2) {
				//因为只显示10个页数，大于2页开始分页转换
				var newpageList = [];
				for (var i = (page - 3) ; i < ((page + 2) > $scope.pages ? $scope.pages : (page + 2)) ; i++) {
					newpageList.push(i + 1);
				}
				$scope.pageList = newpageList;
			  }
			  $scope.selPage = page;
			  $scope.setData();
			  $scope.isActivePage(page);
			  console.log("选择的页：" + page);
		  };
		  	//设置当前选中页样式
			$scope.isActivePage = function (page) {
				return $scope.selPage == page;
			};
			//上一页
			$scope.Previous = function () {
				$scope.selectPage($scope.selPage - 1);
			};
			
			$scope.Next = function () {
				$scope.selectPage($scope.selPage + 1);
			};
	  });
	$scope.news_remove = function(id) {
		$http.delete(basicUrl + id + "/")
		.success(function (){
			$location.path("/admins/news/"); 
		});
	};
	
	$scope.news_edit = function(id) {
		$location.path("/admins/news/" + id); 
	};
	
	$scope.news_add = function() {
		$location.path("/admins/news/add"); 
	};
});

angular.module('misApp').controller('newsAddController', function($scope, $http,$routeParams,$location) {
	var id = $routeParams.id;
	if(typeof(id) != "undefined") {
		$scope.id = id;
		var basicUrl = "http://localhost:8080/admins/news/" + id;
		$http.get(basicUrl)
		.success(function (response) {
			$scope.subject = response.news.subject;
			$scope.content = response.news.content;
		});
	}
	
	$scope.news_list = function(){
		$location.path("/admins/news/"); 
	};
	
	$scope.article_list = function(){
		$location.path("/admins/news/"); 
	};
	
	$scope.bio_list = function(){
		$location.path("/admins/bio/"); 
	};
	
	$scope.notification_list = function(){
		$location.path("/admins/notification/"); 
	};
	
	$scope.news_save = function(){
		var id = $scope.id;
		console.log("id:" + id);
		if (typeof(id) == "undefined") { 
			var data = {"subject":$scope.subject,"content":$scope.content};
			$http.post("http://localhost:8080/admins/news/" , data)
			.success(function (){
				$location.path("/admins/news/"); 
			});
		}else{
			var data = {"id":id, "subject":$scope.subject,"content":$scope.content};
			$http.put("http://localhost:8080/admins/news/" + id, data)
			.success(function (){
				$location.path("/admins/news/"); 
			});
		}
		
	};
});
