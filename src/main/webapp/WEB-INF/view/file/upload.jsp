<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="action" value="/file/upload" />
<form method="post" action="${action}" enctype="multipart/form-data">
    제목 : <input type="text" name="subject"><br>
    <input type="file" name="files" multiple><br>
    <button type="submit">업로드</button>
</form>