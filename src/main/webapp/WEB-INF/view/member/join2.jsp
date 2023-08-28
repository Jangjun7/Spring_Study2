<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="action" value="/member/join" />
<spring:message var="agree" code="member.agree" />
<%--
<spring:message code="login.msg" arguments="사용자01,user01" />
--%>

<form:form method="POST" action="${action}" modelAttribute="joinForm">
    <dl>
        <dt>
            <spring:message code="member.type" />
        </dt>
        <dd>
            <form:select path="type">
                <option value="">- 선택하세요 -</option>
                <form:options items="${types}" itemLabel="label" itemValue="_value" />
            </form:select>
        </dd>
    </dl>

    <dl>
        <dt>
            <spring:message code="member.userId" />
        </dt>
        <dd>
            <form:input path="userId" cssErrorClass="error" />
            <form:errors path="userId" element="div" delimiter="<p>*****</p>" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="member.userPw" />
        </dt>
        <dd>
            <form:password path="userPw" />
            <form:errors path="userPw" element="div" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="member.userPwRe" />
        </dt>
        <dd>
            <form:password path="userPwRe" />
            <form:errors path="userPwRe" element="div" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="member.userNm" />
        </dt>
        <dd>
            <form:input path="userNm" />
            <form:errors path="userNm" element="div" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="member.email" />
        </dt>
        <dd>
            <form:input path="email" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="member.mobile" />
        </dt>
        <dd>
            <form:input path="mobile" />
        </dd>
    </dl>
    <div>
        <form:checkbox path="agree" value="true" label="${agree}" />
    </div>
    <button type="submit">
        <spring:message code="join" />
    </button>
</form:form>