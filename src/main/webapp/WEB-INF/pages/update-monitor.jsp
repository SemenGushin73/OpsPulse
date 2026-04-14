<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 14.04.2026
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<h1>Update Monitor</h1>
<form action="<c:url value="/updateMonitor"/>" method="post">
    <label>Id: <input type="number" name="id" required></label><br>
    <label>Name: <input type="text" name="name" required></label><br>
    <label>Url: <input type="text" name="url" required></label><br>
    <label>Method: <input type="text" name="method" required></label><br>
    <label>Timeout: <input type="number" name="timeoutMs" required></label><br>
    <label>Expected Status: <input type="number" name="expectedStatus" required></label><br>
    <label>Enabled: <input type="checkbox" name="enabled" required></label><br>
    <label>Period Seconds: <input type="number" name="periodSeconds" required></label><br>
    <label>Created At: <input type="datetime-local" name="createdAt" required></label><br>
    <label>Updated At: <input type="datetime-local" name="updatedAt" required></label><br>
    <button type="submit">Update Monitor</button>
</form>

</body>
</html>
