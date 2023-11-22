
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manager Information </title>
</head>
<body>
 <form action="ManagerController" method="post">
     <input type="hidden" name="ma_id" value="${MANAGER.ma_id}">
     Name:<input type="text" name="name" value="${MANAGER.name}" required><br>
     Level:<input type="text" name="level" value="${MANAGER.level}" required><br>
     <input type="submit" value="Insert">
 </form>
<a href="index.jsp"> Back home </a>
</body>
</html>
