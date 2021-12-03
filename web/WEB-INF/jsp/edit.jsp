<jsp:useBean id="resume" scope="request" type="com.basejava.webapp.model.Resume"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.basejava.webapp.model.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <title>Resume ${resume.fullName} edit</title>
</head>
<body>
<section>
    <h4>${resume.fullName}&nbsp</h4>
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl class="attrs">
            <dt>Имя:</dt>
            <dd><input type="text" name="fullname" value="${resume.fullName}"></dd>
        </dl>
        <h3>Контакты</h3>
        <p>
            <c:forEach items="<%=ContactType.values()%>" var="type">
        <dl class="attrs">
            <dt>
                ${type.title}
            </dt>
            <dd><input type="text" name="${type.name()}" value="${resume.getContact(type)}" size="30"></dd>
        </dl>
        </c:forEach>
        </p>
        <hr>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
    </form>
</section>
</body>
</html>

