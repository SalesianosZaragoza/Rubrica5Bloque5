<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Autor</title>
    </head>
    <body>
        <h3>Insertar un autor:</h3>
        <br/><br/>
        <form:form action="addAutor" method="post" modelAttribute="autor">
            <span>Nombre:</span>
            <input type="text" name="nombre" id="nombre" />
            <br/><br/>
            <span>Fecha nacimiento:</span>
            <input type="date" name="fNac" id="fNac" />
            <br/><br/>
            <input type="submit" value="Insertar" />
        </form:form>
    </body>
</html>
