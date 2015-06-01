<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="employee" type="org.timesheet.domain.Employee"--%>
<%--@elvariable id="tasks" type="java.util.List<org.timesheet.domain.Task>"--%>

<html>
<head>
    <title>Tasks for employee</title>
    <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
    <h3>
        Current employee: <a href="/timesheet-app/employees/${employee.id}">${employee.name}</a>
    </h3>
    <div id="list">
        <c:forEach items="${tasks}" var="task">
            <li>
                <a href="/timesheet-app/tasks/${task.id}">${task.description}</a>
            </li>
        </c:forEach>
    </div>

    <br /><br />
    <a href="../">Go Back</a>
</body>
</html>