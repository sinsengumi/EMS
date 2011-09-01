<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="org.sample.ems.entity.Sex" %>
<%@ page import="org.sample.ems.entity.Branch" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="eFn" uri="/WEB-INF/emsFunctions.tld" %>

<%
Map<String, String> sexMap = new LinkedHashMap<String, String>();
sexMap.put("", "");
for (Sex sex : Sex.values()) {
    sexMap.put(sex.toString(), sex.getLabel());
}
pageContext.setAttribute("sexMap", sexMap, PageContext.PAGE_SCOPE);

Map<String, String> branchMap = new LinkedHashMap<String, String>();
branchMap.put("", "");
for (Branch branch : Branch.values()) {
    branchMap.put(branch.toString(), branch.getLabel());
}
pageContext.setAttribute("branchMap", branchMap, PageContext.PAGE_SCOPE);
%>

<jsp:include page="/WEB-INF/jsp/include/header.jsp">
    <jsp:param name="title" value="社員情報検索 一覧（検索）" />
</jsp:include>

<h2>社員情報検索 一覧（検索）</h2>

<form action="${pageContext.request.contextPath}/employee/search/list.action" method="get">
<fieldset>
<legend>検索条件</legend>
<table cellspacing="0" class="layout mB10">
    <tr>
        <th>社員番号</th>
        <td><input type="text" name="employeeId" value="${fn:escapeXml(param.employeeId)}" size="5" maxlength="5" /></td>
        <td class="no-border">&nbsp;&nbsp;&nbsp;</td>
        <th>性別</th>
        <td>${eFn:htmlOptions("sex", pageScope.sexMap, param.sex)}</td>
        <td class="no-border">&nbsp;&nbsp;&nbsp;</td>
        <th>部門</th>
        <td>${eFn:htmlOptions("branch", pageScope.branchMap, param.branch)}</td>
    </tr>
</table>
<table cellspacing="0" class="layout">
    <tr>
        <th>入社年月日（From）</th>
        <td><input type="text" name="fromEnterDate" value="${fn:escapeXml(param.fromEnterDate)}" size="8" maxlength="8" /></td>
        <td class="no-border">&nbsp;&nbsp;～&nbsp;&nbsp;</td>
        <th>入社年月日（To）</th>
        <td><input type="text" name="toEnterDate" value="${fn:escapeXml(param.toEnterDate)}" size="8" maxlength="8" /></td>
        <td class="no-border">&nbsp;&nbsp;&nbsp;</td>
        <td class="no-border"><input type="submit" value="検索" /></td>
    </tr>
</table>
</fieldset>
</form>

<p class="mB5 fwB">全 ${fn:length(requestScope.employees)} 件</p>

<c:choose>
<c:when test="${fn:length(requestScope.employees) == 0}">
    <p>検索結果がありません。</p>
</c:when>
<c:otherwise>
    <table cellspacing="0">
        <tr>
            <th>社員番号
            <a href="${pageContext.request.contextPath}/employee/search/list.action?employeeId=${fn:escapeXml(param.employeeId)}&amp;sex=${fn:escapeXml(param.sex)}&amp;branch=${fn:escapeXml(param.branch)}&amp;fromEnterDate=${fn:escapeXml(param.fromEnterDate)}&amp;toEnterDate=${fn:escapeXml(param.toEnterDate)}&amp;sortType=employeeId&amp;isDesc=false">▲</a>
            <a href="${pageContext.request.contextPath}/employee/search/list.action?employeeId=${fn:escapeXml(param.employeeId)}&amp;sex=${fn:escapeXml(param.sex)}&amp;branch=${fn:escapeXml(param.branch)}&amp;fromEnterDate=${fn:escapeXml(param.fromEnterDate)}&amp;toEnterDate=${fn:escapeXml(param.toEnterDate)}&amp;sortType=employeeId&amp;isDesc=true">▼</a>
            </th>
            <th>名前（漢字）</th>
            <th>性別</th>
            <th>入社年月日
            <a href="${pageContext.request.contextPath}/employee/search/list.action?employeeId=${fn:escapeXml(param.employeeId)}&amp;sex=${fn:escapeXml(param.sex)}&amp;branch=${fn:escapeXml(param.branch)}&amp;fromEnterDate=${fn:escapeXml(param.fromEnterDate)}&amp;toEnterDate=${fn:escapeXml(param.toEnterDate)}&amp;sortType=enterDate&amp;isDesc=false">▲</a>
            <a href="${pageContext.request.contextPath}/employee/search/list.action?employeeId=${fn:escapeXml(param.employeeId)}&amp;sex=${fn:escapeXml(param.sex)}&amp;branch=${fn:escapeXml(param.branch)}&amp;fromEnterDate=${fn:escapeXml(param.fromEnterDate)}&amp;toEnterDate=${fn:escapeXml(param.toEnterDate)}&amp;sortType=enterDate&amp;isDesc=true">▼</a>
            </th>
            <th>部門</th>
            <th>メールアドレス</th>
            <th colspan="3">操作</th>
        </tr>
        <c:forEach var="employee" items="${requestScope.employees}" varStatus="status">
        <tr>
            <td class="taC">${fn:escapeXml(employee.employeeId)}</td>
            <td>${fn:escapeXml(employee.kanjiLastName)} ${fn:escapeXml(employee.kanjiFirstName)}</td>
            <td class="taC">${fn:escapeXml(employee.sex.label)}</td>
            <td class="taC"><fmt:formatDate value="${employee.enterDate}" pattern="yyyy年MM月dd日" /></td>
            <td class="taC">${fn:escapeXml(employee.branch.label)}</td>
            <td class="taL"><a href="mailto:${fn:escapeXml(employee.email)}">${fn:escapeXml(employee.email)}</a></td>
            <td class="taC"><a href="${pageContext.request.contextPath}/employee/search/detail.action?employeeId=${fn:escapeXml(employee.employeeId)}">詳細</a></td>
            <td class="taC"><a href="${pageContext.request.contextPath}/employee/update/input.action?employeeId=${fn:escapeXml(employee.employeeId)}">更新</a></td>
            <td class="taC"><a href="javascript:void(0);" onclick="confirmDelete('${pageContext.request.contextPath}/employee/delete/finish.action?employeeId=${fn:escapeXml(employee.employeeId)}');">削除</a></td>
        </tr>
        </c:forEach>
    </table>
</c:otherwise>
</c:choose>


<jsp:include page="/WEB-INF/jsp/include/footer.jsp" />
