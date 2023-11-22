
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Candidate Information </title>
</head>
<body>
<form action="CandidateController" method="post">
    <input type="hidden" name="com_id" value="${CANDIDATES.com_id}">
    Email <input type="text" name="email" value="${CANDIDATES.email}" required><br>
    Full Name:<input type="text" name="full_name" value="${CANDIDATES.full_name}" required><br>
    <input type="submit" value="Insert">
</form>
<a href="index.jsp"> Back home </a>
</body>
</html>
