<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--@elvariable id="tsCommand" type="org.timesheet.web.commands.TimesheetCommand"--%>

<html>
<head>
    <title>Timesheet page</title>
    <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
    <h2>Timesheet info</h2>
    <div id="list">
        <sf:form method="post" modelAttribute="tsCommand">
            <sf:errors path="*" cssClass="errors" element="div" />
            <ul>
                <li>
                    <label for="employeeName">Assigned employee:</label>
                    <a id="employee" href="../employees/${tsCommand.timesheet.who.id}">
                        ${tsCommand.timesheet.who.name}
                    </a>
                </li>
                <li>
                    <label for="task">Task:</label>
                    <a id="task" href="../tasks/${tsCommand.timesheet.task.id}">
                        ${tsCommand.timesheet.task.description}
                    </a>
                </li>
                <li>
                    <label for="hours">Hours:</label>
                    <input name="hours" id="hours" value="${tsCommand.hours}" />
                </li>
                <li>
                    <input type="submit" value="Save" />
                </li>
            </ul>
        </sf:form>
    </div>

    <br /><br />
    <a href="../timesheets">Go Back</a>
</body>
</html>