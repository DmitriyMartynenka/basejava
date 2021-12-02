<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.basejava.webapp.model.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px solid #399;
            border-spacing: 5px 3px;
        }
        td {
            border: 1px solid; /* Граница вокруг ячеек */
            padding: 3px; /* Поля в ячейках */
        }
    </style>
</head>
<body>
<section>
    <table>
        <tr>
            <th>Имя</th>
            <th>Email</th>
            <th>Some</th>
            <th>Some</th>
        </tr>
        <c:forEach items="${resumes}" var="resume">
            <jsp:useBean id="resume" scope="application" class="com.basejava.webapp.model.Resume"/>
        <tr>
            <td><a href="resume?uuid=${resume.uuid}">${resume.fullName}</a></td>
            <td>${resume.getContact(ContactType.MAIL)}</td>
            <td></td>
            <td></td>
        </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
