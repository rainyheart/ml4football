'use strict';

angular.module('misApp').controller('articleController', function($scope,$http,$window,$location) {
	var baseUrl = "http://" + $location.host() + ":" + $location.port() + "/admins/article/";
	$http.get(baseUrl)
	  .success(function (response) {
		  $scope.articleList = response.list;
		  
		  //åé¡µæ»æ°
		  $scope.pageSize = 10;
		  $scope.pages = Math.ceil($scope.articleList.length / $scope.pageSize); //åé¡µæ°
		  $scope.newPages = $scope.pages > 10 ? 10 : $scope.pages;
		  $scope.pageList = [];
		  $scope.selPage = 1;
		  
		  //è®¾ç½®è¡¨æ ¼æ°æ®æº(åé¡µ)
		  $scope.setData = function () {
			  $scope.items = $scope.articleList.slice(($scope.pageSize * ($scope.selPage - 1)), ($scope.selPage * $scope.pageSize));//éè¿å½åé¡µæ°ç­éåºè¡¨æ ¼å½åæ¾ç¤ºæ°æ®
		  };
		  $scope.items = $scope.articleList.slice(0, $scope.pageSize); 
		  //åé¡µè¦repeatçæ°ç» 
		  		  for (var i = 0; i < $scope.newPages; i++) {
			  $scope.pageList.push(i + 1);
		  }
		  //æå°å½åéä¸­é¡µç´¢å¼
		  $scope.selectPage = function (page) {
			  //ä¸è½å°äº1å¤§äºæå¤§
			  if (page < 1 || page > $scope.pages) return;
			  //æå¤æ¾ç¤ºåé¡µæ°5
			  if (page > 2) {
				//å ä¸ºåªæ¾ç¤º10ä¸ªé¡µæ°ï¼å¤§äº2é¡µå¼å§åé¡µè½¬æ¢
				var newpageList = [];
				for (var i = (page - 3) ; i < ((page + 2) > $scope.pages ? $scope.pages : (page + 2)) ; i++) {
					newpageList.push(i + 1);
				}
				$scope.pageList = newpageList;
			  }
			  $scope.selPage = page;
			  $scope.setData();
			  $scope.isActivePage(page);
			  console.log("éæ©çé¡µï¼" + page);
		  };
		  	//è®¾ç½®å½åéä¸­é¡µæ ·å¼
			$scope.isActivePage = function (page) {
				return $scope.selPage == page;
			};
			//ä¸ä¸é¡µ
			$scope.Previous = function () {
				$scope.selectPage($scope.selPage-1);
			};
			
			$scope.Next = function () {
				$scope.selectPage($scope.selPage);
			};
	  });
	$scope.article_remove = function(id) {
		$http.delete(baseUrl + id)
		.success(function (){
			$location.path("/admins/article"); 
		});
	};
	
	$scope.article_edit = function(id) {
					var ctx = "/admins/";
			$location.path(ctx + 'article/' + id); 
	};
	
	$scope.article_add = function() {
				var ctx = "/admins/";
		$location.path(ctx + 'article/add'); 
	};
	
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
});

angular.module('misApp').controller('articleAddController', function($scope,$http,$routeParams,$location) {
	var id = $routeParams.id;
	var baseUrl = "http://" + $location.host() + ":" + $location.port() + "/admins/article/" + id;
	if(typeof(id) != "undefined") {
		$scope.id = id;
		$http.get(baseUrl)
		.success(function (response) {
			$scope.id = response.article.id;
			$scope.subject = response.article.subject;
			$scope.content = response.article.content;
			$scope.status = response.article.status;
			$scope.author = response.article.author;
			$scope.publishDate = response.article.publishDate;
			$scope.periodicals = response.article.periodicals;
			$scope.dataAnalyzeId = response.article.dataAnalyzeId;
		});
	}
	
	$scope.article_list = function(){
				var ctx = "/admins/";
		$location.path(ctx + 'article'); 
	};
	
	$scope.article_save = function(){
		var id = $scope.id;
		var baseUrl = "http://" + $location.host() + ":" + $location.port() + "/admins/article/";
		if (typeof(id) == "undefined") { 
			var data = {};
							data.id = $scope.id;
							data.subject = $scope.subject;
							data.content = $scope.content;
							data.createDate = $scope.createDate;
							data.createBy = $scope.createBy;
							data.updateDate = $scope.updateDate;
							data.updateBy = $scope.updateBy;
							data.status = $scope.status;
							data.author = $scope.author;
							data.publishDate = $scope.publishDate;
							data.periodicals = $scope.periodicals;
							data.dataAnalyzeId = $scope.dataAnalyzeId;
						$http.post(baseUrl , data)
			.success(function (){
								var ctx = "/admins/";
				$location.path(ctx + 'article'); 
			});
		}else{
			var data = {};
							data.id = $scope.id;
							data.subject = $scope.subject;
							data.content = $scope.content;
							data.createDate = $scope.createDate;
							data.createBy = $scope.createBy;
							data.updateDate = $scope.updateDate;
							data.updateBy = $scope.updateBy;
							data.status = $scope.status;
							data.author = $scope.author;
							data.publishDate = $scope.publishDate;
							data.periodicals = $scope.periodicals;
							data.dataAnalyzeId = $scope.dataAnalyzeId;
						baseUrl = baseUrl + id
			$http.put(baseUrl, data)
			.success(function (){
								var ctx = "/admins/";
				$location.path(ctx + 'article'); 
			});
		}
		
	};
});
