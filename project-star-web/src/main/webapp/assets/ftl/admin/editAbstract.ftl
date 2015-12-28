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
    <link rel="stylesheet" href="/assets/css/editAbstract.css">

    <script src="/assets/js/lib/jquery/jquery.min.js"></script>
    <#--<script src="/assets/js/lib/jquery/jquery.form.js"></script>-->
    <script src="/assets/js/lib/bootstrap/bootstrap.min.js"></script>
    <script src="/assets/js/lib/angular/angular.min.js"></script>
    <script src="/assets/js/lib/angular/angular-resource.min.js"></script>
    <script src="/assets/js/common/common.js"></script>
</head>
<body ng-app="app" style="">
<div ng-controller="editAbstract">
    <div class="container" style="">
        <div class="row">
            <div class="col-lg-6">
                <div class="form-group">
                    <h1>编辑摘要内容</h1>
                    <form id="edit">
                        <label for="id">文章ID：{{article.id}}</label>
                        <input type="hidden" name="id" value="${articleInfo.id!-1}">
                        <br>
                        <label for="image">标题</label>
                        <input type="text" class="form-control" value="${articleInfo.title!''}" name="title" id="title" placeholder="标题">
                        <label for="image">摘要内容</label>
                        <textarea class="form-control" name="abstracttext" id="abstracttext" >${articleInfo.abstracttext!''}</textarea>
                        <label for="image">背景图片URL</label>
                        <input type="text" class="form-control" value="${articleInfo.imageurl!''}" name="imageurl" id="imageurl" placeholder="图片URL">
                        <button ng-click="save()" class="btn btn-primary">保存</button>
                    </form>
                    <hr>
                    <h1>上传图片</h1>
                    <form id="uploadimg">
                        <label for="image">背景图片</label>
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
            <div class="col-lg-6">
                <h1>预览</h1>
                <div class="preview">
                    <@content.abstractcontent />
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/assets/js/common/app.js"></script>
<script src="/assets/js/service/restful.js"></script>
<script src="/assets/js/service/editAbstract.js"></script>
<script src="/assets/js/controller/editAbstract.js"></script>
</body>
</html>