<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Authors</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
	<div>
		<h1>List of Authors</h1>
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
	<script>
		function validateDate() {
			let date = document.getElementById("date");
			let value = date.value;
			if (value == "") {
				date.value = "0001-01-01";
			}
		}

		var form = document.getElementById('author');
		form.addEventListener('submit', validateDate, false);
	</script>
</body>
</html>