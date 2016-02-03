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
        ul li.selected {
            background-color: #96ccc3;
        }
    </style>
</head>
<body ng-app="app" style="">
<div ng-controller="quiz">
    <div class="container" style="height: 300px;">
        <div class="header">

        </div>
        <div class="content">
            <div class="question">
                <span ng-bind="questions[currentQuestionNum].question"></span>
            </div>
            <div class="options">
                <ul>
                    <li ng-class="{'true':'selected','false':''}[$index==questions[currentQuestionNum].answer]" ng-repeat="option in questions[currentQuestionNum].options">
                        <span style="cursor: pointer;" ng-click="answer(currentQuestionNum, $index)" ng-bind="option"><span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="footer">
            <span ng-show="currentQuestionNum>0" ng-click="prevQuestion()" style="cursor: pointer;">上一题</span>
            <br>
            <span ng-show="currentQuestionNum<questions.length-1" ng-click="nextQuestion()" style="cursor: pointer;">下一题</span>
            <span ng-show="currentQuestionNum==questions.length-1" style="cursor: pointer;">完成</span>
        </div>
    </div>
</div>

<script src="/assets/js/common/app.js"></script>
<script src="/assets/js/service/restful.js"></script>
<script src="/assets/js/controller/campaign/quiz.js"></script>
</body>
</html>