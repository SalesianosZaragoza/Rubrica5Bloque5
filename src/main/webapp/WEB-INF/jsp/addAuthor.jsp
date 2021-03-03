<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Author</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<form:form action="/insertAuthor" method="POST" modelAttribute="author">
			<h2>Add Author</h2>
			<br />
			Name: <form:input type="text" path="name" />
			DayOfBirth: <form:input type="text" path="dayOfBirth" />
			<button type="submit" class="btn btn-info">Save author</button>
		</form:form>
	</div>
</body>
</html>