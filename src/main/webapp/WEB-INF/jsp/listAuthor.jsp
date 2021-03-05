<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Books</title>
</head>
<body>
<form action="listAllA" method="post">
	<input type="submit" value="ver listado">
</form>
<br/>
<br/>
<br/>
<table border="1">
	<thead>
		<tr>
			<td>Name</td>
			<td>Fecha nacimiento</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="Author" items="${listAuthor}">
			<tr>
				<td><c:out value="${Author.name}"/> </td>
				<td><c:out value="${Author.BirthDate}"/> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

</body>