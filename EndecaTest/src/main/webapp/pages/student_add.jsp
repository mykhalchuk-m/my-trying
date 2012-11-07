<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Page</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<div style="margin-left: 150px;">
		<form:form action="${pageContext.request.contextPath}/student/${action}" modelAttribute="student" method="post">
			<fieldset>
				<legend>Students field</legend>
				<form:hidden path="id"/>
				<div>
					<form:label path="firstName">First Name:</form:label>
					<form:input path="firstName"/>
				</div>
				<div>
					<form:label path="lastName">Last Name:</form:label>
					<form:input path="lastName"/>
				</div>
				<div>
					<form:label path="email">Email:</form:label>
					<form:input path="email"/>
				</div>
				<div>
					<form:label path="group">Group:</form:label>
					<tags:prepareGroupSelect groups="${groups}" student="${student}" path="group"/>
				</div>
				<div>
					<form:label path="subjects">Subject:</form:label>
					<tags:prepareSubjectsSelect subjects="${subjects}" student="${student}" path="subjects"/>
				</div>
				<div>
					<input type="submit" value="${action}"/>
					<input type="button" onclick="javascript:location.href='${pageContext.request.contextPath}/student'" value="cancel"/>
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>