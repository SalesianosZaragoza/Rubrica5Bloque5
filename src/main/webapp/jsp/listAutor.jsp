<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>end</title>
</head>
<body>
	
<!-- hacer un form para hacer una busqueda por el nombre del autor-->
<form action="SearchNombre" method="post" align="center">
    <input type="text" name="nombre" placeholder="buscar por el nombre">
    <input type="submit" name="buscar" value="buscar">
</form>
<form action="SearchNacimiento" method="post" align="center">
    <input type="date" name="fecha_nacimiento" placeholder="Fecha de nacimiento">
    <input type="submit" name="buscar" value="buscar">
</form>

<c:forEach items="${listAutor}" var="autor" >
    <!--Hacer una tabla-->
    <table border="1" align="center" width="25%">
        <tr>
            <td>Nombre</td>
            <td>Fecha de nacimiento</td>
        </tr>
        <tr>
            <td>${autor.nombre}</td>
            <td>${autor.fecha_nacimiento}</td>
        </tr>
    </table>
</c:forEach>



<a href="reloadListAutor">Ver todo</a>
<a href="/">inicio</a>
</body>
</html>