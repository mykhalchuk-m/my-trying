<%@ tag %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ attribute name="path" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ attribute name="subjects" type="java.util.List" rtexprvalue="true" required="true" %>
<%@ attribute name="student" type="com.mmm.dsjsm.entity.Student" rtexprvalue="true" required="false" %>
<%@ attribute name="teacher" type="com.mmm.dsjsm.entity.Teacher" rtexprvalue="true" required="false" %>

<c:set var="owner" value="${student}"/>

<c:if test="${owner == null}">
	<c:set var="owner" value="${teacher}"/>	
</c:if>

<c:set var="flag" value="false"/>
<form:select path="${path}">
	<c:forEach items="${subjects}" var="subject">
		<c:forEach items="${owner.subjects}" var="mysubject">
			<c:if test="${mysubject.id == subject.id}">
				<c:set var="flag" value="true"/>
			</c:if>
		</c:forEach>
		<c:choose>
			<c:when test="${flag}">
				<option value="${subject.id}" selected="selected">${subject.title}</option>
				<c:set var="flag" value="false"/>
			</c:when>
			<c:otherwise>
				<option value="${subject.id}">${subject.title}</option>
				<c:set var="flag" value="false"/>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</form:select>