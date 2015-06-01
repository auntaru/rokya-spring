<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Managers</title>
    <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
    <h1>List of managers</h1>
    <a href="managers?new">Add new manager</a>
    <table cellspacing="5" class="main-table">
        <tr>
            <th>Name</th>
            <th>Details</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="#{managers}" var="man">
            <tr>
                <td>${man.name}</td>
                <td>
                    <a href="managers/${man.id}">Go to page</a>
                </td>
                <td>
                    <sf:form action="managers/${man.id}" method="delete" cssClass="delete">
                        <input type="submit" value="" class="delete-button" />
                    </sf:form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br />
    <a href="welcome">Go back</a>
</body>
</html>