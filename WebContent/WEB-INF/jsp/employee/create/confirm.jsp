<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="eFn" uri="/WEB-INF/emsFunctions.tld" %>

<jsp:include page="/WEB-INF/jsp/include/header.jsp">
    <jsp:param name="title" value="社員情報登録 確認" />
</jsp:include>

<h2>社員情報登録 確認</h2>

<c:if test="${requestScope.errorMessages != null}">
<div class="error-message">
<ul>
    <c:forEach var="errorMessage" items="${requestScope.errorMessages}" varStatus="status">
    <li>${fn:escapeXml(errorMessage)}</li>
    </c:forEach>
</ul>
</div>
</c:if>

<p class="mB5">※は必須項目です。</p>
<form action="finish.action" method="post">
<table cellspacing="0">
    <tr>
        <th>社員番号 ※</th>
        <td colspan="4">${fn:escapeXml(sessionScope.createEmployee.employeeId)}</td>
    </tr>
    <tr>
        <th>パスワード ※</th>
        <td colspan="4">${eFn:maskPassword(sessionScope.createEmployee.password)}</td>
    </tr>
    <tr>
        <th>名前（漢字） ※</th>
        <th>姓</th>
        <td>${fn:escapeXml(sessionScope.createEmployee.kanjiLastName)}</td>
        <th>名</th>
        <td>${fn:escapeXml(sessionScope.createEmployee.kanjiFirstName)}</td>
    </tr>
    <tr>
        <th>性別 ※</th>
        <td colspan="4">${fn:escapeXml(sessionScope.createEmployee.sex.label)}</td>
    </tr>
    <tr>
        <th>入社年月日 ※</th>
        <td colspan="4"><fmt:formatDate value="${sessionScope.createEmployee.enterDate}" pattern="yyyyMMdd" /></td>
    </tr>
    <tr>
        <th>部門 ※</th>
        <td colspan="4">${fn:escapeXml(sessionScope.createEmployee.branch.label)}</td>
    </tr>
    <tr>
        <th>メールアドレス</th>
        <td colspan="4">${fn:escapeXml(sessionScope.createEmployee.email)}</td>
    </tr>
</table>
<input type="button" value="戻る" onclick="history.back(); return false;" />
<input type="submit" value="登録" />
</form>

<jsp:include page="/WEB-INF/jsp/include/footer.jsp" />
