"use strict"

app.controller('quiz', function ($scope, $q, restful) {
    $scope.nextQuestion = function () {
        $scope.currentQuestionNum ++;
    }

    $scope.prevQuestion = function () {
        $scope.currentQuestionNum --;
    }

    $scope.answer = function (questionNum, answer) {
        $scope.questions[questionNum].answer = answer;
    }

    function initQuiz(){
        $scope.currentQuestionNum = 0;
        $scope.questions = [
            {question:'你喜欢的颜色是什么1？',options:['红色','黄色','黑色','绿色'],answer:null}
            ,{question:'你喜欢的颜色是什么2？',options:['红色','黄色','黑色','绿色'],answer:null}
            ,{question:'你喜欢的颜色是什么3？',options:['红色','黄色','黑色','绿色'],answer:null}
        ]

    }

    function init() {
        initQuiz();
    }

    init();
});



