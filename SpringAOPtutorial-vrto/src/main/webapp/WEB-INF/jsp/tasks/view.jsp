<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--@elvariable id="task" type="org.timesheet.domain.Task"--%>
<%--@elvariable id="unassigned" type="java.util.List<org.timesheet.domain.Employee>"--%>

<html>
<head>
    <title>Task page</title>
    <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
    <h2>Task info</h2>
    <div id="list">
        <ul>
            <li>
                <label for="description">Description:</label>
                <input name="description" id="description" value="${task.description}"
                       disabled="${task.completed ? 'disabled' : ''}" />
            </li>
            <li>
                <label for="manager">Manager:</label>
                <input name="manager" id="manager" value="${task.manager.name}"
                        disabled="true" />
            </li>
            <li>
                <label for="employees">Employees:</label>
                <table id="employees" class="task-table">
                    <c:forEach items="${task.assignedEmployees}" var="emp">
                        <tr>
                            <sf:form action="${task.id}/employees/${emp.id}" method="delete">
                                <td>
                                    <a href="../employees/${emp.id}" id="href-${emp.id}">${emp.name}</a>
                                </td>
                                <td>
                                    <input type="submit" value="Remove" id="remove-${emp.id}" />
                                    <script src="/timesheet-app/resources/jquery-1.7.1.js"></script>
                                    <script type="text/javascript">
                                        $("#remove-${emp.id}").on("click", function() {
                                            $("#remove-${emp.id}").addClass("hidden");
                                            $("#href-${emp.id}").remove();

                                            // add to list of unassigned
                                            var opt = document.createElement("option");
                                            opt.setAttribute("value", "${emp.id}");
                                            opt.textContent = "${emp.name}";
                                            $("#selected-emp").append(opt);
                                        });
                                    </script>
                                </td>
                            </sf:form>
                        </tr>
                    </c:forEach>
                </table>
            </li>
            <li>
                <label for="unassigned">Unassgined:</label>
                <table id="unassigned" class="task-table">
                    <tr>
                        <sf:form method="put" id="add-form">
                            <td>
                                <select id="selected-emp">
                                    <c:forEach items="${unassigned}" var="uemp">
                                        <option value="${uemp.id}">
                                            ${uemp.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <input type="submit" value="Add" id="add-employee" />
                                <script src="/timesheet-app/resources/jquery-1.7.1.js"></script>
                                <script type="text/javascript">
                                    $("#add-employee").on("click", function() {
                                        $("#selected-emp").selected().remove();
                                    });
                                </script>
                            </td>
                        </sf:form>
                    </tr>
                </table>
            </li>
        </ul>
    </div>

    <br /><br />
    <a href="../tasks">Go Back</a>

    <script src="/timesheet-app/resources/jquery-1.7.1.js"></script>
    <script type="text/javascript">
        (function() {
            // prepare default form action
            setAddAction();

            // handler for changing action
            $("#selected-emp").on("change", function() {
                setAddAction();
            });

            function setAddAction() {
                var id = $("#selected-emp").val();
                $("#add-form").attr("action", "${task.id}/employees/" + id);
            }
        })();
    </script>
</body>
</html>