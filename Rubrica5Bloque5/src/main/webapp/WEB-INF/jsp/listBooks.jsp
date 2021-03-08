<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Books</title>
</head>
<body>
	<div>
		<h1>List of Books</h1>
		<form:form action="/searchBook" method="POST" modelAttribute="book">
			Title: <form:input type="text" path="title" />
			<button type="submit" class="btn btn-info">Search by Title</button>
		</form:form>
		<form:form action="/searchBook" method="POST" modelAttribute="book">
			Isbn: <form:input type="text" path="isbn" />
			<button type="submit" class="btn btn-info">Search by Isbn</button>
		</form:form>
		<form:form action="/searchBook" method="POST" modelAttribute="book">
			Author: <form:input type="text" path="authorName" />
			<button type="submit" class="btn btn-info">Search by Author</button>
		</form:form>
		<table>
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