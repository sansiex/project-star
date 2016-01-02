/**
 * Created by zuhai.jiang on 2015/12/9.
 */
"use strict"

app.factory('abstractService', function (restful) {
    var svc = {};

    svc.getAbstract = function(id){
        var url = '/abstract/get';
        var params = {id:id};
        return restful.post(url, params, {
            filter:function(data){
                return data.result;
            }
        });
    }

    svc.getBeforeAbstractList = function(publishtime){
        var url = '/abstract/before';
        var params = {publishtime:publishtime};
        return restful.post(url, params, {
            filter:function(data){
                return data.result;
            }
        });
    }

    svc.getAfterAbstractList = function(publishtime){
        var url = '/abstract/after';
        var params = {publishtime:publishtime};
        return restful.post(url, params, {
            filter:function(data){
                return data.result;
            }
        });
    }

    return svc;
});

