<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Book</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body align="center">
	<form:form action="/insertBook" method="post" modelAttribute="book">
		<h1>Insert Book</h1>
		<br />
			Title: <form:input type="text" path="title" />
		<br />
			Isbn: <form:input type="text" path="isbn" />
		<br />
			Author: 
			<form:select path="authorId">
				<form:options items="${listAuthor}" itemLabel="name" itemValue="id"></form:options>
			</form:select>
		<br />
		<input type="submit" value="insert">
	</form:form>
</body>
</html>