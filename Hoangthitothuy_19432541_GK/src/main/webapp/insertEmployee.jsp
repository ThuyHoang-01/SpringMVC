
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manager Information </title>
</head>
<body>
<form action="EmployeeController" method="post">
    Name: <input type="text" name="name" required> <br>
    Old: <input type="text" name="old" required> <br>
    Manager: <select name="manager" id="manager">

    <c:forEach var="item" items="${MANAGERS}">
        <option value="${item.ma_id}">${item.name}</option>
    </c:forEach>

    <input type="submit" value="Insert">
</form>
<a href="index.jsp">Back home</a>

</body>
</html>
