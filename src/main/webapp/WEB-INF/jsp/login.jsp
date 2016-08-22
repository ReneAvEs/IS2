<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script src=" <c:url value="/js/jquery-1.12.3.min.js" /> "></script>
        <script src=" <c:url value="/js/ejemplo.js" /> "></script>
    </head>
    <body>
        <h1>Inicio de sesión</h1>
        <form method="POST" action="/SpringProject/login">
            <h3>Usuario</h3>
            <input id="login" name="login" type="text" placeholder=" Login">
            <h3>Contraseña</h3>
            <input id="contrasena" name="contrasena" type="password" placeholder=" Contraseña"> 
            <br><br>
            <button>Iniciar Sesión</button>
            <br><br>
            </form>
            <br>
            <hr>
            <br>
            <h3>Ejemplo JavaScript</h3>
            <button type="button" onclick="despliega_ventana()">Desplegar ventana</button>
        
        </body>
</html>
