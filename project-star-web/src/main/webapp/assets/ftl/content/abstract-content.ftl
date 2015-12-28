<#macro abstractcontent>
<style>
    .text-mask {
        display: block;
        /*width: 100%;*/
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

<div class="container" style="">
    <a href="/content/article/${articleInfo.id}">
        <img class="background-img" style="" src="${articleInfo.imageurl!''}" />
    </a>
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
</#macro>