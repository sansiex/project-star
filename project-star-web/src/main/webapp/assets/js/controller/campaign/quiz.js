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

    $scope.submitAnswers = function () {
        getResultNum().then(function(result){
            var num = result.result;

            window.location.href = '/campaign/matchpeople/resultPage/'+num;
        },function(result){
            alert(result.resultMessage);
        });
    }

    function getResultNum(){
        var answerArr = [];
        for (var i = 0;i<$scope.questions.length;i++) {
            var q = $scope.questions[i];
            if (q.answer == null) {
                alert('再仔细检查一下，还有题目没有回答哦~');
                return;
            }
            answerArr.push(q.answer);
        }
        var answers = answerArr.join(',');
        var code = common.base64.encode(answers);
        var url = '/campaign/matchpeople/getResultNum';
        return restful.post(url, {answers:code}, {});
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



