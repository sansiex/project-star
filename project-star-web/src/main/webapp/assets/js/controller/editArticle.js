"use strict"

app.controller('editArticle', function ($scope, $q, restful, editArticleService) {
    $scope.save = function () {
        var vo = $scope.vo;
        editArticleService.save(vo).then(function (data) {
            console.log(data);
            alert('保存成功');
        });
    }

    $scope.upload = function () {
        var formId = 'uploadimg';
        editArticleService.uploadImg(formId).then(function (data) {
            $scope.img.url = data;
        });
    }

    $scope.appendImg = function (url) {
        var tag = '<img src="' + url + '" style="width:auto;height:auto;"/>';
        $scope.vo.content += tag;
    }

    function getId() {
        return id;
    }

    function initSummerNote() {
        $scope.summernote = $('#content').summernote({
            height: 200
            , callbacks: {
                onKeyup: function (e) {
                    var code = $scope.summernote.summernote('code');
                    $scope.vo.content = code;
                    $scope.$digest();
                }
            }
        });
    }

    function init() {
        $scope.img = {};
        $scope.vo = {};
        editArticleService.getArticle(getId()).then(function (ret) {
            var article = ret.result;
            common.value.copyProperties(article, $scope.vo);
            var code = $scope.summernote.summernote('code', article.content);
        });
        initSummerNote();
    }

    init();
});



