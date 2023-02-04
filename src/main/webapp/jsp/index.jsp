<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="addAutorForm" method="post" modelAttribute="autor">
		<span>Nombre:</span>
		<form:input path="nombre" type="text" name="nombre"/>
		<span>Fecha nacimiento:</span>
		<form:input path="fecha_nacimiento" type="date" name="fecha_nacimiento"/>
		<input type="submit" value="Enviar"/>
	</form:form>
	<a href="/">inicio</a>
	
</body>
</html>