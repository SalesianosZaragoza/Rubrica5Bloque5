<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Autores</title>
    </head>
    <body>
        <h3>Buscar autores:</h3>
        <br/><br/>
        <form action="buscarAutores" method="post">
            <span>Nombre: </span>
            <input type="text" name="nombre"  /> <br/><br/>
            
            <span>Fecha nacimiento: </span>
            <input type="date" name="fNac"  /> <br/><br/>

            <input type="submit" value="Buscar"/>
        </form>

        <br/><br/><br/>

        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Fecha nacimiento</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="autor" items="${listaAutores}">
                    <tr>
                        <td>${autor.nombre}</td>
                        <td>${autor.fNac}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
