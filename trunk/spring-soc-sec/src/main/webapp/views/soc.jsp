<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	<div>
		<a href="/spring-soc-sec">index</a>
	</div>
	<div>
		<p>
			<img src="${photo}" />
		</p>
		<p>
			<span>${name}</span>
		</p>
		<p>
			<form action="/spring-soc-sec/updateStatus" method="post">
				<textarea rows="15" cols="50" name="message"></textarea>
				<input type="submit" value="update"/>
			</form>
		</p>
	</div>
</body>
</html>