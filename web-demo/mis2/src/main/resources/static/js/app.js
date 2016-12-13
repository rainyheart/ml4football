'use strict';

angular.module('misApp',['ngRoute']).config(function($routeProvider){
	$routeProvider
	.when('/', {
        templateUrl : '/admins/login.html',
        controller  : 'loginController'
    })
    .when('/admins/news', {
        templateUrl : '/admins/news_list.html',
        controller  : 'newsController'
    })
    .when('/admins/news/add', {
        templateUrl : '/admins/news_add.html',
        controller  : 'newsController'
    })
    .when('/admins/news/:id', {
        templateUrl : '/admins/news_add.html',
        controller  : 'newsController'
    })
    .when('/admins/article', {
        templateUrl : '/admins/article_list.html',
        cache: false,
        controller  : 'articleController'
    })
    .when('/admins/article/add', {
        templateUrl : '/admins/article_add.html',
        controller  : 'articleController'
    })
    .when('/admins/article/:id', {
        templateUrl : '/admins/article_add.html',
        controller  : 'articleController'
    })
    .when('/admins/bio', {
        templateUrl : '/admins/bio_list.html',
        controller  : 'bioController'
    })
    .when('/admins/bio/add', {
        templateUrl : '/admins/bio_add.html',
        controller  : 'bioController'
    })
    .when('/admins/bio/:id', {
        templateUrl : '/admins/bio_add.html',
        controller  : 'bioController'
    })
    .when('/admins/notification', {
        templateUrl : '/admins/notification_list.html',
        controller  : 'notificationController'
    })
    .when('/admins/notification/add', {
        templateUrl : '/admins/notification_add.html',
        controller  : 'notificationController'
    })
    .when('/admins/notification/:id', {
        templateUrl : '/admins/notification_add.html',
        controller  : 'notificationController'
    })
    .when('/admins/bioCategory', {
        templateUrl : '/admins/bioCategory_list.html',
        controller  : 'bioCategoryController'
    })
    .when('/admins/bioCategory/add', {
        templateUrl : '/admins/bioCategory_add.html',
        controller  : 'bioCategoryController'
    })
    .when('/admins/bioCategory/:id', {
        templateUrl : '/admins/bioCategory_add.html',
        controller  : 'bioCategoryController'
    })
     .when('/admins/bioSpecification', {
        templateUrl : '/admins/bioSpecification_list.html',
        controller  : 'bioSpecificationController'
    })
    .when('/admins/bioSpecification/add', {
        templateUrl : '/admins/bioSpecification_add.html',
        controller  : 'bioSpecificationController'
    })
    .when('/admins/bioSpecification/:id', {
        templateUrl : '/admins/bioSpecification_add.html',
        controller  : 'bioSpecificationController'
    })
     .when('/admins/dataAnalyze', {
        templateUrl : '/admins/dataAnalyze_list.html',
        controller  : 'dataAnalyzeController'
    })
    .when('/admins/dataAnalyze/add', {
        templateUrl : '/admins/dataAnalyze_add.html',
        controller  : 'dataAnalyzeController'
    })
    .when('/admins/dataAnalyze/:id', {
        templateUrl : '/admins/dataAnalyze_add.html',
        controller  : 'dataAnalyzeController'
    })
     .when('/admins/dataAnalyzeCategory', {
        templateUrl : '/admins/dataAnalyzeCategory_list.html',
        controller  : 'dataAnalyzeCategoryController'
    })
    .when('/admins/dataAnalyzeCategory/add', {
        templateUrl : '/admins/dataAnalyzeCategory_add.html',
        controller  : 'dataAnalyzeCategoryController'
    })
    .when('/admins/dataAnalyzeCategory/:id', {
        templateUrl : '/admins/dataAnalyzeCategory_add.html',
        controller  : 'dataAnalyzeCategoryController'
    })
     .when('/admins/images', {
        templateUrl : '/admins/images_list.html',
        controller  : 'imagesController'
    })
    .when('/admins/images/add', {
        templateUrl : '/admins/images_add.html',
        controller  : 'imagesController'
    })
    .when('/admins/images/:id', {
        templateUrl : '/admins/images_add.html',
        controller  : 'imagesController'
    })
     .when('/admins/resource', {
        templateUrl : '/admins/resource_list.html',
        controller  : 'resourceController'
    })
    .when('/admins/resource/add', {
        templateUrl : '/admins/resource_add.html',
        controller  : 'resourceController'
    })
    .when('/admins/resource/:id', {
        templateUrl : '/admins/resource_add.html',
        controller  : 'resourceController'
    })
     .when('/admins/role', {
        templateUrl : '/admins/role_list.html',
        controller  : 'roleController'
    })
    .when('/admins/role/add', {
        templateUrl : '/admins/role_add.html',
        controller  : 'roleController'
    })
    .when('/admins/role/:id', {
        templateUrl : '/admins/role_add.html',
        controller  : 'roleController'
    })
     .when('/admins/scholarInteraction', {
        templateUrl : '/admins/scholarInteraction_list.html',
        controller  : 'scholarInteractionController'
    })
    .when('/admins/scholarInteraction/add', {
        templateUrl : '/admins/scholarInteraction_add.html',
        controller  : 'scholarInteractionController'
    })
    .when('/admins/scholarInteraction/:id', {
        templateUrl : '/admins/scholarInteraction_add.html',
        controller  : 'scholarInteractionController'
    })
     .when('/admins/studyTeam', {
        templateUrl : '/admins/studyTeam_list.html',
        controller  : 'studyTeamController'
    })
    .when('/admins/studyTeam/add', {
        templateUrl : '/admins/studyTeam_add.html',
        controller  : 'studyTeamController'
    })
    .when('/admins/studyTeam/:id', {
        templateUrl : '/admins/studyTeam_add.html',
        controller  : 'studyTeamController'
    })
     .when('/admins/user', {
        templateUrl : '/admins/user_list.html',
        controller  : 'userController'
    })
    .when('/admins/user/add', {
        templateUrl : '/admins/user_add.html',
        controller  : 'userController'
    })
    .when('/admins/user/:id', {
        templateUrl : '/admins/user_add.html',
        controller  : 'userController'
    })
    ;
    
    
});

