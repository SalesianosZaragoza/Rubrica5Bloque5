<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Libros</title>
    </head>
    <body>
        <h3>Buscar libros:</h3>
        <br/><br/>
        <form action="buscarLibros" method="post">
            <span>Titulo: </span>
            <input type="text" name="titulo"  /> <br/><br/>
            
            <span>ISBN: </span>
            <input type="text" name="isbn"  /> <br/><br/>

            <span>Nombre autor:</span>
            <input type="text" name="nombreAutor" /> <br/><br/>

            <input type="submit" value="Buscar"/>
        </form>

        <br/><br/><br/>

        <table>
            <thead>
                <tr>
                    <th>Titulo</th>
                    <th>ISBN</th>
                    <th>Autor</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="libro" items="${listaLibros}">
                    <tr>
                        <td>${libro.titulo}</td>
                        <td>${libro.isbn}</td>
                        <td>${libro.autor.nombre}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
