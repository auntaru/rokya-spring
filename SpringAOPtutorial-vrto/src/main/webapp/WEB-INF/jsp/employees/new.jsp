<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new employee</title>
    <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
    <h2>Add new Employee</h2>
    <div id="list">
        <sf:form method="post" action="employees">
            <ul>
                <li>
                    <label for="name">Name:</label>
                    <input name="name" id="name" value="${employee.name}"/>
                </li>
                <li>
                    <label for="department">Department:</label>
                    <input name="department" id="department"
                           value="${employee.department}" />
                </li>
                <li>
                    <input type="submit" value="Save" id="save" />
                </li>
            </ul>
        </sf:form>
    </div>

    <br /><br />
    <a href="employees">Go Back</a>
</body>
</html>