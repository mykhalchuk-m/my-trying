<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Page</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<div style="margin-left: 150px;">
		<form:form action="${pageContext.request.contextPath}/teacher/${action}" modelAttribute="teacher" method="post">
			<fieldset>
				<legend>Students field</legend>
				<form:hidden path="id"/>
				<div>
					<form:label path="firstName">First Name:</form:label>
					<form:input path="firstName"/>
				</div>
				<div>
					<form:label path="secondName">Second Name:</form:label>
					<form:input path="secondName"/>
				</div>
				<div>
					<form:label path="subjects">Subject:</form:label>
					<tags:prepareSubjectsSelect subjects="${subjects}" path="subjects" teacher="${teacher}"/>
				</div>
				<div>
					<input type="submit" value="${action}"/>
					<input type="button" onclick="javascript:location.href='${pageContext.request.contextPath}/teacher'" value="cancel"/>
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>