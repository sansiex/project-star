/**
 * Created by zuhai.jiang on 2015/12/9.
 */
"use strict"

app.factory('editArticleContentService', function (restful) {
    var svc = {};

    svc.submitForm = function(formId){
        var url = '/admin/saveArticleContent';
        return restful.submitForm(url, formId, {});
    }

    svc.uploadImg = function(formId){
        var url = '/admin/saveArticleContentImg';
        return restful.submitMultipartForm(url, formId, {});
    }

    return svc;
});

