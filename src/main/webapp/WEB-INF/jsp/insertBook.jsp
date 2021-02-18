<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert new Book</title>
</head>
<body>
	<form:form action="/insertBook" method="post" modelAttribute="book">
		<span>Title:</span>
		<form:input type="text" path="title" />
		<span>ISBN:</span>
		<form:input type="text" path="isbn" />
		<span>Author:</span>
		<form:select path="authorID">
			<form:options items="${listAuthors}" itemLabel="name" itemValue="id"></form:options>
		</form:select>
		<input type="submit" value="insert">
	</form:form>

</body>
</html>