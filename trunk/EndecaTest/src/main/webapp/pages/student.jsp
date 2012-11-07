<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Page</title>
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
			<a href="${pageContext.request.contextPath}/student/add">Add Student</a>
		</div>
		<table style="border: 1px solid #000" cellpadding="0" cellspacing="0">
			<tr>
				<th width="200">first name</th>
				<th width="200">last name</th>
				<th width="150">email</th>
				<th width="150">group</th>
				<th width="150">subjects</th>
				<th width="100" class="last"></th>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.email}</td>
					<td>${student.group.groupName}</td>
					<td>
						<select>
							<c:forEach items="${student.subjects}" var="subject">
								<option>${subject.title}</option>
							</c:forEach>
						</select>
					</td>
					<td class="last">
						<a href="${pageContext.request.contextPath}/student/delete?id=${student.id}">delete</a>/
						<a href="${pageContext.request.contextPath}/student/edit?id=${student.id}">edit</a>
					</td>
				</tr>
			</c:forEach>			
		</table>
	</div>
</body>
</html>