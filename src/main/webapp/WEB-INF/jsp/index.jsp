<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script src=" <c:url value="/js/jquery-1.12.3.min.js" /> "></script>
    </head>
    <body>
        <h1>Ejemplo Spring + JDBC</h1>
        <form method="POST" action="/SpringProject/muestraGrupos">
            <h3>Ingresa id delProfesor</h3>
            <input id="id_profesor" name="id_profesor" type="text" placeholder=" Id Profesor">
            <button>Aceptar</button>
        </body>
</html>
