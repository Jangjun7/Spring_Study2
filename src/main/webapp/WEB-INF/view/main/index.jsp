<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="loginUrl" value="/member/login" />
<c:url var="joinUrl" value="/member/join" />
<c:url var="logoutUrl" value="/member/logout" />
<h1>메인 페이지</h1>
<c:if test="${sessionScope.member == null}">
    <a href="${loginUrl}">
        <spring:message code="login" />
    </a>
    <a href="${joinUrl}">
        <spring:message code="join" />
    </a>
</c:if>
<c:if test="${sessionScope.member != null}">
    <spring:message code="login.msg">
        <spring:argument value="${sessionScope.member.userNm}" />
        <spring:argument value="${sessionScope.member.userId}" />
    </spring:message>
    <a href="${logoutUrl}">
        <spring:message code="logout" />
    </a>
</c:if>