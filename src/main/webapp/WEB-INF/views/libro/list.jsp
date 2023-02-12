<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>List Autores</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
	      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h2>Buscar por:</h2>
	<form method="post" action="/libro/find">

		<div class="input-group mb-3">
			<span class="input-group-text" id="titulo">Titulo</span>
			<input name="titulo" type="text" class="form-control" aria-label="Introduce el titulo"
			       aria-describedby="inputGroup-sizing-default">
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text" id="isbn">Isbn</span>
			<input name="isbn" type="text" class="form-control" aria-label="Introduce el isbn"
			       aria-describedby="inputGroup-sizing-default">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="nombreAutor">Nombre autor</span>
			<input name="nombreAutor" type="text" class="form-control" aria-label="Introduce nombre autor"
			       aria-describedby="inputGroup-sizing-default">
		</div>

		<button class="btn btn-primary" type="submit">Buscar</button>
	</form>
	<table class="table">
		<thead>
		<tr>
			<th scope="col">Titulo</th>
			<th scope="col">ISBN</th>
			<th scope="col">Autor</th>

		</tr>
		</thead>
		<tbody>
		<jsp:useBean id="libros" scope="request" type="java.util.List"/>
		<c:forEach var="libro" items="${libros}">
			<tr>
				<td>${libro.titulo}</td>
				<td>${libro.isbn}</td>
				<td>${libro.autor.nombre}</td>
			</tr>
		</c:forEach>
		<c:if test="${libros.size() == 0}">
			<tr>
				<td colspan="2">No hay datos</td>
			</tr>
		</c:if>
		</tbody>
	</table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>