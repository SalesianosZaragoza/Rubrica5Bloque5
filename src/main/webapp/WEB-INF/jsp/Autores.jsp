<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Autores</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
<style>
table, th, td {
	border: 0.1rem solid black;
	padding: 1rem;
}
</style>
<title>Autores</title>
</head>
<body>
	<form:form id="autor" action="/buscarPorNombre" method="POST" modelAttribute="autor">
		<form:input id="nombre" type="text" path="Nombre" />
		<button type="submit" class="btn btn-info">Buscar por nombre</button>
	</form:form>
	<form:form id="autor" action="/buscarPorFecha" method="POST" modelAttribute="autor">
		<form:input id="fecha" type="text" path="FechaNac" />
		<button type="submit" class="btn btn-info">Buscar por fecha</button>
	</form:form>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Fecha nacimento</th>
		</tr>
		<c:forEach items="${autores}" var="autor">
			<tr>
				<th><c:out value="${autor.nombre}"/></th>
				<th><c:out value="${autor.fechaNac}"/></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>