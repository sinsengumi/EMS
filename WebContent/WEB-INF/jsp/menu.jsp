<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jsp/include/header.jsp">
    <jsp:param name="title" value="メニュー" />
</jsp:include>

<h2>メニュー</h2>

<h3>社員情報管理</h3>
<ul>
    <li><a href="employee/create/input.action">社員情報登録</a></li>
    <li><a href="employee/search/list.action">社員情報検索</a></li>
</ul>

<jsp:include page="/WEB-INF/jsp/include/footer.jsp" />
