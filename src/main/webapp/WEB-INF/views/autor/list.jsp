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
	<form method="post" action="/autor/find">
		<div class="input-group mb-3">
			<span class="input-group-text" id="nombre">Nombre</span>
			<input name="nombre" type="text" class="form-control" aria-label="Introduce nombre autor"
			       aria-describedby="inputGroup-sizing-default">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="fecha_nacimiento">Fecha de Nacimiento</span>
			<input name="fNac" type="date" class="form-control" aria-label="Introduce decha de nacimiento"
			       aria-describedby="inputGroup-sizing-default">
		</div>

		<button class="btn btn-primary" type="submit">Buscar</button>
	</form>
	<table class="table">
		<tbody>
		<jsp:useBean id="autores" scope="request" type="java.util.List"/>
		<c:forEach var="autor" items="${autores}">
			<tr>
				<td>${autor.nombre}</td>
				<td>${autor.fNac}</td>
			</tr>
		</c:forEach>
		<c:if test="${autores.size() == 0}">
			<tr>
				<td colspan="2">No hay datos</td>
			</tr>
		</c:if>
		</tbody>
		<thead>
		<tr>
			<th scope="col">Nombre</th>
			<th scope="col">Fecha Nacimiento</th>
		</tr>
		</thead>
	</table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>