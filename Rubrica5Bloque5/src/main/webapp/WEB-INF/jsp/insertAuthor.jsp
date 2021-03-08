<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Author</title>
</head>
<body>
<form:form action="/insertAuthor" method="POST" modelAttribute="author">
	<h1>Insert New Author</h1>
	<br />
	Name: <form:input type="text" path="name" />
	<br />
	Birthday: <form:input type="text" path="birthday" />
	<br />
	<input type="submit" value="Insert">
</form:form>
</body>
</html>