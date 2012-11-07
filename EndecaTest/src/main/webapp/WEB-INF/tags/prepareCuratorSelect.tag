<%@ tag %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ attribute name="path" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ attribute name="teachers" type="java.util.List" rtexprvalue="true" required="true" %>
<%@ attribute name="group" type="com.mmm.dsjsm.entity.Group" rtexprvalue="true" required="true" %>

<form:select path="${path}">
	<c:forEach items="${teachers}" var="teacher">
		<c:choose>
			<c:when test="${teacher.id == group.curator.id}">
				<option value="${teacher.id}" selected="selected">${teacher.secondName}</option>
			</c:when>
			<c:otherwise>
				<option value="${teacher.id}">${teacher.secondName}</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</form:select>