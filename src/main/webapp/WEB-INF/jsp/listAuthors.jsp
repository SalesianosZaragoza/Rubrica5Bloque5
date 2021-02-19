<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Authors</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>List of Authors</h2>
		<br />
		<form:form id="author" action="/searchAuthorByName" method="POST" modelAttribute="author">
			Name: <form:input type="text" path="name" />
			<button type="submit" class="btn btn-info">Search by Name</button>
		</form:form>
		<form:form id="author" action="/searchAuthorByDayOfBirth" method="POST" modelAttribute="author">
			DayOfBirth: <form:input id="date" type="text" path="dayOfBirth" />
			<button type="submit" class="btn btn-info">Search by DayOfBirth</button>
		</form:form>
		
		<table class="table">
		  <thead>
		    <tr>
		      <th>Name</th>
			  <th>DayOfBirth</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${list}" var="author">
				<tr>
					<td><c:out value="${author.name}" /></td>
					<td><c:out value="${author.dayOfBirth}" /></td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
		<a class="btn btn-info" href="insertAuthor" role="button">Insert new Author</a>
	</div>
	
</body>
</html>