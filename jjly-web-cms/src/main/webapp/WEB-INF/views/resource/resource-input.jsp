<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<div class="popups" style="display: none;">
		<div class="mask">
			<!-- 添加资源 -->
			<div class="add-menu" style="display: block;">
		<form id="resourceform" method="post"
		action="${ctx}/resource/resource-add">
		<input type="hidden" name="id" value="${resource.id}" />
				<h2>
					添加资源<em class="del-popups"></em>
				</h2>
				<div class="msgs">
					<div class="clearfix">
						<span class="destrct">资源描述：</span>
						<div class="selects">
							<input id="despName" value="${resource.despName}" name="despName"
								class="nl240_input" type="text" />
						</div>
						<span class="desctr"><em>*</em>请输入资源描述</span>
					</div>
					<div class="clearfix">
						<span class="destrct">资源名称：</span>
						<div class="selects">
							<input
								id="resourceName" value="${resource.resourceName}"
								name="resourceName" class="nl240_input" type="text" />
						</div>
						<span class="desctr"><em>*</em>必须输入资源名称</span>
					</div>
					<div class="clearfix">
						<span class="destrct">资源图标：</span>
						<div class="selects">
							<div class="show" id="show-ind"></div>
							<em></em> <select class="sorts sorts-select-list" id="icon.id" name="icon.id"
								style="width: 160px;">
								<c:forEach items="${icons}" var="icon">
									<option value="${icon.id}"
										<c:if test="${icon.id==resource.icon.id }">selected="selected"</c:if>>${icon.name}
									</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="clearfix">
						<span class="destrct">是否菜单：</span>
						<div class="selects">
							<div class="show"></div>
							<em></em> 
							<select id="isMenu" name="isMenu"  class="sorts sorts-select-list">
									<option value="true"
										<c:if test="${resource.isMenu }">selected="selected"</c:if>>是</option>
									<option value="false"
										<c:if test="${!resource.isMenu }">selected="selected"</c:if>>否</option>
							</select>
						</div>
					</div>
					<div class="clearfix">
						<span class="destrct">资源类型：</span>
						<div class="selects">
							<div class="show" id="show-resourceLevel"></div>
							<em></em> <select class="sorts sorts-select-list" id="resourceLevel"
								name="level" onchange="viewresource()"
								style="width: 160px;">
								<option value="0"
									<c:if test="${0==resource.level }">selected="selected"</c:if>>一级菜单</option>
								<option value="1"
									<c:if test="${1==resource.level }">selected="selected"</c:if>>二级菜单</option>
								<option value="2"
									<c:if test="${2==resource.level }">selected="selected"</c:if>>三级菜单</option>
								<option value="3"
									<c:if test="${3==resource.level }">selected="selected"</c:if>>四级菜单</option>
							</select>
							<!-- <select class="sorts" name="">
								<option value="一级菜单">一级菜单</option>
								<option value="二级菜单">二级菜单</option>
							</select> -->
						</div>
					</div>
					<div class="clearfix" id="viewresource">
						<span class="destrct">资源地址：</span>
						<div class="selects">
							<input id="menuUrl" value="${resource.menuUrl}" name="menuUrl"
								type="text" class="nl240_input" />
						</div>
					</div>
					<div class="clearfix" id="viewresource2">
						<span class="destrct">所属上级：</span>
						<div class="selects">
							<div class="show" id="parentResourcesDiv"></div>
							<em></em> <select class="sorts sorts-select-list" name="parentId" id="parentResourcesSelect">
								<c:forEach items="${resources}" var="resourcem">
									<option value="${resourcem.id }"
										<c:if test="${resourcem.id==resource.parentResource.id }">selected="selected"</c:if>>${resourcem.despName}</option>
								</c:forEach>
							</select>
							<!-- <select class="sorts" name="" id="bel-ind">
								<option value="一级菜单">一级菜单</option>
								<option value="二级菜单">二级菜单</option>
							</select> -->
						</div>
					</div>
					<div class="clearfix">
						<span class="destrct">资源排序：</span>
						<div class="selects">
							 <input id="sortNum" name="sortNum"
								value="${resource.sortNum}" type="text" class="nl240_input" />
						</div>
					</div>
				</div>
				<div class="btns">
					<span class="boxBtn" onclick="submitresourceForm()">确认</span> <span
						class="boxBtn1  del-popups" >取消</span>
				</div>
				</form>
			</div>
		</div>
</div>
<script type="text/javascript">
		
	$(function() {
		//处理下拉框
		initSortsSelectList();
		//判断是否显示二级资源输入框
		viewresource();
	});

	function viewresource() {
		var value = $('#resourceLevel').val();
		if (value == 0) {
			$('#viewresource').show();
			$('#viewresource2').hide();
		}else{
			$('#viewresource').show();
			$('#viewresource2').show();
		}
		doAjaxResourcesByLv(value);
	}
	
	/**发送http请求，请求指定等级的上级资源的集合
	*/
	function doAjaxResourcesByLv(resourceLevel){
		resourceLevel= parseInt(resourceLevel);
		if(resourceLevel==0){
			return ;
		}
		$.getJSON("${ctx}/resource/resource-list-data-by-lv?lv="+(resourceLevel-1),{},function(datas){
			if(datas!=null){
				initResourcesSelect(datas);
			}
		});
	}
	
	/**
	将资源列表设置到相应的select选项中
	*/
	function initResourcesSelect(datas){
		var parentResourcesSelect = $("#parentResourcesSelect");
		parentResourcesSelect.empty();
		for(i in datas){
			parentResourcesSelect.append(getOptionByResourceJson(datas[i]));
		}
		initSelect('parentResourcesSelect', 'parentResourcesDiv');
	}
	/**
		将json的资源对象转成多选框的选项的html
	*/
	function getOptionByResourceJson(dataItem){
		var html = '<option value="'+dataItem.id+'">'+dataItem.despName+'</option>'
		return html;
	}
	
	//提交表单
	function submitresourceForm() {
		$("#resourceform").commonAjaxSubmit({
			"success" : function(data) {
				if(data.success){
					$.easymsg.alert('温馨提示', data.resultMsg, 'warning');
					var wid = $("#resourcesWindow");
					wid.easywindow("close");
					loadContent("${ctx}/resource/resource-list");
				}else{
					$.easymsg.alert('温馨提示', data.resultMsg, 'warning');
				}
			},
			"error" : function(data) {
				$.easymsg.alert('温馨提示', data.resultMsg, 'warning');
			}
		});
		
	}
</script>

