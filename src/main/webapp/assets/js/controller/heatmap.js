"use strict"

app.controller('heatmap', function ($scope, $q, restful, heatmapService) {
    //
    //$scope.setData = function(){
    //    var testData = {
    //        max: 100,
    //        data: [
    //            {"lng": 121.4702823090, "lat": 31.2325372784, "count": 50},
    //            {"lng": 121.5004080654, "lat": 31.2378694310, "count": 51},
    //            {"lng": 121.4846704484, "lat": 31.2358497830, "count": 75},
    //            {"lng": 121.4689893090, "lat": 31.2322282784, "count": 40},
    //            {"lng": 121.4790383608, "lat": 31.2282745548, "count": 100},
    //            {"lng": 121.4631351728, "lat": 31.2219368236, "count": 68},
    //            {"lng": 121.4486096898, "lat": 31.2249940700, "count": 18},
    //            {"lng": 121.4461227927, "lat": 31.2242877422, "count": 80},
    //            {"lng": 121.4495436898, "lat": 31.2241290700, "count": 11}
    //        ]
    //    };
    //
    //    heatmapService.map.setHeatMapData(testData);
    //}

    $scope.query = function(){
        disableQuery();

        var cityId = getSelectedCity();
        var gender = getSelectedGender();
        var queries = [
            heatmapService.getCityLocation(cityId)
            ,heatmapService.getUserLocations(cityId, gender)
        ]
        $q.all(queries).then(function(data){
            var cityLocation = data[0];
            var userLocations = data[1];

            showMap(cityLocation, userLocations);
            enableQuery();
        }, function(e){
            console.log(e);
            enableQuery();
        });

        showPerspectives();
    }

    function enableQuery(){
        $scope.controls.queryText = '查询';
        $scope.controls.queryEnabled = true;
    }

    function disableQuery(){
        $scope.controls.queryText = '查询中...';
        $scope.controls.queryEnabled = false;
    }

    function getSelectedCity(){
        return $scope.controls.city.val();
    }

    function getSelectedGender(){
        return $scope.controls.gender.val();
    }

    function getConditions(){
        var city_id = getSelectedCity();
        var gender = getSelectedGender();
        var conditions = ['prefer_city_id='+city_id];
        if (gender>-1) {
            conditions.push('user_sex='+gender);
        }
        return conditions;
    }

    function showMap(cityLocation,locations){
        if ($scope.map == null) {
            initMap(cityLocation, locations);
        } else {
            setMap(cityLocation, locations);
        }
    }

    function setMap(cityLocation,locations){
        heatmapService.map.moveTo(cityLocation.lat, cityLocation.lng);
        heatmapService.map.setHeatmapData(locations);
    }

    function initMap(cityLocation,locations){
        $scope.map = {
            displayHeatmap:true
        }

        var max = locations.reduce(function(a, b){
            return Math.max(a, b);
        }, 0);
        heatmapService.map.init("map-canvas", {lat:cityLocation.lat, lng:cityLocation.lng}, function(){
            //test data form baidu.com
            //var testData = {
            //    max: 100
            //    ,data: [
            //        {"lng": 121.4743793090, "lat": 31.2309322784, "count": 87},
            //        {"lng": 121.4698513090, "lat": 31.2322282784, "count": 42},
            //        {"lng": 121.4720073090, "lat": 31.2340812784, "count": 94},
            //        {"lng": 121.4776843090, "lat": 31.2343282784, "count": 27},
            //        {"lng": 121.4758163090, "lat": 31.2345752784, "count": 23},
            //        {"lng": 121.4472007927, "lat": 31.2242877422, "count": 60},
            //        {"lng": 121.4614373158, "lat": 31.2288950626, "count": 58},
            //        {"lng": 121.4579065864, "lat": 31.2293593114, "count": 15}
            //    ]
            //};

            heatmapService.map.convert(locations);
            //绘制热力图
            heatmapService.map.setHeatmapData(locations);
        });
    }

    function showPerspectives() {
        var conditions = getConditions();
        $scope.perspectives.forEach(function(item){
            showPerspective(item, conditions);
        });
    }

    function showPerspective(perspective, conditions){
        var dim = perspective.field;
        heatmapService.getPerspective(dim, conditions).then(function(map){
            var options = heatmapService.buildSingleColumnOptions(map, perspective);
            var ele = $('#column-'+perspective.field);
            ele.highcharts(options);
        });
    }

    function initSelect(){
        $scope.controls = {};
        $scope.controls.gender = $('#gender').select2();
        $scope.controls.city = $('#city').select2();
    }

    function initPerspectives(){
        $scope.perspectives=[
            {title:'性别', field:'user_sex'}
            ,{title:'交易活跃度', field:'dp_trade_active_level', order:true}
        ];
    }

    function init(){
        initSelect();
        enableQuery();
        initPerspectives();
    }

    init();
});



