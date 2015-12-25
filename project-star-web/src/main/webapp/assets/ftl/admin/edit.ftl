<!DOCTYPE html>
<html lang="zh-CN">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<head>
    <title>时代人物</title>

    <link rel="stylesheet" href="/assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/bootstrap/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/assets/css/common.css">
    <link rel="stylesheet" href="/assets/css/abstract.css">

    <script src="/assets/js/lib/jquery/jquery.min.js"></script>
    <script src="/assets/js/lib/bootstrap/bootstrap.min.js"></script>
    <script src="/assets/js/lib/angular/angular.min.js"></script>
    <script src="/assets/js/lib/angular/angular-resource.min.js"></script>
</head>
<body ng-app="app" style="">
<div ng-controller="abstract">
    <div class="container" style="">
        <a href="/content/article/${articleInfo.id}">
            <img class="background-img" style="" src="${articleInfo.imageurl}" />
        </a>
    </div>
    <div class="text-mask">
        <div class="linear-gradient-mask"></div>
        <div class="transparent-mask">
        <span class="abstract-text">
            ${articleInfo.abstracttext}
        </span>
        </div>
    </div>
</div>

<script src="/assets/js/common/app.js"></script>
<script src="/assets/js/service/restful.js"></script>
<script src="/assets/js/service/abstract.js"></script>
<script src="/assets/js/controller/abstract.js"></script>
</body>
</html>