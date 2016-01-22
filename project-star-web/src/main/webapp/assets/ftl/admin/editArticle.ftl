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
    <link rel="stylesheet" href="/assets/css/bootstrap/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/css/summernote/summernote.css">
    <link rel="stylesheet" href="/assets/css/common.css">
    <link rel="stylesheet" href="/assets/css/editArticle.css">

    <script src="/assets/js/lib/jquery/jquery.min.js"></script>
<#--<script src="/assets/js/lib/jquery/jquery.form.js"></script>-->
    <script src="/assets/js/lib/bootstrap/bootstrap.min.js"></script>
    <script src="/assets/js/lib/angular/angular.min.js"></script>
    <script src="/assets/js/lib/angular/angular-sanitize/angular-sanitize.min.js"></script>
    <script src="/assets/js/lib/angular/angular-resource.min.js"></script>
    <script src="/assets/js/lib/summernote/summernote.min.js"></script>
    <script src="/assets/js/lib/summernote/summernote-zh-CN.min.js"></script>
    <script src="/assets/js/common/common.js"></script>

    <script>
        var id = ${id};
        var app = angular.module("app", ['ngResource','ngSanitize']);
    </script>
</head>
<body ng-app="app" style="">
<div ng-controller="editArticle">
    <div class="container" style="">
        <div class="row">
            <div class="col-lg-6">
                <div class="form-group">
                    <h1>编辑文章内容</h1>

                    <form id="edit">
                        <input type="hidden" name="id" ng-model="vo.id">
                        <label for="contentTitle">文章标题</label>
                        <input type="text" class="form-control" ng-model="vo.contentTitle" name="contentTitle" id="contentTitle" placeholder="文章标题">
                        <label for="author">作者</label>
                        <input type="text" class="form-control" ng-model="vo.author" name="author" id="author" placeholder="作者">
                        <label for="linkurl">链接URL</label>
                        <input type="text" class="form-control" name="linkurl" ng-model="vo.linkurl" id="linkurl" placeholder="链接URL">
                        <label for="linkurl">文章内容</label>
                        <#--<textarea class="form-control" name="content" ng-model="vo.content" id="content" >${articleContent.content!''}</textarea>-->
                        <div>
                            <div id="content" class="summernote"></div>
                        </div>
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
                    <button ng-click="appendImg(img.url)" ng-show="img.url!=null" class="btn btn-primary">加入文章</button>

                    <div class="imgpreview">
                        <img src="{{img.url}}">
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <h1>预览</h1>
                <div class="preview">
                    <h1 class="content-title">{{vo.contentTitle}}</h1>
                    <br>
                    <span class="author">{{vo.author}}</span>
                    <a href="{{vo.linkurl}}"><span class="link-text">深度阅读</span></a>
                    <hr>
                    <div class="contenttext" ng-bind-html="vo.content">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/assets/js/service/restful.js"></script>
<script src="/assets/js/service/editArticle.js"></script>
<script src="/assets/js/controller/editArticle.js"></script>
</body>
</html>