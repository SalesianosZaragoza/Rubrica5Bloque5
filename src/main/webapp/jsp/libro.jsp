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

<h1>Libro</h1>
<form:form action="addLibroForm" method="post" modelAttribute="libro">
	<!--input  titulo-->
	<span>Titulo:</span>
	<form:input path="titulo" type="text" name="titulo"/>
	<!--input  isbn-->
	<span>ISBN:</span>
	<form:input path="isbn" type="number" name="isbn"/>
	<!--input autor-->
	<span>Autor:</span>
	<form:input path="autor" type="text" name="autor"/>
	<input type="submit"/>
</form:form>

<a href="/">inicio</a>	
</body>
</html>