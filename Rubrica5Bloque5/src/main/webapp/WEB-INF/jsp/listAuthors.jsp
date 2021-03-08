<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Authors</title>
</head>
<body>
	<div>
		<h1>List of Authors</h1>
		<form:form id="author" action="/searchAuthor" method="POST" modelAttribute="author">
			Name: <form:input type="text" path="name" />
			<button type="submit" class="btn btn-info">Search by Name</button>
		</form:form>
		<form:form id="author" action="/searchAuthor" method="POST" modelAttribute="author">
			DayOfBirth: <form:input id="date" type="date" path="birthday" />
			<button type="submit" class="btn btn-info">Search by birthday</button>
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