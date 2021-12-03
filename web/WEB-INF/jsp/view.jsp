<jsp:useBean id="resume" scope="request" type="com.basejava.webapp.model.Resume"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Resume ${resume.fullName}</title>
</head>
<body>
<section>
    <h3>${resume.fullName}&nbsp;<a href="resume?uuid=${resume.uuid}&action=edit">Edit</a></h3>
    <c:forEach items="${resume.contacts}" var="contactEntry">
        <jsp:useBean id="contactEntry" type="java.util.Map.Entry<com.basejava.webapp.model.ContactType, java.lang.String>"/>
        <%=contactEntry.getKey().toHtml(contactEntry.getValue())%><br>
    </c:forEach>
</section>
</body>
</html>

