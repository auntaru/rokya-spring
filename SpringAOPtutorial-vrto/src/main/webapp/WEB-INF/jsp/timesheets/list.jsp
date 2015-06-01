<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- resolve variables -->
<%--@elvariable id="timesheets" type="java.util.List<org.timesheet.domain.Timesheet>"--%>

<html>
<head>
    <title>Timesheets</title>
    <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
    <h1>List of timesheets</h1>
    <a href="timesheets?new">Add new timesheet</a>
    <table cellspacing="5" class="main-table wide">
        <tr>
            <th style="width: 30%">Employee</th>
            <th style="width: 40%">Task</th>
            <th>Hours</th>
            <th style="width: 20%">Details</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${timesheets}" var="ts">
            <tr>
                <td>
                    <a href="employees/${ts.who.id}">${ts.who.name}</a>
                </td>
                <td>
                    <a href="tasks/${ts.task.id}">${ts.task.description}</a>
                </td>
                <td>${ts.hours}</td>
                <td>
                    <a href="timesheets/${ts.id}">Go to page</a>
                </td>
                <td>
                    <sf:form action="timesheets/${ts.id}" method="delete" cssClass="delete">
                        <input type="submit" class="delete-button">
                    </sf:form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br />
    <a href="welcome">Go back</a>
</body>
</html>