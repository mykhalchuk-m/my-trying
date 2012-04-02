<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<a href="/spring-soc-sec">index</a><br/>
	<a href="/spring-soc-sec/soclogin">login with social</a>
	<form action='<c:url value="signin/authenticate"/>' method="post">
		<input name="j_username" /><br/>
		<input name="j_password" type="password"/><br/>
		<input type="submit" value="login"/>
	</form>
</body>
</html>