<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de autores</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
	<div>
		<h1>Lista de autores</h1>
		<form:form id="author" action="/searchAuthor" method="POST"
			modelAttribute="author">
		Find Author by: 
		<br />
		Name: <form:input type="text" path="name" />
			<br />
		Birthday: <form:input id="date" type="date" path="birthday" />
			<br />
			<input type="submit" value="Search">
		</form:form>
		<table>
			<tr>
				<th>Name</th>
				<th>Birthday</th>
			</tr>
			<c:forEach items="${list}" var="author">
				<tr>
					<td><c:out value="${author.name}" /></td>
					<td><c:out value="${author.birthday}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>