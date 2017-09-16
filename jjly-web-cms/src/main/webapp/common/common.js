//窗口大小变化的时候触发
window.onresize = function() {
	var winWidth = $(window).width();
	// 窗口大小在1050以内，隐藏h3，使得菜单缩小
	if(winWidth <= 1340) {
		hideNavBar();
	} else {
		showNavBar();
	}
}

/* ie浏览器判断 */
function compatible(){
//ie
if (isIE()) {
    location.href='/error/ie-remind';
 }
}

//浏览器刷新的时候触发
window.onload = function() {
    //ie浏览器判断
    compatible();
	var winWidth = $(window).width();
	if(winWidth <= 1340) {
		hideNavBar();
	} else {
		showNavBar();
	};
	//遮罩层
	function addMask() {
		var winWidth = $(window).width() + 19;
		var winHeight = $(window).height();
		$('.popups .mask').css({
			'width' : winWidth,
			'height' : winHeight
		});
		$(document.body).css("overflow","hidden");
	}
	 //addMask();//遮罩层调用
};
//菜单栏
$(function() {
	//pages分页样式---------------------------
	$('.pages ul li').hover(function() {
		var liClass = $(this).prop("className");
		if(liClass == '') {
			$(this).addClass('selects');
		}
	}, function() {
		$(this).removeClass('selects');
	});
	// 左侧菜单栏功能和样式JS--------------------------------
	//菜单如果小于1040的时候，hover效果将h3显示
	$('.nav').hover(function() {
		var winWidth = $(window).width();
		// if(winWidth <= 1235) {
			
		// };
		showNavBar();
	}, function() {
		var winWidth = $(window).width();
		if(winWidth <= 1340) {
			hideNavBar();
		};
	})

	//左侧菜单栏nav点击展开菜单
	iniNavMenuOnClick();
	//菜单栏收起按钮
	$('.nav .packges').click(function() {
		//获取属性值
		var ispak = $('.nav .packges').attr('ispak');
		if(ispak == '1') {
			showNavBar();
		} else {
			hideNavBar();
		}
	});
});
//各个页面JS
$(function() {
	//客户管理过滤样式
	$('.cus_manager .filters .filter li').click(function() {
		$(this).addClass('selects').siblings().removeClass('selects');
	});
});

/**
 * 左侧菜单添加点击事件
 */
function iniNavMenuOnClick() {
	// 左侧菜单栏nav点击展开菜单
	$('.nav a').click(function() {

		if ($(this).parent().is('active')) {
			$(this).parent().siblings().removeClass("active");
		} else {
			$(this).parent().addClass("active")
			$(this).parent().siblings().removeClass("active");
		}
		// var index = $(this).index();
		// openNewHtml(index);
	});
}

// 处理select 下拉框事件
function initSelect(selectId, showId) {
	$("#" + showId).html($('#'+ selectId +' option').eq(0).html());  
	//初始化下拉框默认值
	var optinValue = $('#'+ selectId +' option').eq(0).val();
	$("#" + selectId).bind("change",function(){ 
    if($(this).val()==""){
      return; 
    } 
    else{
      $("#" + showId).html($('#'+ selectId +' option[value='+$(this).val()+']').html());	
    } 
  });
};


//处理所有select 下拉框事件
function initSortsSelectList() {
	$(".sorts-select-list" ).each(function(){
		var showDiv = $(this).parent().find(".show");
		var optionName = $(this).find("option:selected").html();
		showDiv.html(optionName);
		$(this).bind("change",function(){ 
		    if($(this).val()==""){
		        return; 
		      } 
		      else{
		    	 var currOptionName = $(this).find("option:selected").html();
		    	  showDiv.html(currOptionName);	
		      } 
		 });
	});  
};

//编辑选中 处理select 下拉框事件 belInd指的是下拉列表的id，showInd是显示值的id，selectValue是选中的值
function editSelectOptions(belInd,showInd,selectValue){
	//设置值
	$('#'+ belInd).val(selectValue);
	$("#"+ belInd +" option[value='"+selectValue+"']").attr("selected",true);
	$("#" + showInd).html($("#"+belInd+" option[value='"+selectValue+"']").html());
}
//处理input 文本框 占位符兼容问题
function setPlaceHolder(id) {
	if(!placeholderSupport()){  
	    $('#'+id).focus(function() {
	        var input = $(this);
	        if (input.val() == input.attr('placeholder')) {
	            input.val('');
	            input.removeClass('placeholder');
	        }
	    }).blur(function() {
	        var input = $(this);
	        if (input.val() == '' || input.val() == input.attr('placeholder')) {
	            input.addClass('placeholder');
	            input.val(input.attr('placeholder'));
	        }
	    }).blur();
	};
};
//显示菜单栏
function showNavBar(navWdth) {
	var oldWdth = 240;
	if(navWdth) {
		oldWdth = navWdth;
	}
	$("#nav").removeClass("nav-min");
	//恢复nav的宽度
	$('.nav').css({
		'width' : '240px'
	});
	//设置mains内容块padding值
	$('.mains').css({
		'padding-left' : oldWdth + 'px'
	});
	//初始化“收起”按钮的属性值
	$('.nav .packges').attr('ispak','0');
};
//隐藏菜单栏
function hideNavBar() {
    $("#nav").addClass("nav-min");
	//缩小nav的宽度
	$('.nav').css({'width' : '55px'});
	//设置mains内容块padding值
	$('.mains').css({'padding-left' : '55px'});
	//初始化“收起”按钮的属性值
	$('.nav .packges').attr('ispak','1');
};
// 判断浏览器是否支持 placeholder
function placeholderSupport() {
   return 'placeholder' in document.createElement('input');
};
//判断时间大小校验
function checkEndTime(startTime,endTime){
	var start=new Date(startTime.replace("-", "/").replace("-", "/"));
	var end=new Date(endTime.replace("-", "/").replace("-", "/"));
	if(end<start){
		return false;
	}
	return true;
}
//详情页跳转顶部
function  pageScrollTop() {
	window.scrollTo(0,0);
}
//是否IE
function isIE(){
    if (window.navigator.userAgent.indexOf("MSIE")>=1){
        return true;
    }else{
		//
        if (!!window.ActiveXObject || "ActiveXObject" in window){
            return true;
        }else{
            return false;
        }
    }
}

