/**
 * 
 * @Discription jquery定制弹窗和alert，confirm弹窗
 * @Email  hxiangnan@126.om
 * @Project mall-buy-pc
 * @Author  黄乡南
 * @Date  2015年1月7日
 * @dependent jquery1.6以上
 * 
 */
;!(function($) {
    $.fn.easywindow = function (s,url) {
    	var window={
    		currWindow: null,
    		data:{},
	    	open:function(){
	    		this.currWindow.find(".popups").show();
	    		//this.currWindow.find("."+this.data.windowType).show();
	    	},
	    	refresh:function(){
	    		
	    	},
	    	close:function(){
	    		this.currWindow.find(".popups").hide();
	    		//this.currWindow.find("."+this.data.windowType).hide();
	    		this.currWindow.empty();
	    	},
	    	initHtmlText:function(){
	    		var html = '<div class="loading"><img src="'+$.easymsg.loadingGifBase64+'"></div>';
	         	this.currWindow.append(html);
	    		this.ajaxHtml();
	    	},
	    	ajaxHtml:function(){
	    		var window = this;
	    		 $.ajax({
	    			   url: url,
	    			   async: true,
	    			   success:function(data){
	    				   // 清空弹框内容
	    				   window.currWindow.empty();
	    				   //向弹窗增加文档
	    				   window.currWindow.append(data);
	    				   //打开弹窗
	    				   window.open();
	    				   //初始化弹出关闭按钮点击时间
	    				   initDelPopusClick();
	    				   
	    			   }
	    		 });
	    	}
    	};
     	var currWindow =$(this);
     	window.currWindow=currWindow;
    	if(s=='open'){
    		window.open();
    		return ;
    	}
    	if(s=='refresh'){
    		var data = currWindow.prop("data");
    		data[url]=url;
    		currWindow.prop("data",data);
    		window.data=data;
    		window.open();
    		return ;
    	}
    	if(s=='close'){
    		window.close();
    		return ;
    	}
    	
    	window.data=parseDataOptionsToJSON(currWindow.attr('data-options'));
    	var datas = s,
	   	 title =s.title||"提示",
	   	 windowType=s.windowType||window.data.windowType||'reviewed',
	   	 url=s.url;
    	window.data['title']=title;
    	window.data['url']=url;
    	window.data['windowType']=windowType;
    	currWindow.prop("data",window.data);
    	window.initHtmlText();
    	
    }
    /**
     * optType 操作类型；
     * data 数据 ；
     */
    $.fn.easytree =function (optType,data) {
    	var $currTree = $(this);
    	if(optType=="getChecked"){
    		var allCheckedNodes=[];
    		allCheckedNodes = findAllChecked($currTree);
    		
    		return allCheckedNodes
    	}
    	if(optType=="reloadHtml"){
			//添加树形数据到树节点里
    		$currTree.append(data);
    		//初始化树的父节点点击事件
    		iniArrowBox();
    		iniCheckboxOnClick();
    	}
    } 
    /**
     * 获取所有选中的多选框
     */
    function findAllChecked($currTree){
    	var allCheckedNodes=[];
    	var node={};
    	$currTree.find("input:checkbox[name='id']:checked").each(function(i){
    		var $currInput=$(this);
			node={};
			node.id=$currInput.val();
			allCheckedNodes[i]=node;
		});
    	return allCheckedNodes;
    }
    /**
     * 初始化树的父节点点击事件
     */
    function iniArrowBox(){
    	$(".arrow-box").each(function(){
    		
    	$(this).parent().on('click',function(){
    		if($(this).parent().is('.active')){
    			$(this).parent().removeClass('active').next().hide();
    		}else{
    			$(this).parent().addClass('active').next().show();
    		}
    	});
    	
    	});
    }
    /**
     * 初始化树的多选框选中事件，当父级树选中或取消选中的时候，子级的所有复选框也都选中或取消选中
     */
    function iniCheckboxOnClick(){
    	$(".easytree-checkbox").each(function(){
	    	var $currClickCheckbox=$(this);
	    	$currClickCheckbox.on('click',function(){
	    		//alert($currClickCheckbox.is(':checked'))
	    		setCheckbox("tree-childers"+$currClickCheckbox.val(),$currClickCheckbox.is(':checked'));
	    	});
    	});
    }
    /**
     * 设置树形子级多选框是否选择
     */
    function setCheckbox(className,isChecked){
    	$("."+className+" input[type='checkbox']").each(function(){
    		$(this).prop("checked",isChecked);
    	});
    };
    
    $.easymsg= {
    		loadingGifBase64:'data:image/gif;base64,R0lGODlhUABQAJEAADOZ/8zMzAAAAAAAACH/C05FVFNDQVBFMi4wAwEAAAAh+QQFCgACACwAAAAAUABQAAACqZSPqcvtD6OctNqLs968+w+G4kiW5omm6sq27gvH8kzX9o3n+s7DwR/oWYBA4YRINCqKByRTaUA2nUGogBrFWrVXqbXrzf6+0ye5YT6Dq+qFs+0OdwCxNzxhvyOS+r7//5HWJzfIJwJAx0L4gegiCAgZKTlJecQGaDiX6POY0SgzVik6GirRaZP5cFqT6rDKelkm+apGO3qLm6u7y9vr+wscLDxMXGw8UQAAIfkEBQoAAgAsKAA3AAwABgAAAg2Uf6DICoycg2lRMW8BACH5BAUKAAIALBgAIAAkABsAAAIslI+pm8EPo5y02ouz3rz7DwqBEypjiabqyrYAwL7vKsO03eZ6Mt99WovhPAUAIfkEBQoAAgAsFQAnACUADQAAAiAULqnL7XzimxRGUPO8WHvbfeJIluaJpurKtl8QuA5cAAAh+QQFCgACACwXAB4AHQAfAAACMRQOosvti9CbMx6KmU05795F4EiW5omm6sq27gvH8kzX9o3nYMC/fODrlX5BoIs4KQAAIfkEBQoAAgAsGAAXAAwAJAAAAimUL6CI6pzca3LRCjGMYPsPhuJIluaJpuq6BsHnul78zjVryrYO0fBdAAAh+QQFCgACACwVABQAGQAYAAACLZSPicCg/1qDVEhZ42VZbd4tX5hspDed6sq27gvH8kzXSIC/+O7ueesL6H6tAgAh+QQFCgACACwXAB4ABgAGAAACCFQehsvNekQBACH5BAUKAAIALB0AFwAHAAcAAAIKlIJ2mOwP2ZKGFgAh+QQFFAACACwmABQACAAIAAACDJSCYZfIDaOcL61mCgA7',
    		/**
    		 * 显示一个提示窗口。参数：
			title： 显示在头部面板的标题文字。
			msg： 显示的消息文字。
			icon： 显示图标的图片。可用的值是： error、question、info、warning。
			fn： 窗口关闭时触发的回调函数。
    		 */
    		alert:function(title, msg, icon, fn){
                var icon1 = "info";
                icon1=icon||"info";
                $("body").append('<div class="tips-box"><img src="../images/'+ icon +'.png" width="26" height="26" /><font>'+ msg +'</font></div>');
    
                if($('.tips-box').length>0)
                {
                    $('.popup-delete').show();
                }
                setTimeout(function() {
                    $('.tips-box').remove();
                    if(fn!=null && typeof fn == "function"){
                    	fn();
                    }
                }, 2000);
    		},
    		/**
    		 * 显示一个带“确定”和“取消”按钮的确认消息。参数：
				title： 显示在头部面板上的标题文字。
				msg： 显示的消息文字。
				fn(b)： 回调函数，当用户点击确认按钮时传递一个 true 参数，否则给它传递一个 false 参数。
    		 */
    		confirm:function(title, msg, fn){
    			//confirm(title, msg, fn);
    			 $("body").append('<div class="popup-delete"><div class="mask"><div class="delCusBox"><h2><font>删除客户</font><em class="myCancelBtn"></em></h2><p>您是否确认删除该客户信息</p><div class="btns"><span class="boxBtn myConfirmBtn">确认</span><span class="boxBtn1 myCancelBtn">取消</span></div></div></div>');
    			    
                 if($('.popup-delete').length>0)
                 {
                     $('.popup-delete').find('h2 font').html(title);
                     $('.popup-delete').find('p').html(msg);
                     $('.popup-delete').show();
                 }
                 $(".myCancelBtn").click("on",function(){
                	$('.popup-delete').remove();
                    fn(false);

                 });
                 $(".myConfirmBtn").click("on",function(){
                	$('.popup-delete').remove();
                    fn(true);
                 });
    		},
    		/**
    		 * 显示一个加载弹出，提示用户正在加载数据
    		 * isOpen:是否打开加载动画
    		 */
    		loadingWindow:function(isOpen){
    			if(isOpen==true||isOpen=='open'){
    				 $("body").append('<div class="loading"><img src="'+this.loadingGifBase64+'"></div>');
    			}else if(isOpen==false||isOpen=='close'){
    				 $("body").remove('.loading');
    			}else{
    				 $("body").remove('.loading');
    			}
    			
    			
    		}
    	
    }
    
   function parseDataOptionsToJSON(str){
	   var json ={};
	   if(str==null||str==''){
		   return  json;
	   }
	  var strs =  str.split(",");
	  
	  for ( var i in strs) {
		  var strs2 = strs[i].split(":");
		  json[strs2[0]]=strs2[1];
	  }
	   return json;
   }
    function initDelPopusClick(){
    	$(".del-popups").click(function(call){
    		var popus= $(".popups");
    		popus.hide();
    	});
    }
   /* $(".easy-window").easywindow({title:"ttt",divClass:"reviewed",url:"/role/role-input"});
    $(".easy-window").easywindow("open");*/
})(jQuery); 
