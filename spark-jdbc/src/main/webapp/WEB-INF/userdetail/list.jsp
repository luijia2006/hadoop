<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" session="false" %>
<%@include	file="/WEB-INF/share/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><a href="/user/add.html" target="_blank"><input type="button" value="新增"/></a></p>
	<table>
		<c:forEach items="${list}" var="one">
			<tr>
				<td><vt:user st='text' uid='${one.userId}' name='name' /></td>
				<td><vt:user st='link' uid='${one.userId}' /></td>
				<td><a href="/userdetail/detail.html?id=${one.id}" target="_blank">查看</a></td>
				<td><a href="/userdetail/update.html?id=${one.id}" target="_blank">编辑</a></td>
			</tr>
		</c:forEach>
	</table>
	</ul>
	<we:linkPage link="/userdetail/list.html" form="${userDetailListForm}" page="${page}"/>
</body>
</html>