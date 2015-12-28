"use strict"

app.controller('editArticleContent', function ($scope, $q, restful, editArticleContentService) {
    $scope.save = function(){
        var formId = 'edit';
        var id = getId();
        editArticleContentService.submitForm(formId).then(function(data){
            console.log(data);
            alert('保存成功');
        });
    }

    $scope.upload = function(){
        var formId = 'uploadimg';
        editArticleContentService.uploadImg(formId).then(function(data){
            $scope.img.url = data;
        });
    }

    function getId(){
        var i = location.pathname.lastIndexOf('/');
        return location.pathname.substring(i+1);
    }

    function init(){
        $scope.img={};
    }

    init();
});



