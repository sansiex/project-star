"use strict"

app.controller('abstract', function ($scope, $q, restful, abstractService) {

    function resize(){
        console.log([$(window).height(),$(document).height()].join(','));
        $('.background-img').css('height', $(window).height()+'px');
    }

    function init(){
        resize();
    }

    init();
});



