/**
 * 
 * @Discription 表单提交防重复 通用工具js
 * @Email  hxiangnan@126.om
 * @Project mall-buy-pc
 * @Author  黄乡南
 * @Date  2015年1月7日
 * @dependent jquery1.6以上
 * 
 */
;(function($) { 
   
    function getRootPath(){
        //获取当前网址，如： http://localhost:8088/test/test.jsp
        var curPath=window.document.location.href;
        //获取主机地址之后的目录，如： test/test.jsp
        var pathName=window.document.location.pathname;
        var pos=curPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8088
        var localhostPaht=curPath.substring(0,pos);
        //获取带"/"的项目名，如：/test
        //var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
//        return(localhostPaht+projectName);
        return(localhostPaht);
    }
	/**这段代码会改变原来jquery的ajax行为，不建议使用
	var ajax = $.ajax; 
    $.ajax = function(s) {
        var oldSuccess = s.success;
        var oldError = s.error;
        s.dataType = s.dataType||'JSON';
        //var $load = $("<div class='loadPic'><img src='../images/loading.gif' width='170' height='170'/></div class='bgbox'><div class='fixedBg'></div>");
        s.beforeSend = function(){
			//$("body").append($load);	
		}
		
        s.success = function(data, textStatus, jqXHR) {     
        	var flag = false;
        	if(data.resultCode == 1100){//登录过期  
        		alert("登录过期，请重新登录。构建中。。。。。。");
        		//fixedWindow('._tlogin_addUp','._tlogin_close'); 
			}else if(data.resultCode == 1200){//无访问权限
				alert("无访问权限。构建中。。。。。。");
				//$.t.confirm("用户尚未激活，是否立即激活",function(){window.location.href="${ctx}/view/register/registermail?account="+varAccount;})
			}else if(data.resultCode == 1300){//表单重复提交。构建中
				alert("表单重复提交。构建中。。。。。。");
			}else{
				flag = true;
				//$load.remove();
			}
        	
        	if(flag){
        		oldSuccess(data, textStatus, jqXHR);
        	}
        }
        s.error = function(e) {
        	//$load.remove();
        	oldError(e);
        }
        ajax(s); 
    }    
   */
    /**
     * ajax设置div内容
     */
    $.ajaxDiv = function(s) {
        var oldSuccess = s.success; 
        var $load = $("<div class='loadPic'><img src='../images/loading.gif' width='170' height='170'/></div class='bgbox'><div class='fixedBg'></div>");
        s.beforeSend = function(){
			$("body").append($load);	
		}
        s.success = function(data, textStatus, jqXHR) {
        	var flag = false;
        	if(data.resultCode == 1001){//登录过期  
        		alert("登录过期");
        		fixedWindow('._tlogin_addUp','._tlogin_close'); 
			}else if(data.resultCode == 1002){//用户尚未激活  
				$.t.confirm("用户尚未激活，是否立即激活",function(){window.location.href="${ctx}/view/register/registermail?account="+varAccount;})
			}else{
				flag = true;
				//$load.remove();
			}

        	if(s.divId != undefined && s.divId != null){
        		$('#' + s.divId).find('*').undelegate().unbind().end().html(data);
        	}
        	
        	if(flag){
        		oldSuccess(data, textStatus, jqXHR);
        	}
        } 
        s.error = function(e) {
        	//$load.remove();
        	oldError(e);
        }
        ajax(s); 
    } 
    
    
    $.fn.commonAjaxSubmit = function (s) {
    	var oldSuccess = s.success; 
    	var oldError = s.error;
    	var currForm = this;
        s.success = function(data, textStatus, jqXHR) {
        	if(typeof data ==  'string'){
				data = $.parseJSON(data);
			}
        	var flag = false;   		
			if(currForm != null){
					$.getJSON(getRootPath() + "/view/formToken/getToken",{},function(innerData){
							if(innerData.resultCode == 1000){
								doUpdateFormToken(currForm,innerData)
								flag = true;
							}									
				        	if(flag){
				        		oldSuccess(data, textStatus, jqXHR);
				        	}
						});
			}		
        }
        s.error = function(e) {
        	$.getJSON(getRootPath() + "/view/formToken/getToken",{},function(innerData){
					if(innerData.resultCode == 1000){
						if(currForm != null){
							doUpdateFormToken(currForm,innerData)
						}
					}
					if(undefined != oldError){
						oldError(e);
					}
				}
			);
        }
        this.ajaxSubmit(s); 
    }  
    
    $.fn.form2JSON = function (formId) {
    	if(formId!=null&&formId!=''){
    		return serializeArrayPagerForm($(formId));
    	}else{
    		return serializeArrayPagerForm($(this));
    	}
    }  
    function serializeArrayPagerForm(form){
    	var formParams  = form.serializeArray();
    	 var params  = {'page':'0','rows':'20'};
    	 $.each(formParams, function(i, field){
    		 if(field.value!=null&&field.value!=''){
    	      params[field.name]=field.value;
    		 }
    	  });
    	 return params;
    }
    function doUpdateFormToken(currForm,innerData){
    	var input1  = currForm.find("input[name='"+innerData.resultObj.formkey+"']");
    	var tokenKey = input1.val();
    	var input2 = currForm.find("input[name='"+tokenKey+"']");
    	input1.val(innerData.resultObj.formHidden1);
    	input2.attr("name",innerData.resultObj.formHidden1);
    	input2.val(innerData.resultObj.formHidden2);
    }

    /*****/
	window.commonAjax = {
			loadingGifBase64:'data:image/gif;base64,R0lGODlhUABQAJEAADOZ/8zMzAAAAAAAACH/C05FVFNDQVBFMi4wAwEAAAAh+QQFCgACACwAAAAAUABQAAACqZSPqcvtD6OctNqLs968+w+G4kiW5omm6sq27gvH8kzX9o3n+s7DwR/oWYBA4YRINCqKByRTaUA2nUGogBrFWrVXqbXrzf6+0ye5YT6Dq+qFs+0OdwCxNzxhvyOS+r7//5HWJzfIJwJAx0L4gegiCAgZKTlJecQGaDiX6POY0SgzVik6GirRaZP5cFqT6rDKelkm+apGO3qLm6u7y9vr+wscLDxMXGw8UQAAIfkEBQoAAgAsKAA3AAwABgAAAg2Uf6DICoycg2lRMW8BACH5BAUKAAIALBgAIAAkABsAAAIslI+pm8EPo5y02ouz3rz7DwqBEypjiabqyrYAwL7vKsO03eZ6Mt99WovhPAUAIfkEBQoAAgAsFQAnACUADQAAAiAULqnL7XzimxRGUPO8WHvbfeJIluaJpurKtl8QuA5cAAAh+QQFCgACACwXAB4AHQAfAAACMRQOosvti9CbMx6KmU05795F4EiW5omm6sq27gvH8kzX9o3nYMC/fODrlX5BoIs4KQAAIfkEBQoAAgAsGAAXAAwAJAAAAimUL6CI6pzca3LRCjGMYPsPhuJIluaJpuq6BsHnul78zjVryrYO0fBdAAAh+QQFCgACACwVABQAGQAYAAACLZSPicCg/1qDVEhZ42VZbd4tX5hspDed6sq27gvH8kzXSIC/+O7ueesL6H6tAgAh+QQFCgACACwXAB4ABgAGAAACCFQehsvNekQBACH5BAUKAAIALB0AFwAHAAcAAAIKlIJ2mOwP2ZKGFgAh+QQFFAACACwmABQACAAIAAACDJSCYZfIDaOcL61mCgA7',
			contentId:'iframe-contents',
			/**
			 * 用于ajax发送delete请求
			 * @param oSetting {url:'www.baidu.com',dataType:"JSON"返回数据类型,params:{}提交参数,success:function(result){}put请求成功后的回调函数}
			 * @param url 请求地址
			 */
			doDelete:function(oSetting){
				var url = oSetting.url,
				dataType = oSetting.dataType||"JSON",
				params = oSetting.params||{},
				success = oSetting.success||function(result){};
				//console.info("params",params);
				$.ajax({
					url : url,
					type : 'DELETE',
					data : $.extend(params, {}),
					dataType : dataType,
					success : function(result){
						success(result);
					}
				});
			},
			/**
			 * 
			 * @param oSetting {url:'www.baidu.com',params:{}提交参数,success:function(result){}put请求成功后的回调函数}
			 */
			doDeleteJSON:function(oSetting){
				oSetting.dataType='JSON';
				this.doDelete(oSetting);
			},
			/**
			 * 用于ajax发送put请求
			 * @param oSetting {url:'www.baidu.com',dataType:"JSON"返回数据类型,params:{}提交参数,success:function(result){}put请求成功后的回调函数}
			 * @param url 请求地址
			 */
			doPut:function(oSetting){
				var url = oSetting.url,
				dataType = oSetting.dataType||"JSON",
				params = oSetting.params||{},
				success = oSetting.success||function(result){};
				//console.info(oSetting.url);
				//console.info("params",params);
				$.ajax({
					url : url,
					type : 'PUT',
					data : $.extend(params, {
						_dataType:'JSON'//添加默认参数
					}),
					dataType : dataType,
					success : function(result){
						success(result);
					}
				});
			},
			/**
			 * 
			 * @param oSetting {url:'www.baidu.com',params:{}提交参数,success:function(result){}put请求成功后的回调函数}
			 */
			doPutJSON:function(oSetting){
				oSetting.dataType='JSON';
				this.doPut(oSetting);
			},
			/**
			 * get方式请求
			 * @param oSetting
			 */
			doGetJSON : function(oSetting){
				oSetting.dataType='JSON';
				this.doGet(oSetting);
			},
			/**
			 * get方式请求
			 * @param oSetting 
			 * 
			 * 使用示例1：doGet({url:"/role/role-list",dataType:"html",params:{key:value},contentId:"mydivId",callback:function(){成功和失败调用的方法}})
			 * 使用示例2：doGet("open","/role/role-list","mydivId",function(){},function(){})
			 * 
			 * 
			 */
			doGet : function(oSetting,reqUrl,contentId,successCallback,errorCallback){
				if(oSetting=="open"){
					oSetting={};
					oSetting['url']=reqUrl,
					oSetting['success']=successCallback;
					oSetting['error']=errorCallback;
					oSetting['contentId']=contentId;
				}
				
				var url = oSetting.url,
				dataType = oSetting.dataType||"HTML",
				params = oSetting.params||{},
				contentDivId = oSetting.contentId||this.contentId;
				this.contentId = contentDivId;
				success = oSetting.success||function(result){};
				this.initContentDiv();
				var cleanLoading =this.cleanLoading;
				//console.info(oSetting.url);
				//console.info("params",params);
				$.ajax({
					url : url,
					type : 'GET',
					data : $.extend(params, {
						_dataType:'JSON'//添加默认参数
					}),
					dataType : dataType,
					success : function(result){
						if(contentDivId!=null){
							$('#'+contentDivId).find('*').undelegate().unbind().end().html(result);
						}
						success(result);
						
						if(oSetting.success!=null && typeof oSetting.success == "function"){
							oSetting.success(result);
						}
						if(oSetting.callback!=null && typeof oSetting.callback == "function"){
							oSetting.callback(result);
						}
						cleanLoading();
					},
					error:function(){
						if(oSetting.callback!=null && typeof oSetting.callback == "function"){
							oSetting.callback(result);
						}
						if(oSetting.error!=null && typeof oSetting.error == "function"){
							oSetting.error(result);
						}
						cleanLoading();
					}
				});
			},
			doAjax : function(oSetting){
				var url = oSetting.url,
				dataType=oSetting.dataType||'html',
				type=oSetting.type||'POST',
				params = oSetting.params||{},
				contentDivId = oSetting.contentId||this.contentId;
				this.contentId = contentDivId;
				var cleanLoading =this.cleanLoading;
				//console.info("params",params);
				//console.info("url",url);
				$.ajax({
					url : url,
					type : type,
					data : $.extend(params, {
						_dataType:'JSON'//添加默认参数
					}),
					dataType : dataType,
					success : function(result){
						if(result && !result._isError){
							$('#'+contentDivId).find('*').undelegate().unbind().end().html(result);
						}

						if(oSetting.callback!=null && typeof oSetting.callback == "function"){
							oSetting.callback();
						}
						cleanLoading();
					}
				});
			},
			clearForm: function(form){
				try{
					if(typeof form == 'string'){
						if(form.indexOf('#')==-1){
							form = '#'+form;
						}
					}
					form = $(form);
					form[0].reset();
					/*form.find('select').trigger("change");*///TODO: 空值待完善
				}catch(e){}
			},initContentDiv:function(){
				var html ='<div class="loading"><img src="'+this.loadingGifBase64+'"></div>' ;
				$('#'+this.contentId).find('*').undelegate().unbind().end().html(html);
			}
			,
			/**
			 * 清除加载动画
			 */
			cleanLoading:function(){
				$(".loading").remove();
			}
			,
			initSelectOptions : function(setting) {
				var selector = setting.selector,
				valueKey = setting.valueKey || 'id', 
				displayKey = setting.displayKey || 'name', 
				codes = setting.codes,
				html = '';
				selector.empty();
				html = '<option value=""></option>';
				$.each(codes, function(index,item){
					var val, attr = '';
					if(item){
						val = item[valueKey];
						/*if(item.id = ){
							attr += ' disabled="disabled"';
						}*/
						html += ' <option value="' + val + '">' + item[displayKey]+'</option>';
					}
				});
				selector.html(html);
			}
			
	};
	window.dzqAjax=window.commonAjax;
})(jQuery); 