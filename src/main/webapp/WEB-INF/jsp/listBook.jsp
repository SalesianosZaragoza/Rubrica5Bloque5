<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Book</title>
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
		<h1>List of Book</h1>
		<form:form action="/searchBook" method="post" modelAttribute="book">
			<br />
			Title: <form:input type="text" path="title" />
			<br />
			Isbn: <form:input type="text" path="isbn" />
			<br />
			Author: <form:input type="text" path="authorName" />
			<br />
			<input type="submit" value="Search">
		</form:form>
		<br>
		<table align="center">
			<tr>
				<th>Title</th>
				<th>Isbn</th>
				<th>Author</th>
			</tr>
			<c:forEach items="${list}" var="book">
				<tr>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.isbn}" /></td>
					<td><c:out value="${book.authorName}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>