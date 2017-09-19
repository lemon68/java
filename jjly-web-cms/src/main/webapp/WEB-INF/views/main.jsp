<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>建家立业系统后台</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/easyui/1.3.4/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/wu.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/icon.css"/>
</head>
<body class="easyui-layout">
<!-- begin of header -->
<div class="wu-header" data-options="region:'north',border:false,split:true">
    <div class="wu-header-left">
        <h1>建家立业系统后台</h1>
    </div>
    <div class="wu-header-right">
        <p><strong class="easyui-tooltip" title="2条未读消息">admin</strong>，欢迎您！</p>
        <p><a href="#"><strong class="logout">安全退出</strong></a></p>
    </div>
</div>
<!-- end of header -->
<!-- begin of sidebar -->
<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单'">
    <div class="easyui-accordion" data-options="border:false,fit:true">
        <div title="快捷菜单" data-options="iconCls:'icon-application-cascade'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)"
                       data-icon="icon-chart-organisation"
                       data-link="${ctx}/main/layout1"
                       iframe="0">
                        菜单导航
                    </a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)"
                       data-icon="icon-users"
                       data-link="${ctx}/main/layout2"
                       iframe="0">
                        用户管理
                    </a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)"
                       data-icon="icon-user-group"
                       data-link="${ctx}/main/layout2"
                       iframe="0">
                        角色管理
                    </a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)"
                       data-icon="icon-book"
                       data-link="${ctx}/main/layout2"
                       iframe="0">
                        数据字典
                    </a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)"
                       data-icon="icon-cog"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        系统参数
                    </a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)"
                       data-icon="icon-application-osx-error"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        操作日志
                    </a>
                </li>
            </ul>
        </div>
        <div title="内容管理" data-options="iconCls:'icon-application-form-edit'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)"
                       data-icon="icon-chart-organisation"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)"
                       data-icon="icon-users"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)"
                       data-icon="icon-user-group"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)"
                       data-icon="icon-book"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)"
                       data-icon="icon-cog"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)"
                       data-icon="icon-application-osx-error"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
            </ul>
        </div>
        <div title="商品管理" data-options="iconCls:'icon-creditcards'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)"
                       data-icon="icon-chart-organisation"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        商品分类
                    </a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)"
                       data-icon="icon-users"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        商品列表
                    </a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)"
                       data-icon="icon-user-group"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        商品类型
                    </a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)"
                       data-icon="icon-book"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        商品规格
                    </a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)"
                       data-icon="icon-cog"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        商品属性
                    </a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)"
                       data-icon="icon-application-osx-error"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        品牌列表
                    </a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)"
                       data-icon="icon-application-osx-error"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        商品评论
                    </a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)"
                       data-icon="icon-application-osx-error"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        商品咨询
                    </a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)"
                       data-icon="icon-application-osx-error"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        商品专题列表
                    </a>
                </li>
            </ul>
        </div>
        <div title="订单管理" data-options="iconCls:'icon-cart'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)"
                       data-icon="icon-chart-organisation"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)"
                       data-icon="icon-users"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)"
                       data-icon="icon-user-group"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)"
                       data-icon="icon-book"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)"
                       data-icon="icon-cog"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)"
                       data-icon="icon-application-osx-error"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
            </ul>
        </div>
        <div title="广告管理" data-options="iconCls:'icon-bricks'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)"
                       data-icon="icon-chart-organisation"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)"
                       data-icon="icon-users"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)"
                       data-icon="icon-user-group"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)"
                       data-icon="icon-book"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)"
                       data-icon="icon-cog"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)"
                       data-icon="icon-application-osx-error"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
            </ul>
        </div>
        <div title="报表中心" data-options="iconCls:'icon-chart-curve'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)"
                       data-icon="icon-chart-organisation"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)"
                       data-icon="icon-users"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)"
                       data-icon="icon-user-group"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)"
                       data-icon="icon-book"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)"
                       data-icon="icon-cog"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)"
                       data-icon="icon-application-osx-error"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
            </ul>
        </div>
        <div title="系统设置" data-options="iconCls:'icon-wrench'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)"
                       data-icon="icon-chart-organisation"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)"
                       data-icon="icon-users"
                       data-link="${ctx}/layout"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)"
                       data-icon="icon-user-group"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)"
                       data-icon="icon-book"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)"
                       data-icon="icon-cog"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)"
                       data-icon="icon-application-osx-error"
                       data-link="${ctx}/layout3"
                       iframe="0">
                        导航标题
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- end of sidebar -->
<!-- begin of main -->
<div class="wu-main" data-options="region:'center'">
    <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true">
        <div title="首页"
             data-options="href:'${ctx}/layout1',closable:false,iconCls:'icon-tip',cls:'pd3'"></div>
    </div>
