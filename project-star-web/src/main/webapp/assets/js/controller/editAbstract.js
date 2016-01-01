"use strict"

app.controller('editAbstract', function ($scope, $q, restful, editAbstractService) {
    $scope.save = function(){
        var formId = 'edit';
        editAbstractService.submitForm(formId).then(function(data){
            var article = data.result;
            $scope.article = article;
            setId(article.id);
            alert('保存成功');
        });
    }

    $scope.upload = function(){
        var formId = 'uploadimg';
        editAbstractService.uploadImg(formId).then(function(data){
            $scope.img.url = data;
        });
    }

    function setId(id){
        var form = document.getElementById('edit');
        form.id.value=id+"";
    }

    function init(){
        $scope.article = null;
        $scope.img={};
    }

    init();
});


