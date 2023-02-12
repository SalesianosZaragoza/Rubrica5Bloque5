<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Libro</title>
    </head>
    <body>
        <h3>Insertar un libro:</h3>
        <br/><br/>
        <form:form action="addLibro" method="post">
            <span>Titulo:</span>
            <input type="text" name="titulo" id="titulo" /> <br/><br/>
            
            <span>ISBN:</span>
            <input type="text" name="isbn" id="isbn" /> <br/><br/>
            
            <span>Autor:</span>
            <select name="autorID">
                <c:forEach var="autor" items="${listaAutores}">
                    <option value="${autor.ID}">${autor.nombre}</option>
                </c:forEach>
            </select>

            <input type="submit" value="Insertar" />
        </form:form> 
    </body>
</html>
