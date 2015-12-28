"use strict"

app.controller('adminLogin', function ($scope, $q, restful) {
    $scope.login = function(){
        var formId = 'login';
        var url='/priviledge/loginAdmin';
        restful.submitForm(url, formId).then(function(data){
            var result = data.result;
            if (result == true) {
                window.location.href = '/admin/abstract/1';
            } else {
                alert(data.resultMessage);
            }
        });
    }
});



