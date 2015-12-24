"use strict"

app.controller('abstract', function ($scope, $q, restful, abstractService) {

    function resize(){
        console.log(document.body.clientHeight+','+document.body.scrollHeight+','+document.body.offsetHeight +','+window.screen.height+','+window.screen.availHeight);
        $('.background-img').css('height', document.body.scrollHeight+'px');
    }

    function init(){
        resize();
    }

    init();
});



