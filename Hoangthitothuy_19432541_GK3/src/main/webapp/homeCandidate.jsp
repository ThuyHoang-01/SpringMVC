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

<a href="CandidateController?command=SHOWFORM"> Insert Candidate </a>
<h2>Candidate Information</h2>

<table>
    <thead>
    <tr>
        <th> ID </th>
        <th> Full Name </th>
        <th> Email </th>
        <th> Company Name </th>
        <th> Action </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${CANDIDATES}">

        <c:url var="updateLink" value="CandidateController">
            <c:param name="command" value="LOAD"> </c:param>
            <c:param name="can_id" value="${item.can_id}"></c:param>
        </c:url>

        <tr>
            <td>${item.can_id}</td>
            <td>${item.full_nam}</td>
            <td>${item.email}</td>
            <td>${item.company.comp_name}</td>
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
