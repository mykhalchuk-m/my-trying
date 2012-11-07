<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goups Page</title>
<style type="text/css">
	table tr td {
		border-top: 1px solid #000;
	}
	table tr th, table tr td {
		border-right: 1px solid #000;
	}
	table tr th.last, table tr td.last {
		border-right: 0 none;
	}
</style>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<div style="margin-left: 150px;">
		<div>
			<a href="${pageContext.request.contextPath}/group/add">Add Group</a>
		</div>
		<table style="border: 1px solid #000" cellpadding="0" cellspacing="0">
			<tr>
				<th width="200">group name</th>
				<th width="200">curator</th>
				<th width="200">students</th>
				<th width="100" class="last"></th>
			</tr>
			<c:forEach items="${groups}" var="group">
				<tr>
					<td>${group.groupName}</td>
					<td>${group.curator.secondName}</td>
					<td>
						<select>
							<c:forEach items="${group.students}" var="student">
								<option>${student.firstName}</option>							
							</c:forEach>
						</select>
					</td>
					<td class="last">
						<a href="${pageContext.request.contextPath}/group/delete?id=${group.id}">delete</a>/
						<a href="${pageContext.request.contextPath}/group/edit?id=${group.id}">edit</a>
					</td>
				</tr>
			</c:forEach>			
		</table>
	</div>
</body>
</html>