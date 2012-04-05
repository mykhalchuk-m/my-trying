<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style type="text/css">
form {
	display: inline;
}
</style>
</head>
<body>
	<a href="/spring-soc-sec">index</a>
	<br />
	<div>Please login through one of your social set accounts:</div>
	<form action="<c:url value="/signin/facebook" />" method="POST">
		<input type="image" src='<c:url value="/resources/img/fb.jpg"/>'
			width="30px" /> <input type="hidden" name="scope"
			value="email,publish_stream,offline_access" />
	</form>
	<form action="<c:url value="/signin/twitter" />" method="POST">
		<input type="image" src='<c:url value="/resources/img/tw.jpg"/>'
			width="30px" />
	</form>
	<form action="<c:url value="/signin/vkontakte" />" method="POST">
		<input type="image" src='<c:url value="/resources/img/vk.jpg"/>'
			width="30px" />
	</form>
</body>
</html>