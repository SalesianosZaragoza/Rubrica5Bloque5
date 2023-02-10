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
	<table align="center">
		<td>
			<form action="SearchTitulo" method="post" align="center">
				<input type="text" name="titulo" placeholder="buscar por el titulo">
				<input type="submit" name="buscar" value="buscar">
			</form>
		</td>
		<td>
			<form action="SearchIsbn" method="post" align="center">
				<input type="number" name="isbn" placeholder="buscar por el isbn">
				<input type="submit" name="buscar" value="buscar">
			</form>
		</td>
		<td>
			<form action="SearchAutor" method="post" align="center">
				<input type="integer" name="autor_id" placeholder="buscar por el autor">
				<input type="submit" name="buscar" value="buscar">
			</form>
		</td>
	</table>


    <c:forEach items="${listLibro}" var="libro" >
		<table border="1" align="center" width="25%">
			<tr>
				<td>titulo</td>
				<td>isbn</td>
				<td>autor</td>
			</tr>
			<tr>
				<td>${libro.titulo}</td>
				<td>${libro.isbn}</td>
				<td>${libro.autor_id}</td>
			</tr>
		</table>        
	</c:forEach>

	<a href="reloadListLibro">Recargar datos</a>
	<a href="/">inicio</a>
</body>
</html>