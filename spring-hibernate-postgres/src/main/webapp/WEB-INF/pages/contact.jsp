<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Hibernate</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>

<h2>Orders Viewer</h2>

	
<h3>Orders</h3>
<c:if  test="${!empty ordersList}">
<table class="data">
<tr>
	<th>Nr.doc/gestiune iD</th>
	<th>Agent Name</th>
	<th>Valoare</th>
	<th>Order iD;</th>
</tr>
<c:forEach items="${ordersList}" var="order">
	<tr>
		<td>${order.nrdoc}, ${order.gestiuneId} </td>
		<td> ... </td>
		<td>${order.valoare}</td>
		<td>${order.comId}</td>
	</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>


<!--
        <th>Agent iD</th>   
		<td>${order.nrlcId}</td>
--> 
