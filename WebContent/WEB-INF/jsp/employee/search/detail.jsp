<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="eFn" uri="/WEB-INF/emsFunctions.tld" %>

<jsp:include page="/WEB-INF/jsp/include/header.jsp">
    <jsp:param name="title" value="社員情報検索 詳細" />
</jsp:include>

<h2>社員情報検索 詳細</h2>

<c:choose>
    <c:when test="${requestScope.errorMessages != null}">
        <jsp:include page="/WEB-INF/jsp/include/errorMessages.jsp" />
    </c:when>
    <c:otherwise>
        <table cellspacing="0">
            <tr>
                <th>社員番号</th>
                <td colspan="4">${fn:escapeXml(requestScope.searchEmployee.employeeId)}</td>
            </tr>
            <tr>
                <th>名前（漢字）</th>
                <th>姓</th>
                <td>${fn:escapeXml(requestScope.searchEmployee.kanjiLastName)}</td>
                <th>名</th>
                <td>${fn:escapeXml(requestScope.searchEmployee.kanjiFirstName)}</td>
            </tr>
            <tr>
                <th>性別</th>
                <td colspan="4">${fn:escapeXml(requestScope.searchEmployee.sex.label)}</td>
            </tr>
            <tr>
                <th>入社年月日</th>
                <td colspan="4"><fmt:formatDate value="${requestScope.searchEmployee.enterDate}" pattern="yyyyMMdd" /></td>
            </tr>
            <tr>
                <th>部門</th>
                <td colspan="4">${fn:escapeXml(requestScope.searchEmployee.branch.label)}</td>
            </tr>
            <tr>
                <th>メールアドレス</th>
                <td colspan="4">${fn:escapeXml(requestScope.searchEmployee.email)}</td>
            </tr>
        </table>
    </c:otherwise>
</c:choose>

<input type="button" value="戻る" onclick="history.back(); return false;" />

<jsp:include page="/WEB-INF/jsp/include/footer.jsp" />
