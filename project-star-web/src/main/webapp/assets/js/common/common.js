var common = {};

common.url = {
    getPath:function(){return location.pathname;}
    ,getParam:function(name){
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
}

common.value = {
    compare:function(a, b, type) {
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }

        if (type == null) {
            type = typeof(a);
        }

        if (type == 'number') {
            return a-b;
        }

        if (type == 'string') {
            return a.localeCompare(b);
        }

        if (type == 'boolean') {
            return a?1:-1;
        }
    }
    ,copyProperties:function(src, dest, ignore){
        if (ignore == null) {
            for (var k in src) {
                dest[k] = src[k];
            }
        } else {
            for (var k in src) {
                if (ignore.indexOf(k)<0) {
                    dest[k] = src[k];
                }
            }
        }
    }
}

common.array = {
    append:function(head, tail){
        tail.forEach(function(item){head.push(item);});
    }
    ,sort:function(arr, keys) {
        arr.sort(function (a, b) {
            for (var i = 0;i<keys.length;i++) {
                var key = keys[i];
                var next = keys[i+1];
                var order = true;
                if (next != null && typeof(next)=='boolean') {
                    order = next;
                }

                if (!order) {
                    var c= a;
                    a = b;
                    b = c;
                }

                if (a==null) {
                    return -1;
                }
                if (b==null) {
                    return 1;
                }
                var va = a[key];
                var vb = b[key];
                return common.value.compare(va,vb);
            }
        });
    }
}