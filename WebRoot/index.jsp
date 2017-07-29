<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jspf" %>
<html>
<head>
</head>
<body>
	<form action="supplier/insert.action" method="post">
		名称：<input type="text"	name="supName"><br> 
		地址：<input type="text" name="supAddress"><br>
		类型：<select id="cc" class="easyui-combobox" name="supType" style="width:200px;">   
			<c:forEach items="${applicationScope.sysParam.supType}" var="supType">
				 <option value="${supType.key}">${supType.value}</option>
			</c:forEach>			   
			</select> 
		<input type="submit" value="ok">
	</form>
</body>
</html>