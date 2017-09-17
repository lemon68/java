<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<html>
<body>
<h2>Hello World!</h2>
<a href="${ctx}/common/main.jsp">主页跳转</a>
<% response.sendRedirect("main");%>
</body>
</html>
