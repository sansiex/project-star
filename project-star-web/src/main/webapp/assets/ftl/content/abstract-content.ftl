<#macro abstractcontent>
<div class="container" style="">
    <a href="/content/article/${articleInfo.id}">
        <img class="background-img" style="" src="${articleInfo.imageurl!''}" />
    </a>
</div>
<div class="text-mask">
    <div class="linear-gradient-mask"></div>
    <div class="transparent-mask">
        <span class="abstract-text">
        ${articleInfo.abstracttext!''}
        </span>
    </div>
</div>
</#macro>