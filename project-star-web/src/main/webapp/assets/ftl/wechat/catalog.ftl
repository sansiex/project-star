<#import "/content/abstract-content.ftl" as content>

<#assign site="http://115.159.70.218:8080/">

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

    <script src="/assets/js/lib/jquery/jquery.min.js"></script>
    <script src="/assets/js/lib/bootstrap/bootstrap.min.js"></script>
    <script src="/assets/js/lib/angular/angular.min.js"></script>
    <script src="/assets/js/lib/angular/angular-resource.min.js"></script>
</head>
<body ng-app="app" style="">
<div ng-controller="content">

    <a href="${site}content/abstract/1">2016-01-05 文章1</a>
    <a href="${site}content/abstract/2">2016-01-06 文章2</a>

</div>

<script src="/assets/js/common/app.js"></script>
<script src="/assets/js/service/restful.js"></script>
<#--<script src="/assets/js/service/abstract.js"></script>-->
<#--<script src="/assets/js/controller/abstract.js"></script>-->
</body>
</html>