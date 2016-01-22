/**
 * Created by zuhai.jiang on 2015/12/9.
 */
"use strict"

app.factory('editArticleService', function (restful) {
    var svc = {};

    svc.getArticle = function(id){
        var url = '/admin/access/article/'+id;
        return restful.post(url, {});
    }

    svc.save = function(vo){
        var url = '/admin/access/saveArticle';
        return restful.post(url, vo, {});
    }

    svc.uploadImg = function(formId){
        var url = '/admin/access/saveArticleContentImg';
        return restful.submitMultipartForm(url, formId, {});
    }

    return svc;
});

