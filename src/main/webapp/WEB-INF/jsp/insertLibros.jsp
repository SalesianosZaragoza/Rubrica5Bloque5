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
	<form:form action="addlibro" method="post" modelAttribute="owner">
		<span>Título:</span>
		<form:input path="name" type="text" name="name"/>
		<span>isbn:</span>
		<form:input path="isbn" type="text" name="isbn"/>
		<form:select path="codAutor">
				<form:options items="${autores}" itemLabel="name" itemValue="id"></form:options>
		</form:select>
		<input type="submit"/>
	</form:form>
</body>
</html>