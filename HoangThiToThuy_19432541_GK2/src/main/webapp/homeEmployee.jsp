<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Information</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<a href="EmployeeController?command=SHOWFORM"> Insert Employee </a>
<h2>Employee Information</h2>

<table>
    <thead>
    <tr>
        <th> ID </th>
        <th> Name </th>
        <th> Old </th>
        <th> Manager Name </th>
        <th> Action </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${EMPLOYEES}">

        <c:url var="updateLink" value="EmployeeController">
            <c:param name="command" value="LOAD"> </c:param>
            <c:param name="emp_id" value="${item.emp_id}"></c:param>
        </c:url>
        <c:url var="deleteLink" value="EmployeeController">
            <c:param name="command" value="DELETE" />
            <c:param name="emp_id" value="${item.emp_id}" />
        </c:url>
        <tr>
            <td>${item.emp_id}</td>
            <td>${item.name}</td>
            <td>${item.old}</td>
            <td>${item.manager.name}</td>
            <th>
                <a href="${updateLink}">Update</a> ||
                <a href="${deleteLink}">Delete</a>
            </th>
        </tr>

    </c:forEach>
    </tbody>
</table>
<a href="index.jsp">Back home</a>
</body>
</html>
