<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<div>
		<ul>
			<li><a href="${pageContext.request.contextPath}/student">Students</a></li>
			<li><a href="${pageContext.request.contextPath}/group">Groups</a></li>
			<li><a href="${pageContext.request.contextPath}/teacher">Teachers</a></li>
			<li><a href="${pageContext.request.contextPath}/subject">Subjects</a></li>
		</ul>
	</div>
</body>
</html>