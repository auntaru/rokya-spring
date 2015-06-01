<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="employees" type="java.util.List<org.timesheet.domain.Employee"--%>
<%--@elvariable id="tasks" type="java.util.List<org.timesheet.domain.Task"--%>

<html>
<head>
    <title>Add new timesheet</title>
    <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
    <h2>Add new Timesheet</h2>
    <div id="list">
        <sf:form method="post" action="timesheets" commandName="timesheet">
            <ul>
                <li>
                    <label for="employees">Pick employee:</label>
                    <sf:select path="who" id="employees">
                        <sf:options items="${employees}" itemLabel="name" itemValue="id" />
                    </sf:select>
                </li>
                <li>
                    <label for="tasks">Pick task:</label>
                    <sf:select path="task" id="tasks">
                        <sf:options items="${tasks}" itemLabel="description" itemValue="id" />
                    </sf:select>
                </li>
                <li>
                    <label for="hours">Hours:</label>
                    <sf:input path="hours" />
                </li>
                <li>
                    <input type="submit" value="Save" />
                </li>
            </ul>
        </sf:form>
    </div>

    <br /><br />
    <a href="timesheets">Go Back</a>
</body>
</html>