<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Books</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>List of Books</h2>
		<br />
		<form:form action="/searchBookByTitle" method="POST" modelAttribute="book">
			Title: <form:input type="text" path="title" />
			<button type="submit" class="btn btn-info">Search by Title</button>
		</form:form>
		<form:form action="/searchBookByIsbn" method="POST" modelAttribute="book">
			Isbn: <form:input type="text" path="isbn" />
			<button type="submit" class="btn btn-info">Search by Isbn</button>
		</form:form>
		<form:form action="/searchBookByAuthor" method="POST" modelAttribute="book">
			Author: <form:input type="text" path="authorName" />
			<button type="submit" class="btn btn-info">Search by Author</button>
		</form:form>
		<table class="table">
		  <thead>
		    <tr>
		      <th>Title</th>
			  <th>Isbn</th>
			  <th>Author</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${list}" var="book">
				<tr>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.isbn}" /></td>
					<td><c:out value="${book.authorName}" /></td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
		<a class="btn btn-info" href="insertBook" role="button">Insert new Book</a>
	</div>

</body>
</html>