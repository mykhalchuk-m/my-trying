<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Groups Page</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<div style="margin-left: 150px;">
		<form:form action="${pageContext.request.contextPath}/group/${action}" modelAttribute="group" method="post">
			<fieldset>
				<legend>Group fields</legend>
				<form:hidden path="id"/>
				<div>
					<form:label path="groupName">Group Name:</form:label>
					<form:input path="groupName"/>
				</div>
				<div>
					<form:label path="curator">Curator:</form:label>
					<tags:prepareCuratorSelect teachers="${teachers}" group="${group}" path="curator"/>
				</div>
				<div>
					<input type="submit" value="${action}"/>
					<input type="button" onclick="javascript:location.href='${pageContext.request.contextPath}/group'" value="cancel"/>
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>