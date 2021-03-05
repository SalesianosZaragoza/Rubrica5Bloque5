<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Author</title>
</head>
<body>
	<div>
		<form action="/formularioAuthor" method="post" modelAttribute="author">
			<table>
				<tr>
					<td><h3>name</h3></td>
					<td><input type="text" name="nombre"></td>
				</tr>
				<tr>
					<td><h3>Fecha nacimiento</h3></td>
					<td><input type="date" name="fechaNac"></td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>