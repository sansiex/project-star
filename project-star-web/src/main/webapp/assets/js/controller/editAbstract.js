"use strict"

app.controller('editAbstract', function ($scope, $q, restful, editAbstractService) {
    $scope.save = function(){
        var formId = 'edit';
        var id = getId();
        editAbstractService.submitForm(formId).then(function(data){
            console.log(data);
        });
    }

    $scope.upload = function(){
        var formId = 'uploadimg';
        editAbstractService.uploadImg(formId).then(function(data){
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



