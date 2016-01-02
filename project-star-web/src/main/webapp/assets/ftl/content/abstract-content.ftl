<#macro abstractcontent>
<style>
    .text-mask {
        display: block;
        height: auto;
        position: fixed;
        bottom: 0;
    }

    .transparent-mask {
        display: block;
        width: 100%;
        height: auto;
        /*position: fixed;*/
        bottom: 0;
        background-color: rgba(0, 0, 0, 0.5);
        padding: 10px;
    }

    .linear-gradient-mask {
        display: block;
        width: 100%;
        height: 15px;
        /*position: relative;*/
        background-image: linear-gradient(bottom, rgba(0, 0, 0, 1) 0%, rgba(255, 255, 255, 0) 100%);
        background-image: -o-linear-gradient(bottom, rgba(0, 0, 0, 1) 0%, rgba(255, 255, 255, 0) 100%);
        background-image: -moz-linear-gradient(bottom, rgba(0, 0, 0, 1) 0%, rgba(255, 255, 255, 0) 100%);
        background-image: -webkit-linear-gradient(bottom, rgba(0, 0, 0, 0.5) 0%, rgba(0, 0, 0, 0) 100%);
        background-image: -ms-linear-gradient(bottom, rgba(0, 0, 0, 1) 0%, rgba(255, 255, 255, 0) 100%);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#000000, endColorstr=#ffffff, grandientType=1);
    }

    .abstract-text {
        color: white;
        font-size: 12px;
    }

    .abstract-title {
        color: white;
        font-weight: bold;
        font-size: 20px;
    }

    .background-img {
        display:block;
        height:100%;
        width: auto;
        margin-left: auto;
        margin-right: auto;
    }
</style>

<script>
    $(function() {
        var startX, startY, endX, endY;
        var down = false;
        function touchStart(event) {
            var touch = event.touches[0];
            startY = touch.pageY;
            startX = touch.pageX;
        }
        function touchMove(event) {
            console.log('move');
            var touch = event.touches[0];
            //endY = (startY - touch.pageY);
            endX = touch.pageX;
        }
        function touchEnd(end) {
            $("#bgimg").hide();
            if ((startX - endX) > 300) {
                $("#afterbgimg").show();
            } else if ((startX - endX) < -300) {
                $("#beforebgimg").show();
            }
        }
        function mouseStart(event) {
            down = true;
            console.log('start');
            startY = event.pageY;
            startX = event.pageX;
        }
        function mouseMove(event) {
            if (!down) {
                return;
            }
            console.log('move');
            //endY = (startY - touch.pageY);
            endX = event.pageX;
        }
        function mouseEnd(end) {
            down = false;
            console.log('start');
            $("#bgimg").hide();
            if ((startX - endX) > 300) {
                $("#afterbgimg").show();
            } else if ((startX - endX) < -300) {
                $("#beforebgimg").show();
            }
        }
        document.getElementById("bgimglink").addEventListener("touchstart", touchStart, false);
        document.getElementById("bgimglink").addEventListener("touchmove", touchMove, false);
        document.getElementById("bgimglink").addEventListener("touchend", touchEnd, false);
        document.getElementById("bgimglink").addEventListener("mousedown", mouseStart, false);
        document.getElementById("bgimglink").addEventListener("move", mouseMove, false);
        document.getElementById("bgimglink").addEventListener("mouseup", mouseEnd, false);
    })
</script>

<div class="container" style="">
    <div class="swiper-wrapper">
        <div id="bgimglink" ng-click="viewArticle()">
            <img ng-show="beforeArticle!=null" id="beforebgimg" class="background-img" style="display:none" src="{{beforeArticle.imageurl}}" />
            <img id="bgimg" class="background-img" style="" src="${articleInfo.imageurl!''}" />
            <img ng-show="afterArticle!=null" id="afterbgimg" class="background-img" style="display:none" src="{{afterArticle.imageurl}}" />
        </div>
        <div class="text-mask">
            <div class="linear-gradient-mask"></div>
            <div class="transparent-mask">
        <span class="abstract-title">
        ${articleInfo.title!''}
        </span>
                <br>
        <span class="abstract-text">
        ${articleInfo.abstracttext!''}
        </span>
            </div>
        </div>
    </div>
</div>
</#macro>