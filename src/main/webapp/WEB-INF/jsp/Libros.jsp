<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Libros</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
<style>
table, th, td {
	border: 0.1rem solid black;
	padding: 1rem;
}
</style>
<title>Libros</title>
</head>
<body>
	<form:form id="libro" action="/buscarPorTitulo" method="POST" modelAttribute="libro">
		<form:input id="titulo" type="text" path="Titulo" />
		<button type="submit" class="btn btn-info">Buscar por título</button>
	</form:form>
	
	<form:form id="libro" action="/buscarPorISBN" method="POST" modelAttribute="libro">
		<form:input id="isbn" type="text" path="isbn" />
		<button type="submit" class="btn btn-info">Buscar por isbn</button>
	</form:form>
	
	<form:form id="libro" action="/buscarPorAutor" method="POST" modelAttribute="libro">
		<form:input id="autor" type="text" path="autor" />
		<button type="submit" class="btn btn-info">Buscar por Autor</button>
	</form:form>
	
	<table>
		<tr>
			<th>Título</th>
			<th>ISBN</th>
			<th>Autor</th>
		</tr>
		<c:forEach items="${autores}" var="autor">
			<tr>
				<th><c:out value="${libro.titulo}"/></th>
				<th><c:out value="${libro.isbn}"/></th>
				<th><c:out value="${libro.autorNombre}"/></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>