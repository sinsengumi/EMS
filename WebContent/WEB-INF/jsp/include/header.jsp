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

<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/common/js/common.js"></script>

<title>${fn:escapeXml(param.title)} | EMS</title>
</head>
<body>

<div id="header">
	<h1>EMS <span>[Employee Management System]</span></h1>

    <div class="link">
    <c:if test="${pageContext.request.requestURI != '/EMS/WEB-INF/jsp/menu.jsp'}">
       <p class="menu"><a href="${pageContext.request.contextPath}/menu.action">メニューへ戻る</a></p>
    </c:if>

	<c:if test="${sessionScope.loginEmployee != null}">
	   <p class="welcome">${fn:escapeXml(sessionScope.loginEmployee.kanjiLastName)} ${fn:escapeXml(sessionScope.loginEmployee.kanjiFirstName)} さん　
       <a href="javascript:void(0);" onclick="confirmLogout('${pageContext.request.contextPath}/logout.action');">ログアウト</a></p>
	</c:if>
	</div>
</div>

<div id="contents">
