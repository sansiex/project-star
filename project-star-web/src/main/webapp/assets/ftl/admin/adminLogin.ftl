<#import "/content/abstract-content.ftl" as content>

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
    <#--<script src="/assets/js/lib/jquery/jquery.form.js"></script>-->
    <script src="/assets/js/lib/bootstrap/bootstrap.min.js"></script>
    <script src="/assets/js/lib/angular/angular.min.js"></script>
    <script src="/assets/js/lib/angular/angular-resource.min.js"></script>
    <script src="/assets/js/common/common.js"></script>
</head>
<body ng-app="app" style="">
<div ng-controller="adminLogin">
    <div class="container" style="">
        <div class="row">
            <div class="col-lg-6">
                <div class="form-group">
                    <h1>登录后台</h1>
                    <form id="login">
                        <label for="username">用户名</label>
                        <input type="text" class="form-control" name="username" id="username" placeholder="用户名">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="密码">
                        <button ng-click="login()" class="btn btn-primary">登录</button>
                    </form>
                </div>
            </div>
            <div class="col-lg-6">

            </div>
        </div>
    </div>
</div>

<script src="/assets/js/common/app.js"></script>
<script src="/assets/js/service/restful.js"></script>
<script src="/assets/js/controller/adminLogin.js"></script>
</body>
</html>