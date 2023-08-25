<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="action" value="/member/join" />
<form:form method="POST" action="${action}" modelAttribute="joinForm">
    ${joinForm}
    <dl>
        <dt>가입유형</dt>
        <dd>
            <%--
            <form:radiobuttons path="type" items="${types}" itemLabel="label" itemValue="_value" />
            --%>
            <%--
            <form:select path="type" items="${types}" itemLabel="label" itemValue="_value" />
            --%>
            <form:select path="type">
                <option value="">- 선택하세요 -</option>
                <form:options items="${types}" itemLabel="label" itemValue="_value" />
            </form:select>
        </dd>
    </dl>
    <dl>
        <dt>아이디</dt>
        <dd>
            <form:input path="userId" />
        </dd>
    </dl>
    <dl>
        <dt>비밀번호</dt>
        <dd>
            <form:password path="userPw" />
        </dd>
    </dl>
    <dl>
        <dt>비밀번호 확인</dt>
        <dd>
            <form:password path="userPwRe" />
        </dd>
    </dl>
    <dl>
        <dt>회원명</dt>
        <dd>
            <form:input path="userNm" />
        </dd>
    </dl>
    <dl>
        <dt>이메일</dt>
        <dd>
            <form:input path="email" />
        </dd>
    </dl>
    <dl>
        <dt>휴대전화 번호</dt>
        <dd>
            <form:input path="mobile" />
        </dd>
    </dl>
    <dl>
        <dt>취미</dt>
        <dd>
            <form:checkboxes path="hobby" items="${hobbies}" itemLabel="label" itemValue="_value" />
        </dd>
    </dl>
    <dl>
        <dt>자기소개</dt>
        <dd>
            <form:textarea path="intro" rows="10" cols="40" />
        </dd>
    </dl>
    <div>
        <form:checkbox path="agree" value="true" label="회원가입약관에 동의 합니다." />
    </div>
    <button type="submit">가입하기</button>
</form:form>