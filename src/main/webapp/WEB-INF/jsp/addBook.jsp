<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nuevo libro</title>
</head>
<body>
	<form:form action="addBook" method="post" modelAttribute="Book">
		<span>Nombre:</span>
		<form:input path="name" type="text" name="name"/>
		<span>Isbn:</span>
		<form:input path="isbn" type="text" name="isbn"/>
		<span>Nombre del Autor:</span>
		<form:input path="authorName" type="text" name="authorName"/>
		
		<input type="submit"/>
	</form:form>
</body>
</html>