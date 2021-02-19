<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Author</title>
<style>
table, th, td {
	border: 1px solid black;
	align-content: center;
}
</style>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body align="center">
	<div>
		<h1>List Author</h1>
		<form:form id="author" action="/searchAuthor" method="post" modelAttribute="author">
		<br />
		Name: <form:input type="text" path="name" />
			<br />
		Birthday: <form:input id="date" type="date" path="birthday" />
			<br />
			<input type="submit" value="Search">
		</form:form>
		<br>
		<table align="center">
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