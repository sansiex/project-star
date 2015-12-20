<#import "../${view}.ftl" as content>

<!DOCTYPE html>
<html lang="zh-CN">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<head>
    <title>星闻头条</title>

    <link rel="stylesheet" href="/assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/bootstrap/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/assets/css/common.css">

    <script src="/assets/js/lib/jquery/jquery.min.js"></script>
    <script src="/assets/js/lib/bootstrap/bootstrap.min.js"></script>
    <script src="/assets/js/lib/angular/angular.min.js"></script>
    <script src="/assets/js/lib/angular/angular-resource.min.js"></script>

<@content.lib />
</head>
<body ng-app="app" style="background-color: #E5F3FF;">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="position: relative;">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Hoek</a>
            <#--<a class="navbar-brand" href="#">测试</a>-->
            <#--<a class="navbar-brand" href="#">开发</a>-->
        </div>
    </div>
</nav>

<div ng-controller="${view}">
    <div class="container" style="">
    <@content.content />
    </div>
</div>

<script src="/assets/js/common/app.js"></script>
<script src="/assets/js/service/restful.js"></script>
<@content.js />
</body>
</html>