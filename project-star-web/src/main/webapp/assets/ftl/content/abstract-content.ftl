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
        /*bottom: 0;*/
        background-color: rgba(0, 0, 0, 0.5);
        padding: 10px;
        cursor: pointer;
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

    .footer {
        display: block;
        width: 100%;
        height: auto;
        bottom: 0;
        text-align: center;
        background-color: black;
        padding:10px;
    }

    .lastArticle {
        float: left;
        color: #FFFFFF;
        cursor: pointer;
    }

    .nextArticle {
        float: right;
        color: #FFFFFF;
        cursor: pointer;
    }

    .viewArticle {
        color: #FFFFFF;
        cursor: pointer;
    }

    .background-img {
        cursor: pointer;
        display: block;
        height: 100%;
        width: auto;
        margin-left: auto;
        margin-right: auto;
    }

</style>
<script>
    var id = ${articleInfo.id};
</script>

<div class="container" style="">
    <div>
        <div id="bgimglink" ng-click="viewArticle()">
            <img ng-show="beforeArticle!=null" id="beforebgimg" class="background-img" style="display:none"
                 src="{{beforeArticle.imageurl}}"/>
            <img id="bgimg" class="background-img" style="" src="${articleInfo.imageurl!''}"/>
            <img ng-show="afterArticle!=null" id="afterbgimg" class="background-img" style="display:none"
                 src="{{afterArticle.imageurl}}"/>
        </div>
        <div class="text-mask">
            <div class="linear-gradient-mask"></div>
            <div class="transparent-mask" ng-click="showFooter = !showFooter">
                <span class="abstract-title">
                ${articleInfo.title!''}
                </span>
                <br>
                <span class="abstract-text" ng-click="switchFoo">
                ${articleInfo.abstracttext!''}
                </span>
            </div>
            <div class="footer" ng-show="showFooter">
                <span class="lastArticle" ng-show="beforeArticle!=null" ng-click="toBefore()">上一篇</span>
                <span class="viewArticle" ng-click="viewArticle()">查看文章</span>
                <span class="nextArticle" ng-show="afterArticle!=null" ng-click="toAfter()">下一篇</span>
            </div>
        </div>
    </div>
</div>
</#macro>