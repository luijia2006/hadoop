<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" session="false" %>
<%@include	file="/WEB-INF/share/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/user/add.html" method="post">
		<h1>用户名：<input type="text" name="name"/></h1>
		<input type="submit" value="提交">
	</form>
</body>
</html>