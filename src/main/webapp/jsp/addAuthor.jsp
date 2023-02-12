<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Author</h1>
	<form:form action="/addAuthorForm" method="post" modelAttribute="author">
		<span>Name:</span>
		<form:input path="name" type="text" name="name"/>
		<span>Birthday:</span>
		<form:input path="birthday" type="text" name="birthday"/>
		<input type="submit"/>
	</form:form>
</body>
</html>