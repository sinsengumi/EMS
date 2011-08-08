<%@ page import="org.sample.ems.exception.EMSException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="eFn" uri="/WEB-INF/emsFunctions.tld" %>

<jsp:include page="/WEB-INF/jsp/include/header.jsp">
    <jsp:param name="title" value="システムエラー" />
</jsp:include>

<%
EMSException emsException = (EMSException) exception;
%>

<h2>システムエラー</h2>

<p><%= emsException.getMessage() %></p>

<jsp:include page="/WEB-INF/jsp/include/footer.jsp" />
