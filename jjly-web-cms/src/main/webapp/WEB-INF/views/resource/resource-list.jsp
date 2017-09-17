<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@include file="/common/taglibs.jsp"%>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>建家立业系统后台-权限管理</title>
	<!-- <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" /> -->
</head>
<div class="cus_manager prview_menu clearfix">
	<div class="contitle">
		<h3>
			权限管理> <em>菜单管理</em>
		</h3>
	</div>
	<div class="tables">
		<div class="tbar clearfix">
						<div class="searform">
						<security:authorize ifAnyGranted="ROLE_RESOURCE_ADD">
							<div class="gre_add_btn" onclick="addResources()">+ 添加</div>
						</security:authorize>
						</div>
					</div>
		<div class="kh-table">
			<table>
				<thead>
					<tr>
						<th class="w-20">资源描述</th>
						<th class="w-15">资源名称</th>
						<th class="w-15">是否菜单</th>
						<th class="w-10">资源图标</th>
						<th class="w-20">资源排序</th>
						<th class="w-20">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${datas}" var="item">
						<!-- 1级资源 -->
						<tr>
							<td class="text-left-0 " dataItemId="${item.id }" onclick="loadChildResources(this,${item.id},${item.level})">
							<c:if test="${item.isHaveChild }">
							<em class="arrow-box" ></em>
							<img class="file-ico" src="${ctx }/images/folder_ico.png" />
							</c:if>
							<c:if test="${!item.isHaveChild }">
								<img class="file-ico" src="${ctx }/images/folder_ico.png" />
							</c:if>
							${item.despName }
							</td>
							<td>${item.code }</td>
							<td>${item.isMenu }</td>
							<td><em class="icon ${item.icon.iconUrl}"></em></td>
							<td>${item.sort}</td>
							<td>
							<security:authorize ifAnyGranted="ROLE_RESOURCE_EDIT">
							<a href="javascript:editResources(${item.id })">【编辑】</a> 
							</security:authorize>
							<security:authorize ifAnyGranted="ROLE_RESOURCE_DELETE">
							<a href="javascript:deleteByResourceId(${item.id })">【删除】</a>
							</security:authorize>
							</td>
						</tr>
						<c:if test="${item.isHaveChild }">
							<tr style="display: none;" id="childResourcesDiv${item.id}" class="">
								<td colspan="6">
									<div>
										<table>
										<tr></tr>
										<tr style="display: none;" id="childResourcesDiv${item.id}">
											<td colspan="6">
											<tr><td colspan="6">没有数据了</td></tr>
											</td>
										</tr>
										</table>
									</div>
								</td>
							</tr>
						</c:if>
						<!-- 2级资源 -->
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
</div>
<div id="resourcesWindow" class="easy-window" data-options="windowType:addRoles,collapsible:false,minimizable:false,closed:true,maximizable:false,modal:true">
		
</div>
<script type="text/javascript">
function loadChildResources(currTd,resourceId,level){
	level=level+1;//获取当前等级下一个等级的所有资源
	$.getJSON("${ctx}/resource/resource-list-data?id="+resourceId,{},function(data){
		if(data!=null&&data.lenght!=0){
			var $childResourcesDiv =$("#childResourcesDiv"+resourceId)
			$childResourcesDiv.find("table").empty();
			var html = "";
			for(i in data){
				html+=createTr(data[i],level);
			}
			
			$childResourcesDiv.find("table").append(html);
			iniArrowBox(currTd);
		}
	});
}

function createTr(resourceItem,level){
	
	var haveArrowBox = (resourceItem.isHaveChild?"arrow-box":"");
	var hhh='';
	if(resourceItem.isHaveChild){
		hhh='<em class="arrow-box" ></em>'
		+'<img class="file-ico" src="${ctx }/images/folder_ico.png" />';
	}else{
		hhh = '<img class="file-ico" src="${ctx }/images/file_ico.png" />'
	}
	
	
	var tr ='<tr>'
		+'<td class="w-20 text-left-'+level+'" dataItemId="'+resourceItem.id+'"  onclick="loadChildResources(this,'+resourceItem.id+','+resourceItem.level+')">'
		+hhh
		+resourceItem.despName+'</td>'
		+'<td class="w-15">'+resourceItem.resourceName+'</td>'
		+'<td class="w-15">'+resourceItem.isMenu+'</td>'
		+'<td class="w-10"><em class="icon '+resourceItem.icon.iconUrl+'"></em></td>'
		+'<td class="w-20">2</td>'
		+'<td class="w-20"><security:authorize ifAnyGranted="ROLE_RESOURCE_EDIT"><a href="javascript:editResources('+resourceItem.id+')">【编辑】</a></security:authorize> <security:authorize ifAnyGranted="ROLE_RESOURCE_DELETE"><a href="javascript:deleteByResourceId('+resourceItem.id+'})">【删除】</a></security:authorize>'
		+'</td>'
		+'</tr>';
	var ChildHtml="";
	
	if(resourceItem.isHaveChild){
		 ChildHtml=	'<tr style="display: none;" id="childResourcesDiv'+resourceItem.id+'">'
			+'<td colspan="6">'
			+'<div>'
			+'<table>'
			+'<tr><td colspan="6">没有数据了</td></tr>'
			+'</table>'
			+'</div>'
			+'</td>'
			+'</tr>';
	}
	return tr+ChildHtml;
}

//资源添加修改窗口
function editResources(resourceId){
	openResourcesWindow("修改资源","${ctx}/resource/resource-input?id="+resourceId);
}
//资源添加修改窗口
function addResources(){
	openResourcesWindow("添加资源","${ctx}/resource/resource-input");
}
//角色添加修改窗口
function openResourcesWindow(title, url, type) {
	var wid = $("#resourcesWindow");
	wid.easywindow({"url":url});
}

//删除资源信息
function deleteByResourceId(ids) {
	if (ids == null || ids == '') {
		$.easymsg.alert('温馨提示', '请选择要删除的角色！', 'warning');
	} else {
		$.easymsg.confirm(
						'温馨提示',
						'你确定要删除选中的角色吗？',
						function(r) {
							if (r) {
								$.ajax({type : "POST",
										url : "${ctx}/resource/resource-delete?id="
													+ ids,
											success : function(data) {
												data = $.parseJSON(data);
												if(data.success){
													$.easymsg.alert('温馨提示', '删除成功', 'info');
													loadContent("${ctx}/resource/resource-list");
												}else{
													$.easymsg.alert('温馨提示', data.resultMsg, 'warning');
												}
											}
										});
							}
						});
	}
}

	
/**
 * 初始化树的父节点点击事件
 */
function iniArrowBox(currTd){
	 /**/ if($(currTd).parent().is('.active')){
		$(currTd).parent().removeClass('active').next().hide();
	}else{
		$(currTd).parent().addClass('active').next().show();
	}  
	 
}
$(function(){
	iniArrowBox()
})
	
</script>
</html>