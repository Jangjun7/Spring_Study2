<%@ page contentType="text/html charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="GET" modelAttribute="searchForm">
    시작일 : <form:input path="sDate" /> ~
            <form:errors path="sDate" />
    종료일 : <form:input path="eDate" />
            <form:input path="eDate" />
    <button type="submit">조회하기</button>
</form:form>