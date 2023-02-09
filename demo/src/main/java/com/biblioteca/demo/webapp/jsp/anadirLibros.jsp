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

<h1>Añadir Libro</h1>
formulario añadir libros 

<form:form action="anadirLibro" method="post" modelAttribute="libro">
    <form:input path="titulo" />
    <form:input path="autor" />
    <form:input path="isbn" />
    <form:button type="submit" value="Añadir" />
    <form:submit />
</form:form>
    


</body>
</html>