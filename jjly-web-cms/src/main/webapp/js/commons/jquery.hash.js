/**
 * 
 * @Discription 用来监听和改变浏览器url的hash
 * @Email  hxiangnan@126.om
 * @Project dzq
 * @Author  黄乡南
 * @Date  2015年1月7日
 * @dependent jquery1.6以上
 * 
 */
;window["jqeury.hash.js"]||!(function($,win){
	//防止该js重复加载
	window["jqeury.hash.js"]=true;
    $.hash = $.fn.hash = function (str, fn) {
    	if("onhashchange"==str){
    		$.hash.callfn=fn;
    	}
    };
    $.hash.onhashchange=function(hashStr){
    	$.hash.callfn(hashStr);
    };
    $.hash.callfn=function(hashStr){
    	alert(hashStr);
    };
    $.hash.get=function(key){
    	var hashStr = location.hash.replace("#","");
    	return hashStr;
    };
    win.onhashchange=function(){
    	 var hashStr = location.hash.replace("#","");
    	 $.hash.onhashchange(hashStr);
   }
})(jQuery,window);