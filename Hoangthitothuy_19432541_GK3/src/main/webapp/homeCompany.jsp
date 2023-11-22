
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Company Information</title>
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

<a href="insertCompany.jsp">Insert Company</a>
<table>
    <thead>
    <tr>
        <th> ID </th>
        <th> Name </th>
        <th> About Us </th>
        <th> Action </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${COMPANYS}">
        <c:url var="updateLink" value="CompanyController">
            <c:param name="command" value="LOAD" />
            <c:param name="com_id" value="${item.com_id}" />
        </c:url>

        <tr>
            <td>${item.com_id}</td>
            <td>${item.comp_name}</td>
            <td>${item.about}</td>
            <th>
                <a href="${updateLink}">Update</a> ||

            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="index.jsp">Back home</a>
</body>
</html>
