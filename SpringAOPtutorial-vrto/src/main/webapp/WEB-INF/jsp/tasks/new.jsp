<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--@elvariable id="task" type="org.timesheet.domain.Task"--%>


<html>
<head>
    <title>Add new task</title>
    <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
    <h2>Add new Task</h2>
    <div id="list">
        <sf:form method="post" action="tasks" commandName="task">
            <ul>
                <li>
                    <label for="description">Description:</label>
                    <input name="description" id="description" value="${task.description}" />
                </li>
                <li>
                    <label for="manager-select">Manager:</label>
                    <sf:select path="manager" id="manager-select">
                        <sf:options items="${managers}" itemLabel="name" itemValue="id" />
                    </sf:select>
                </li>
                <li>
                    Employees will be generated ...
                </li>
                <li>
                    <input type="submit" value="Save">
                </li>
            </ul>
        </sf:form>
    </div>

    <br /><br />
    <a href="tasks">Go Back</a>

</body>
</html>