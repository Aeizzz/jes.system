//js中格式化时间类型  yyyy-mm-dd
function formatDate (date){
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? '0' + m : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    return y + '-' + m + '-' + d;
}
/**
 *格式化数字两位小数*/
function formatNumber2dot(dom) {
    if(!isNaN(dom)){
        return Number(dom).toFixed(2);
    }else{
        return dom;
    }
}