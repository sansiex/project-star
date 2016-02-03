<!DOCTYPE html>
<html lang="zh-CN">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<head>
    <title>人物测试</title>

    <link rel="stylesheet" href="/assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/bootstrap/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/assets/css/common.css">

    <script src="/assets/js/lib/jquery/jquery.min.js"></script>
<#--<script src="/assets/js/lib/jquery/jquery.form.js"></script>-->
    <script src="/assets/js/lib/bootstrap/bootstrap.min.js"></script>
    <script src="/assets/js/lib/angular/angular.min.js"></script>
    <script src="/assets/js/lib/angular/angular-resource.min.js"></script>
    <script src="/assets/js/common/common.js"></script>

    <style>
        .marquee-img {
            list-style: none;
            float: left;
            display: list-item;
        }
    </style>
</head>
<body ng-app="app" style="">
<div ng-controller="matchPeople">
    <div class="container" style="height: 300px;">
    <#--<marquee direction="left" align="middle" scrollamount="15" behavior="scroll" style="height: 380px;" hspace="0" vspace="0">-->
    <#--<ul style="list-style-type: disc; width:{{360*images.length+100}}px;">-->
    <#--<li class="marquee-img" ng-repeat = "img in images">-->
    <#--<img src="{{img.src}}">-->
    <#--</li>-->
    <#--</ul>-->
    <#--</marquee>-->

        <div id="marquee" style="position: relative;overflow: hidden;">
            <div id="marquee1" style="width:{{marqueeWidth}}px;position: relative;float: left;left: {{left1}}px;">
                <#--<ul style="list-style-type: disc; width:{{360*images.length+100}}px;">-->
                    <#--<li class="marquee-img" ng-repeat="img in images">-->
                        <#--<img src="{{img.src}}">-->
                    <#--</li>-->
                <#--</ul>-->
                <img ng-repeat="img in images" src="{{img.src}}" width="{{imageWidth}}px" height="{{imageWidth}}px">
            </div>

            <div id="marquee2" style="width:{{marqueeWidth}}px;position: absolute;float: left;left: {{left2}}px;"></div>
        </div>

        <div>
            <a href="quiz"><span>开始测试</span></a>
        </div>
    </div>
</div>

<script src="/assets/js/common/app.js"></script>
<script src="/assets/js/service/restful.js"></script>
<script src="/assets/js/controller/campaign/matchPeople.js"></script>
</body>
</html>