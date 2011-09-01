<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="eFn" uri="/WEB-INF/emsFunctions.tld" %>

<jsp:include page="/WEB-INF/jsp/include/header.jsp">
    <jsp:param name="title" value="社員情報削除 完了" />
</jsp:include>

<h2>社員情報削除 完了</h2>

<c:choose>
    <c:when test="${requestScope.errorMessages != null}">
        <jsp:include page="/WEB-INF/jsp/include/errorMessages.jsp" />
    </c:when>
    <c:otherwise>
        <p>社員情報を削除しました。</p>
    </c:otherwise>
</c:choose>

<jsp:include page="/WEB-INF/jsp/include/footer.jsp" />
