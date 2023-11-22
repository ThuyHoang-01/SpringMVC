
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manager Information</title>
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

<a href="insertManager.jsp">Insert Manager</a>
 <table>
     <thead>
     <tr>
         <th> ID </th>
         <th> Name </th>
         <th> Level </th>
         <th> Action </th>
     </tr>
     </thead>
     <tbody>
     <c:forEach var="item" items="${MANAGERS}">
         <c:url var="updateLink" value="ManagerController">
             <c:param name="command" value="LOAD" />
             <c:param name="ma_id" value="${item.ma_id}" />
         </c:url>
         <c:url var="deleteLink" value="ManagerController">
             <c:param name="command" value="DELETE" />
             <c:param name="ma_id" value="${item.ma_id}" />
         </c:url>

     <tr>
         <td>${item.ma_id}</td>
         <td>${item.name}</td>
         <td>${item.level}</td>
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
