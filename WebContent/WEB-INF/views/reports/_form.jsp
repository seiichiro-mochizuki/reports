<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null }">
    <div id="flush_error">
        入力内容にエラーがあります<br />
        <c:forEach var="error" items="${errors }">
            ・<c:out value="${error }" /><br />
        </c:forEach>
    </div>
</c:if>

<label for="report_date">日付</label><br />
<input type="date" name="report_date" value="<fmt:formatDate value='${report.report_date }' pattern='yyyy-MM-dd' />">
<br /><br />

<label for="name">氏名</label><br />
<c:out value="${sessionScope.login_employee.name}" />
<br /><br />

<label for="title">タイトル</label><br />
<input type="text" name="title" value="${report.title}" />
<br /><br />

<label for="content">内容</label><br />
<textarea name="content" rows="10" cols="50">${report.content}</textarea>
<br /><br />

<label for="commuting_hour">出勤時刻</label>
<input type="text" style="width:50px;" name="commuting_hour" value="${report.commuting_hour }" /> :

<label for="commuting_minute"></label>
<input type="text" style="width:50px;" name="commuting_minute" value="${report.commuting_minute }" />
<br /><br />

<label for="leaving_hour">退勤時刻</label>
<input type="text" style="width:50px;" name="leaving_hour" value="${report.leaving_hour }" /> :

<label for="leaving_minute"></label>
<input type="text" style="width:50px;" name="leaving_minute" value="${report.leaving_minute }" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>