<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Book</title>
</head>
<body>
	<form:form action="/insertBook" method="POST" modelAttribute="book">
		<h1>Insert New Book</h1>
		<br />
		Title: <form:input type="text" path="title" />
		<br />
		Isbn: <form:input type="text" path="isbn" />
		<br />
		Author: 
		<form:select path="authorId">
			<form:options items="${listAuthors}" itemLabel="name" itemValue="id"></form:options>
		</form:select>
		<br />
		<input type="submit" value="Insert">
	</form:form>
</body>
</html>