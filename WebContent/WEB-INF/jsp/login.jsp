<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="eFn" uri="/WEB-INF/emsFunctions.tld" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ja" xml:lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="content-style-type" content="text/css" />
<meta http-equiv="content-script-type" content="text/javascript" />

<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/import.css" type="text/css" media="all" />

<title>ログイン | EMS</title>
</head>
<body>

<div id="header">
    <h1>EMS <span>[Employee Management System]</span></h1>
</div>

<div id="contents">

<h2>ログイン</h2>

<div id="login">

<c:if test="${requestScope.errorMessages != null}">
<div class="error-message">
<ul>
    <c:forEach var="errorMessage" items="${requestScope.errorMessages}" varStatus="status">
    <li>${fn:escapeXml(errorMessage)}</li>
    </c:forEach>
</ul>
</div>
</c:if>

<form action="login.action" method="post">
<table cellspacing="0" class="login-table mB5">
<tr>
    <th>社員番号</th>
    <td><input type="text" name="employeeId" value="${fn:escapeXml(param.employeeId)}" size="10" maxlength="5" /></td>
</tr>
<tr>
    <th>パスワード</th>
    <td><input type="password" name="password" value="${fn:escapeXml(param.password)}" size="10" maxlength="20" /></td>
</tr>
</table>
<p class="taC"><input type="submit" value="ログイン" /></p>
</form>

</div>

<jsp:include page="/WEB-INF/jsp/include/footer.jsp" />
