<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Employee page</title>
    <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
    <h2>Employee info</h2>
    <div id="list">
        <sf:form method="post">
            <ul>
                <li>
                    <label for="name">Name:</label>
                    <input name="name" id="name" value="${employee.name}" disabled="true"/>
                </li>
                <li>
                    <label for="department">Department:</label>
                    <input name="department" id="department"
                           value="${employee.department}" disabled="true" />
                </li>
                <li>
                    <input type="button" value="Unlock" id="unlock" />
                    <input type="submit" value="Save" id="save" class="hidden" />
                </li>
            </ul>
        </sf:form>
    </div>

    <br /><br />
    <a href="../employees">Go Back</a>

    <script src="/timesheet-app/resources/jquery-1.7.1.js"></script>
    <script>
        (function() {
            $("#unlock").on("click", function() {
                $("#unlock").addClass("hidden");

                // enable stuff
                $("#name").removeAttr("disabled");
                $("#department").removeAttr("disabled");
                $("#save").removeClass("hidden");
            });
        })();
    </script>
</body>
</html>