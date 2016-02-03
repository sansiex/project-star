"use strict"

app.controller('matchPeople', function ($scope, $q, restful) {
    function initMarquee() {
        $scope.images = [
            {src: '/assets/img/campaign/matchpeople/ailing.png'}
            , {src: '/assets/img/campaign/matchpeople/chenkun.png'}
            , {src: '/assets/img/campaign/matchpeople/lienong.png'}
            , {src: '/assets/img/campaign/matchpeople/musk.png'}
            , {src: '/assets/img/campaign/matchpeople/yaochen.png'}
        ];

        $scope.imageWidth = 300;
        $scope.marqueeWidth = $scope.images.length * $scope.imageWidth;
        $scope.left1 = 0;
        $scope.left2 = $scope.marqueeWidth;

        function run() {
            var demo = document.getElementById("marquee");
            var demo1 = document.getElementById("marquee1");
            var demo2 = document.getElementById("marquee2");
            var speed = 1;    //滚动速度值，值越大速度越慢
            demo2.innerHTML = demo1.innerHTML    //克隆demo2为demo1
            function Marquee() {
                $scope.left1 -= speed;
                $scope.left2 -= speed;
                if ($scope.left1 < 0 - $scope.marqueeWidth) {
                    $scope.left1 = $scope.left2 + $scope.marqueeWidth;    //demo跳到最顶端
                }
                if ($scope.left2 < 0 - $scope.marqueeWidth) {
                    $scope.left2 = $scope.left1 + $scope.marqueeWidth;    //demo跳到最顶端
                }
                $scope.$digest();
            }

            var MyMar = setInterval(Marquee, speed);        //设置定时器
            demo.onmouseover = function () {
                clearInterval(MyMar)
            }    //鼠标经过时清除定时器达到滚动停止的目的
            demo.onmouseout = function () {
                MyMar = setInterval(Marquee, speed)
            }    //鼠标移开时重设定时器
        }

        setTimeout(run, 1000);
    }

    function init() {
        initMarquee();
    }

    init();
});



