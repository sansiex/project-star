<!DOCTYPE HTML>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" />
    <title>HTML5测试</title>
    <script src="/assets/js/lib/jquery/jquery.min.js"></script>
    <script type="text/javascript">
        $(function() {
            var startX, startY, endX, endY;
            var showADID = 1;
            document.getElementById("divADBox").addEventListener("touchstart", touchStart, false);
            document.getElementById("divADBox").addEventListener("touchmove", touchMove, false);
            document.getElementById("divADBox").addEventListener("touchend", touchEnd, false);
            function touchStart(event) {
                var touch = event.touches[0];
                startY = touch.pageY;
                startX = touch.pageX;
                $("#xdiff").html("起点：" + startX + ',' + startY);
                $("#ydiff").html("终点：" + endX + ',' + endY);
            }
            function touchMove(event) {
                var touch = event.touches[0];
                endY = touch.pageY;
                endX = touch.pageX;
                $("#xdiff").html("起点：" + startX + ',' + startY);
                $("#ydiff").html("终点：" + endX + ',' + endY);
            }
            function touchEnd(event) {
                $("#img0" + showADID).hide();
                showADID++;
                if (showADID > 4) {
                    showADID = 1;
                }
                if ((startX - endX) > 100) {
                    $("#img0" + showADID).show();
                }
                $("#xdiff").html("起点：" + startX + ',' + startY);
                $("#ydiff").html("终点：" + endX + ',' + endY);
            }
        })
    </script>
</head>
<body >
<form id="form1">
    <div style="border:solid 1px Red;" id="divADBox">
        <span id="xdiff">X轴移动大小：0</span>
        <span id="ydiff">Y轴移动大小：0</span>
        <img id="img01" src="/resource/img/abstract_zuhai_jiang20151227_172405_346.jpg" style="width:100%;" />
        <img id="img02" src="/resource/img/abstract_zuhai_jiang20151227_213816_009.jpg" style="width:100%;display:none;" />
        <img id="img03" src="/resource/img/abstract_zuhai_jiang20151227_172405_346.jpg" style="width:100%;display:none;" />
        <img id="img04" src="/resource/img/abstract_zuhai_jiang20151227_213816_009.jpg" style="width:100%;display:none;" />
    </div>
</form>
</body>
</html>