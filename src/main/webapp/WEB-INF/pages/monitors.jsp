<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <title>Monitors</title>
</head>
<body>

<h1>Список мониторов</h1>

<table class="table table-bordered" border ="1">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Url</th>
        <th scope="col">Method(HTTP)</th>
        <th scope="col">Timeout(ms)</th>
        <th scope="col">Expected status</th>
        <th scope="col">Enabled</th>
        <th scope="col">Period seconds</th>
        <th scope="col">Created at</th>
        <th scope="col">Updated at</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="monitor" items="${monitors}">
    <tr>
        <td><c:out value="${monitor.id}" /></td>
        <td><c:out value="${monitor.name}"/></td>
        <td><c:out value="${monitor.url}"/></td>
        <td><c:out value="${monitor.method}"/></td>
        <td><c:out value="${monitor.timeoutMs}"/></td>
        <td><c:out value="${monitor.expectedStatus}"/></td>
        <td><c:out value="${monitor.enabled}"/></td>
        <td><c:out value="${monitor.periodSeconds}"/></td>
        <td><c:out value="${monitor.createdAt}"/></td>
        <td><c:out value="${monitor.updatedAt}"/></td>
        <td>
            <form action="<c:url value='/deleteMonitor'/>" method="post" style="display:inline;">
                <input type="hidden" name="id" value="${monitor.id}" />
                <button type="submit" class="btn btn-danger btn-sm">Delete</button>
            </form>
            <a href="<c:url value='/updateMonitor?id=${monitor.id}'/>" class="btn btn-primary btn-sm">
                Edit
            </a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>