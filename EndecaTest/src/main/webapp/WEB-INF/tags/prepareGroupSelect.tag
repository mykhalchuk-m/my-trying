<%@ tag %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ attribute name="path" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ attribute name="groups" type="java.util.List" rtexprvalue="true" required="true" %>
<%@ attribute name="student" type="com.mmm.dsjsm.entity.Student" rtexprvalue="true" required="true" %>

<form:select path="${path}">
	<c:forEach items="${groups}" var="group">
		<c:choose>
			<c:when test="${group.id == student.group.id}">
				<option value="${group.id}" selected="selected">${group.groupName}</option>
			</c:when>
			<c:otherwise>
				<option value="${group.id}">${group.groupName}</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</form:select>