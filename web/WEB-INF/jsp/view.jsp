<%@ page import="com.basejava.webapp.model.TextSection" %>
<%@ page import="com.basejava.webapp.model.ListSection" %>
<%@ page import="com.basejava.webapp.model.OrganizationSection" %>
<%@ page import="com.basejava.webapp.util.HtmlUtil" %>
<jsp:useBean id="resume" scope="request" class="com.basejava.webapp.model.Resume"/>
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
        <jsp:useBean id="contactEntry"
                     type="java.util.Map.Entry<com.basejava.webapp.model.ContactType, java.lang.String>"/>
        <%=contactEntry.getKey().toHtml(contactEntry.getValue())%><br>
    </c:forEach>
    <hr>
    <table>
        <c:forEach items="${resume.sections}" var="sectionEntry">
            <jsp:useBean id="sectionEntry"
                         type="java.util.Map.Entry<com.basejava.webapp.model.SectionType, com.basejava.webapp.model.Section>"/>
            <c:set var="type" value="${sectionEntry.key}"/>
            <c:set var="section" value="${sectionEntry.value}"/>
            <jsp:useBean id="section" type="com.basejava.webapp.model.Section"/>
            <tr>
            <td><h3>${type.title}</h3></td>
            <c:if test="${type=='OBJECTIVE'|| type=='PERSONAL'}">
                <tr>
                    <td><%=((TextSection) section).getCommonInfo()%>
                    </td>
                </tr>
            </c:if>
            </tr>
            <c:if test="${type!='OBJECTIVE' && type!='PERSONAL'}">
                <c:choose>
                    <c:when test="${type=='ACHIEVEMENT' || type=='QUALIFICATIONS'}">
                        <tr>
                            <td>
                                <ul>
                                    <c:forEach items="<%=((ListSection) section).getArticles()%>" var="listItems">
                                        <li>${listItems}</li>
                                    </c:forEach>
                                </ul>
                            </td>
                        </tr>
                    </c:when>
                    <c:when test="${type=='EXPERIENCE' || type=='EDUCATION'}">
                        <c:forEach items="<%=((OrganizationSection) section).getOrganizations()%>" var="orgs">
                            <tr>
                                <td>
                                    <c:choose>
                                        <c:when test="${empty orgs.homePage.URL}">
                                            <h3>${orgs.homePage.name}</h3>
                                        </c:when>
                                        <c:otherwise>
                                            <h4><a href="${orgs.homePage.URL}">${orgs.homePage.name}</a></h4>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                            <c:forEach items="${orgs.positions}" var="position">
                                <jsp:useBean id="position" type="com.basejava.webapp.model.Organization.Position"/>
                                <tr>
                                    <td><%=HtmlUtil.formatDates(position)%>
                                    </td>
                                    <td><b>${position.title}</b><br>${position.description}</td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                    </c:when>
                </c:choose>
            </c:if>
        </c:forEach>
    </table>
    <button onclick="window.history.back()">Ok</button>
</section>
</body>
</html>

