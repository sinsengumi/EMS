<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${requestScope.errorMessages != null}">
<div class="error-message">
<ul>
    <c:forEach var="errorMessage" items="${requestScope.errorMessages}" varStatus="status">
    <li>${fn:escapeXml(errorMessage)}</li>
    </c:forEach>
</ul>
</div>
</c:if>
