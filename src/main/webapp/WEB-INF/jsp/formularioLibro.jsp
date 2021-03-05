<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Libro</title>
</head>
<body>
	<div>
		<form action="/formularioLibro" method="post" modelAttribute="book">
			<table>
				<tr>
					<td><h3>Titulo</h3></td>
					<td><input type="text" name="nombre"></td>
				</tr>
				<tr>
					<td><h3>Isbn</h3></td>
					<td><input type="text" name="isbn"></td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>