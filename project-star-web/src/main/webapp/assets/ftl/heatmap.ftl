<#macro lib>
<link rel="stylesheet" href="/assets/css/bootstrap/bootstrap-table.css">
<link rel="stylesheet" href="/assets/css/select2/select2.min.css">
<link rel="stylesheet" href="/assets/css/abstract.css">

<#--<script src="/assets/js/lib/bootstrap/bootstrap-table.min.js"></script>-->
<#--<script src="/assets/js/lib/bootstrap/bootstrap-table-zh-CN.min.js"></script>-->
<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp&key=QR3BZ-FPIR5-VO3ID-QBUQB-3YNG7-BKFBY"></script>
<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp&key=QR3BZ-FPIR5-VO3ID-QBUQB-3YNG7-BKFBY&libraries=convertor"></script>
<script src="/assets/js/lib/select2/select2.full.min.js"></script>
<script src="/assets/js/lib/qqmap/heatmap.min.js"></script>
</#macro>

<#macro content>

<div class="mod_header" style="width: auto;">
    <h2>人群分析</h2>
    <hr>
    <div class="sm-row-12 well well-lg">
        <span>性别</span>
        <select id="gender" style="width: 80px">
            <option value="-1" selected>不限</option>
            <option value="1">男</option>
            <option value="0">女</option>
        </select>
        <span>城市</span>
        <select id="city" style="width: 80px">
        <#--<option value="null" selected>不限</option>-->
            <option value="1" selected>上海</option>
            <option value="2">北京</option>
        </select>
    </div>
    <div>
        <button ng-disabled="!controls.queryEnabled" class="btn btn-primary" ng-click="query()" style="width: 80px">{{controls.queryText}}</button>
    </div>
</div>

<div ng-repeat="item in perspectives" class="data-panel">
    <div class="title">
        <h3>{{item.title}}</h3>
    </div>
    <div id="column-{{item.field}}"></div>
</div>

<div class="data-panel">
    <div class="title">
        <h3>热力图</h3>
    </div>
    <div class="heatmap" style="width:100%;height:600px" id="map-canvas">
</div>

</#macro>

<#macro js>
<script src="/assets/js/service/abstract.js"></script>
<script src="/assets/js/controller/abstract.js"></script>
<script src="/assets/js/lib/hcharts/highcharts.js"></script>
<script src="/assets/js/lib/hcharts/highcharts-3d.js"></script>
</#macro>

