/**
 * Created by zuhai.jiang on 2015/12/9.
 */
"use strict"

app.factory('editAbstractService', function (restful) {
    var svc = {};

    svc.submitForm = function(formId){
        var url = '/admin/access/saveAbstract';
        return restful.submitForm(url, formId, {});
    }

    svc.uploadImg = function(formId){
        var url = '/admin/access/saveAbstractImg';
        return restful.submitMultipartForm(url, formId, {});
    }

    return svc;
});

