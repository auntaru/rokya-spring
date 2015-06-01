<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- resolve variables -->
<%--@elvariable id="tasks" type="java.util.List<org.timesheet.domain.Task>"--%>

<html>
<head>
    <title>Tasks</title>
    <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
    <h1>List of tasks</h1>
    <a href="tasks?new">Add new task</a>
    <table cellspacing="5" class="main-table wide">
        <tr>
            <th style="width: 35%;">Description</th>
            <th>Manager</th>
            <th>Employees</th>
            <th>Completed</th>
            <th style="width: 20%;">Details</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.description}</td>
                <td>
                    <a href="managers/${task.manager.id}">${task.manager.name}</a>
                </td>
                <td>
                    <c:forEach items="${task.assignedEmployees}" var="emp">
                        <a href="employees/${emp.id}">${emp.name}</a>
                    </c:forEach>
                </td>
                <td>
                    <div class="delete">
                        <c:choose>
                            <c:when test="${task.completed}">
                                Done
                            </c:when>
                            <c:when test="${!task.completed}">
                                In progress
                            </c:when>
                        </c:choose>
                    </div>
                </td>
                <td>
                    <a href="tasks/${task.id}">Go to page</a>
                </td>
                <td>
                    <sf:form action="tasks/${task.id}" method="delete" cssClass="delete">
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