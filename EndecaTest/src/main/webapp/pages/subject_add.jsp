<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subject Page</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<div style="margin-left: 150px;">
		<form:form action="${pageContext.request.contextPath}/subject/${action}" modelAttribute="subject" method="post">
			<fieldset>
				<legend>Subject fields</legend>
				<form:hidden path="id"/>
				<div>
					<form:label path="title">Title:</form:label>
					<form:input path="title"/>
				</div>
				<div>
					<input type="submit" value="${action}"/>
					<input type="button" onclick="javascript:location.href='${pageContext.request.contextPath}/subject'" value="cancel"/>
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>