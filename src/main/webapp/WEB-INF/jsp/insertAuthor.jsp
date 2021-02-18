<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert new Author</title>
</head>
<body>
	<form:form action="/insertAuthor" method="post" modelAttribute="author">
		<span>Name:</span>
	 	<form:input type="text" path="name" />
		<span>Birthday:</span>
	 	<form:input type="text" path="birthday" />
		<input type="submit" value="insert">
	</form:form>

</body>
</html>