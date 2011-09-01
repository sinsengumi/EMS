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
for (Sex sex : Sex.values()) {
    sexMap.put(sex.toString(), sex.getLabel());
}
pageContext.setAttribute("sexMap", sexMap, PageContext.PAGE_SCOPE);

Map<String, String> branchMap = new LinkedHashMap<String, String>();
for (Branch branch : Branch.values()) {
    branchMap.put(branch.toString(), branch.getLabel());
}
pageContext.setAttribute("branchMap", branchMap, PageContext.PAGE_SCOPE);
%>

<jsp:include page="/WEB-INF/jsp/include/header.jsp">
    <jsp:param name="title" value="社員情報更新 入力" />
</jsp:include>

<h2>社員情報更新 入力</h2>

<jsp:include page="/WEB-INF/jsp/include/errorMessages.jsp" />

<p class="mB5">※は必須項目です。</p>
<form action="confirm.action" method="post">

<%--
    初期表示時はrequestスコープのデータを表示するが、入力チェックエラー時にはrequestスコープのデータではなく、
    リクエストパラメータ（page）を表示したいため条件分岐させる。
--%>
<c:choose>
<c:when test="${requestScope.updateEmployee != null}">
    <table cellspacing="0">
        <tr>
            <th>社員番号 ※</th>
            <td colspan="4">${fn:escapeXml(requestScope.updateEmployee.employeeId)}<input type="hidden" name="employeeId" value="${fn:escapeXml(requestScope.updateEmployee.employeeId)}" /></td>
        </tr>
        <tr>
            <th>名前（漢字） ※</th>
            <th>姓</th>
            <td><input type="text" name="kanjiLastName" value="${fn:escapeXml(requestScope.updateEmployee.kanjiLastName)}" size="10" maxlength="10" /></td>
            <th>名</th>
            <td><input type="text" name="kanjiFirstName" value="${fn:escapeXml(requestScope.updateEmployee.kanjiFirstName)}" size="10" maxlength="10" /></td>
        </tr>
        <tr>
            <th>性別 ※</th>
            <td colspan="4">${eFn:htmlRadios("sex", pageScope.sexMap, requestScope.updateEmployee.sex, " ")}</td>
        </tr>
        <tr>
            <th>入社年月日 ※</th>
            <td colspan="4"><input type="text" name="enterDate" value="<fmt:formatDate value="${requestScope.updateEmployee.enterDate}" pattern="yyyyMMdd" />" size="8" maxlength="8" /> （yyyyMMdd形式）</td>
        </tr>
        <tr>
            <th>部門 ※</th>
            <td colspan="4">${eFn:htmlOptions("branch", pageScope.branchMap, requestScope.updateEmployee.branch)}</td>
        </tr>
        <tr>
            <th>メールアドレス</th>
            <td colspan="4"><input type="text" name="email" value="${fn:escapeXml(requestScope.updateEmployee.email)}" size="20" maxlength="256" /></td>
        </tr>
    </table>
</c:when>
<c:otherwise>
    <table cellspacing="0">
        <tr>
            <th>社員番号 ※</th>
            <td colspan="4">${fn:escapeXml(param.employeeId)}<input type="hidden" name="employeeId" value="${fn:escapeXml(param.employeeId)}" /></td>
        </tr>
        <tr>
            <th>名前（漢字） ※</th>
            <th>姓</th>
            <td><input type="text" name="kanjiLastName" value="${fn:escapeXml(param.kanjiLastName)}" size="10" maxlength="10" /></td>
            <th>名</th>
            <td><input type="text" name="kanjiFirstName" value="${fn:escapeXml(param.kanjiFirstName)}" size="10" maxlength="10" /></td>
        </tr>
        <tr>
            <th>性別 ※</th>
            <td colspan="4">${eFn:htmlRadios("sex", pageScope.sexMap, param.sex, "　")}</td>
        </tr>
        <tr>
            <th>入社年月日 ※</th>
            <td colspan="4"><input type="text" name="enterDate" value="${fn:escapeXml(param.enterDate)}" size="8" maxlength="8" /> （yyyyMMdd形式）</td>
        </tr>
        <tr>
            <th>部門 ※</th>
            <td colspan="4">${eFn:htmlOptions("branch", pageScope.branchMap, param.branch)}</td>
        </tr>
        <tr>
            <th>メールアドレス</th>
            <td colspan="4"><input type="text" name="email" value="${fn:escapeXml(param.email)}" size="20" maxlength="256" /></td>
        </tr>
    </table>
</c:otherwise>
</c:choose>

<input type="button" value="戻る" onclick="history.back(); return false;" />
<input type="submit" value="確認画面へ" />
</form>

<jsp:include page="/WEB-INF/jsp/include/footer.jsp" />
