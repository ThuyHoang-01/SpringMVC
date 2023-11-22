
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Company Information </title>
</head>
<body>
<form action="CompanyController" method="post">
    <input type="hidden" name="com_id" value="${COMPANYS.com_id}">
    About Us:<input type="text" name="about" value="${COMPANYS.about}" required><br>
    Company Name:<input type="text" name="comp_name" value="${COMPANYS.comp_name}" required><br>
    <input type="submit" value="Insert">
</form>
<a href="index.jsp"> Back home </a>
</body>
</html>