</div>
<!-- end of main -->
<!-- begin of footer -->
<div class="wu-footer" data-options="region:'south',border:true,split:true">
    &copy; 2017 建家立业 All Rights Reserved
</div>
<!-- end of footer -->
<script type="text/javascript" src="${ctx}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx}/plugins/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/plugins/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/js/commons/easy-window.js"></script>
<script type="text/javascript">
    $(function () {
        $('.logout').bind("click", doLogout);
        $('.wu-side-tree a').bind("click", function () {
            var title = $(this).text();
            var url = $(this).attr('data-link');
            var iconCls = $(this).attr('data-icon');
            var iframe = $(this).attr('iframe') == 1 ? true : false;
            addTab(title, url, iconCls, iframe);
        });
    })

    /**
     * Name 载入树形菜单
     */
    $('#wu-side-tree').tree({
        url: '${ctx}/temp/menu.php',
        cache: false,
        onClick: function (node) {
            var url = node.attributes['url'];
            if (url == null || url == "") {
                return false;
            }
            else {
                addTab(node.text, url, '', node.attributes['iframe']);
            }
        }
    });

    /**
     * Name 选项卡初始化
     */
    $('#wu-tabs').tabs({
        tools: [{
            iconCls: 'icon-reload',
            border: false,
            handler: function () {
                $('#wu-datagrid').datagrid('reload');
            }
        }]
    });

    /**
     * Name 添加菜单选项
     * Param title 名称
     * Param href 链接
     * Param iconCls 图标样式
     * Param iframe 链接跳转方式（true为iframe，false为href）
     */
    function addTab(title, href, iconCls, iframe) {
        var tabPanel = $('#wu-tabs');
        if (!tabPanel.tabs('exists', title)) {
            var content = '<iframe scrolling="auto" frameborder="0"  src="' + href + '" style="width:100%;height:100%;"></iframe>';
            if (iframe) {
                tabPanel.tabs('add', {
                    title: title,
                    content: content,
                    iconCls: iconCls,
                    fit: true,
                    cls: 'pd3',
                    closable: true
                });
            }
            else {
                tabPanel.tabs('add', {
                    title: title,
                    href: href,
                    iconCls: iconCls,
                    fit: true,
                    cls: 'pd3',
                    closable: true
                });
            }
        }
        else {
            tabPanel.tabs('select', title);
        }
    }
    /**
     * Name 移除菜单选项
     */
    function removeTab() {
        var tabPanel = $('#wu-tabs');
        var tab = tabPanel.tabs('getSelected');
        if (tab) {
            var index = tabPanel.tabs('getTabIndex', tab);
            tabPanel.tabs('close', main);
        }
    }
    /**添加退出登录按钮点击事件添加*/
    function logoutOnclick() {
        $(".logout").click(function () {
            doLogout();
        });
    }
    /**
     弹出提示是否退出登录弹框，并响应用户选择
     */
    function doLogout() {
        $.easymsg.confirm("退出提醒", "确定退出登录？", function (r) {
            if (r) {
                window.location.href = "#"
            }
        });
    }
</script>
</body>
</html>
