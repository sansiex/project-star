"use strict"

app.controller('abstract', function ($scope, $q, restful, abstractService) {

    $scope.viewArticle=function(){
        window.location.href="/content/article/"+$scope.abstract.id
    }

    $scope.toBefore = function(){
        window.location.href="/content/abstract/"+$scope.beforeArticle.id
    }

    $scope.toAfter = function(){
        window.location.href="/content/abstract/"+$scope.afterArticle.id
    }

    function getRecentAbstracts(){
        var id = getId();
        abstractService.getAbstract(id).then(function(item){
            $scope.abstract = item;

            abstractService.getBeforeAbstractList($scope.abstract.publishtime).then(function(item){
                if (item!=null) {
                    $scope.beforeArticle = item[0];
                }
            });
            abstractService.getAfterAbstractList($scope.abstract.publishtime).then(function(item){
                if (item!=null) {
                    $scope.afterArticle = item[0];
                }
            });
        });
    }

    function resize(){
        console.log([$(window).height(),$(document).height()].join(','));
        $('.background-img').css('height', $(window).height()+'px');
    }

    function getId(){
        return id;
    }

    function init(){
        resize();
        getRecentAbstracts();
    }

    init();
});



