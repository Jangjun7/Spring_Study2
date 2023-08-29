<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="action" value="/member/login" />
<spring:message var="memberSaveId" code="member.saveId" />
<form:form method="POST" action="${action}" modelAttribute="loginForm">
    <dl>
        <dt>
            <spring:message code="member.userId" />
        </dt>
        <dd>
            <form:input path="userId" />
            <form:errors path="userId" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="member.userPw" />
        </dt>
        <dd>
            <form:password path="userPw" />
            <form:errors path="userPw" />
        </dd>
    </dl>
    <div>
        <form:checkbox path="saveId" value="true" label="${memberSaveId}" />
    </div>
    <button type="submit">
        <spring:message code="login" />
    </button>
</form:form>