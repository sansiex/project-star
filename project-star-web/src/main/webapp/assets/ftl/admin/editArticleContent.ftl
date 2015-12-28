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
    <link rel="stylesheet" href="/assets/css/editArticleContent.css">

    <script src="/assets/js/lib/jquery/jquery.min.js"></script>
<#--<script src="/assets/js/lib/jquery/jquery.form.js"></script>-->
    <script src="/assets/js/lib/bootstrap/bootstrap.min.js"></script>
    <script src="/assets/js/lib/angular/angular.min.js"></script>
    <script src="/assets/js/lib/angular/angular-resource.min.js"></script>
    <script src="/assets/js/common/common.js"></script>
</head>
<body ng-app="app" style="">
<div ng-controller="editArticleContent">
    <div class="container" style="">
        <div class="form-group">
            <h1>编辑文章内容</h1>

            <form id="edit">
                <input type="hidden" name="id" value="${articleContent.id!''}">
                <label for="contentTitle">文章标题</label>
                <input type="text" class="form-control" name="contentTitle" id="contentTitle" value="${articleContent.contentTitle!''}" placeholder="文章标题">
                <label for="author">作者</label>
                <input type="text" class="form-control" name="author" id="author" value="${articleContent.author!''}" placeholder="作者">
                <label for="linkurl">链接URL</label>
                <input type="text" class="form-control" name="linkurl" id="linkurl" value="${articleContent.linkurl!''}" placeholder="链接URL">
                <label for="linkurl">文章内容</label>
                <textarea class="form-control" name="content" id="content" >${articleContent.content!''}</textarea>
                <button ng-click="save()" class="btn btn-primary">保存</button>
            </form>
            <hr>
            <h1>上传图片</h1>

            <form id="uploadimg">
                <label for="image">文章插图</label>
                <input name="image" type="file" id="image">
                <button ng-click="upload()" class="btn btn-primary">上传</button>
            </form>
            <br>

            <h1>图片预览</h1>
            <span>URL:{{img.url}}</span>

            <div class="imgpreview">
                <img src="{{img.url}}">
            </div>
        </div>
    </div>
</div>

<script src="/assets/js/common/app.js"></script>
<script src="/assets/js/service/restful.js"></script>
<script src="/assets/js/service/editArticleContent.js"></script>
<script src="/assets/js/controller/editArticleContent.js"></script>
</body>
</html>