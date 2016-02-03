"use strict"

app.controller('editAbstract', function ($scope, $q, restful, editAbstractService) {
    $scope.save = function(){
        editAbstractService.submitForm('edit').then(function(data){
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
            document.forms.edit.imageurl = data;
        });
    }

    function setId(id){
        var form = document.getElementById('edit');
        form.id.value=id+"";
    }

    function init(){
        $scope.article = null;
        $scope.img={};
        $('#publishtime').datetimepicker({
            format:'yyyy-mm-dd hh:ii:ss'
        });
    }

    init();
});



