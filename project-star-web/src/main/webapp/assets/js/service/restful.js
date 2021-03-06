"use strict"

app.factory('restful', function ($q, $resource) {
    var retry_times = 2;
    var svc = {};
    svc.get = function (url, options) {
        var options = options || {};
        var deferred = $q.defer();

        var service = $resource(url);
        var retry = 0;
        if (options.retry != null) {
            retry = options.retry;
        }

        function sendRequest(service, options, deferred) {
            service.get({}, function (data) {
                if (data && data.success) {
                    if (options.filter) {
                        deferred.resolve(options.filter(data));
                    } else {
                        deferred.resolve(data);
                    }
                } else {
                    if (retry > 0) {
                        retry--;
                        console.log('第' + (retry_times - retry) + '次重试。url:' + url);
                        sendRequest(service, options, deferred);
                    } else {
                        if (options.failure) {
                            options.failure({isSuccess: false, msg: data.errorMsg || options.errorMsg});
                        }

                        if (options.errorMsg) {
                            deferred.reject(options.errorMsg);
                        } else if (data) {
                            deferred.reject(data.msg);
                        } else {
                            deferred.reject('Failed to send get request to: ' + url);
                        }
                    }
                }
            });
        }

        sendRequest(service, options, deferred);
        return deferred.promise;
    }

    svc.post = function (url, params, options) {
        var options = options || {};
        var deferred = $q.defer();
        var retry = 0;
        if (options.retry != null) {
            retry = options.retry;
        }

        function success(data){
            if (!data.success) {
                deferred.reject(data);
            }

            if (options.filter) {
                deferred.resolve(options.filter(data));
            } else {
                deferred.resolve(data);
            }
        }

        function sendRequest(params, options) {
            $.post(url, params, success, 'json').error(function(data){
                if (options.errorMsg) {
                    deferred.reject(options.errorMsg);
                } else if (data) {
                    deferred.reject(data.resultMessage);
                } else {
                    deferred.reject('Failed to send post request to: ' + url);
                }
            });
        }

        sendRequest(params, options);
        return deferred.promise;
    }

    svc.download = function (url, params) {
        // 获得url和data
        var method = 'post';
        if (url && params) {
            // data 是 string 或者 array/object
            var inputs = '';
            if (typeof params == 'string') {
                jQuery.each(params.split('&'), function () {
                    var pair = this.split('=');
                    inputs += '<input type="hidden" name="' + pair[0] + '" value="' + encodeURIComponent(pair[1]) + '" />';
                });
            } else {
                for (var k in params) {
                    var v = params[k];
                    inputs += '<input type="hidden" name="' + k + '" value="' + encodeURIComponent(v) + '" />';
                }
            }
            // 把参数组装成 form的  input

            // request发送请求
            jQuery('<form action="' + url + '" method="' + (method || 'post') + '">' + inputs + '</form>')
                .appendTo('body').submit().remove();
        }
    }

    svc.getFormData=function (formId) {
        var form = document.getElementById(formId);
        var data=new FormData();
        var tagElements = form.getElementsByTagName('input');
        for (var j = 0; j < tagElements.length; j++){
            var ele=tagElements[j];
            if (ele.type == 'file' ) {
                data.append(ele.name, ele.files[0]);
            } else {
                data.append(ele.name, ele.value);
            }
        }
        var tagElements = form.getElementsByTagName('textarea');
        for (var j = 0; j < tagElements.length; j++){
            var ele=tagElements[j];
            data[ele.name] = ele.value;
        }
        var tagElements = form.getElementsByTagName('select');
        for (var j = 0; j < tagElements.length; j++){
            var ele=tagElements[j];
            data[ele.name] = ele.value;
        }
        return data;
    }

    svc.getFormDataMap=function (formId) {
        var form = document.getElementById(formId);
        var data={};
        var tagElements = form.getElementsByTagName('input');
        for (var j = 0; j < tagElements.length; j++){
            var ele=tagElements[j];
            data[ele.name] = ele.value;
        }
        var tagElements = form.getElementsByTagName('textarea');
        for (var j = 0; j < tagElements.length; j++){
            var ele=tagElements[j];
            data[ele.name] = ele.value;
        }
        var tagElements = form.getElementsByTagName('select');
        for (var j = 0; j < tagElements.length; j++){
            var ele=tagElements[j];
            data[ele.name] = ele.value;
        }
        return data;
    }

    svc.submitMultipartForm = function (url, formId, options){
        var deferred = $q.defer();
        var params = svc.getFormData(formId);
        $.ajax({
            url:url,
            type: 'POST',
            enctype: 'multipart/form-data',
            async: true,
            contentType: false,
            processData: false,
            data: params,
            cache: false,
            success: function(data){
                deferred.resolve(data.result);
            },
            error: function(error){

            }
        });

        return deferred.promise;
    }

    svc.submitForm = function (url, formId, options){
        var params = svc.getFormDataMap(formId);
        return svc.post(url, params);
    }

    svc.getPromise = function (data) {
        var defer = $q.defer();
        var promise = defer.promise();
        defer.resolve(data);
        return promise;
    }

    return svc;
});