<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Los grupos del profesor con id : ${id_profesor}</h1>
        <c:forEach var="grupo" items="${grupos}">
            <h2>${grupo}</h2>
        </c:forEach>
    </body>
</html>
