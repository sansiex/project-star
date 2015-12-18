/**
 * Created by zuhai.jiang on 2015/12/9.
 */
"use strict"

app.factory('heatmapService', function (restful) {
    var svc = {
        map: {
            map: null
            , heatmap: null
            , showHeatmap: true
        }
    };

    svc.map.convert = function (posArr, callback) {
        var latlngArr = posArr.map(function (item) {
            return new qq.maps.LatLng(item.lat, item.lng);
        });
        qq.maps.convertor.translate(latlngArr, 6, callback);
    }

    svc.map.init = function (eleId, position, callback) {
        svc.map.convert([position], function(res){
            var point = res[0];
            svc.map.map = new qq.maps.Map(document.getElementById(eleId), {
                zoom: 11,
                //center: new qq.maps.LatLng(31.2303122784, 121.4735623090)
                center: point
            });
            qq.maps.event.addListenerOnce(svc.map.map, "idle", function () {
                if (QQMapPlugin.isSupportCanvas) {
                    svc.map.heatmap = new QQMapPlugin.HeatmapOverlay(svc.map.map,
                        {
                            //点半径，设置为1即可
                            "radius": 1,
                            //热力图最大透明度
                            "maxOpacity": 0.8,
                            //是否在每一屏都开启重新计算，如果为true则每一屏都会有一个红点
                            "useLocalExtrema": true,
                            //设置大小字段
                            "valueField": 'count'
                        }
                    );

                    if (callback != null) {
                        callback();
                    }
                } else {
                    alert("您的浏览器不支持canvas，无法绘制热力图！！");
                }
            });
        });
    }

    svc.map.setHeatmapData = function (locations) {
        var max = locations.reduce(function (a, b) {
            return Math.max(a, b);
        }, 0);

        svc.map.convert(locations, function(res){
            locations.forEach(function(item, i){
                item.lat = res[i].lat;
                item.lng = res[i].lng;
            });

            var data = {
                max: max
                , data: locations
            };
            //绘制热力图
            svc.map.heatmap.setData(data);
        });
    }

    svc.map.showHeatmap = function () {
        svc.map.heatmap.show();
    }

    svc.map.hideHeatmap = function () {
        svc.map.heatmap.hide();
    }

    svc.map.moveTo = function moveTo(lat, lng) {
        svc.map.convert([{lat:lat, lng:lng}], function(res){
            svc.map.map.panTo(new qq.maps.LatLng(res[0].lat, res[1].lng));
        });

    }

    svc.getUserLocations = function (cityId, gender) {
        var url = '/userProfile/locations';
        var params = {cityId: cityId, gender: gender}
        return restful.post(url, params, {
            filter: function (resp) {
                var data = resp.result;
                return data;
            }
        });
    }

    svc.getCityLocation = function (cityId) {
        var url = '/userProfile/cityLocation';
        var params = {cityId: cityId}
        return restful.post(url, params, {
            filter: function (resp) {
                var data = resp.result;
                return data;
            }
        });
    }

    svc.getPerspective = function (dim, conditions) {
        var url = '/userProfile/perspective';
        var params = {dim: dim, conditions: conditions}
        return restful.post(url, params, {
            filter: function (resp) {
                var data = resp.result;
                return data;
            }
        });
    }

    svc.buildSingleColumnOptions = function (valueMap, meta) {
        var values = [];
        for (var k in valueMap) {
            values.push({key: k, value: valueMap[k]});
        }
        if (meta.order != null) {
            values.sort(function (a, b) {
                return parseInt(a.key) - parseInt(b.key);
            });
            if (!meta.order) {
                values.reverse();
            }
        }
        var x = {
            categories: values.map(function (item) {
                var trans = meta.value;
                if (trans == null) {
                    return item.key;
                } else if (typeof trans == 'object') {
                    return trans[item.key];
                } else if (typeof trans == 'function') {
                    return trans(item.key);
                } else {
                    return item.key;
                }
            })
        };

        var series = [{
            name: meta.title, data: values.map(function (item) {
                return parseInt(item.value);
            })
        }];
        var options = {
            chart: {
                type: 'column'
            },
            title: {
                text: meta.title
            },
            //subtitle: {
            //    text: 'Source: WorldClimate.com'
            //},
            xAxis: x,
            yAxis: {
                min: 0,
                title: {
                    text: '人数'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">' + meta.title + ':{point.key}</span><table>',
                //pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                pointFormat: '<tr><td style="color:{series.color};padding:0">人数: </td>' +
                '<td style="padding:0"><b>{point.y}</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: series
        }

        return options;
    }

    return svc;
});

