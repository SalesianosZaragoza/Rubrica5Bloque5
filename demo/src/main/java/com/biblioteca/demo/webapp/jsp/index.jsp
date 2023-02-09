<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

<h1>Biblioteca</h1>

<h2>Lista de libros</h2>
<a href="anadirLibros">Añadir libro</a>
<a href="anadirAutor">Añadir autor</a>
<br>
<a href="buscarLibro">Buscar Libro</a>
<a href="buscarAutor">Buscar Autor</a>
<br>

<h1>Lista de libros</h1>

<table class="table table-striped">
	<tr>
		<th>Titulo</th>
		<th>Autor</th>
		<th>ISBN</th>
		<th>Eliminar</th>
	</tr>
	<c:forEach items="${listaLibros}" var="libro">
		<tr>
			<td>${libro.titulo}</td>
			<td>${libro.autor.nombre}</td>
			<td>${libro.isbn}</td>
			<td><a href="eliminarLibro?id=${libro.id}">Eliminar</a></td>
		</tr>
	</c:forEach>
</table>



</body>
</html>