<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Book</h1>
	<form:form action="/addBookForm" method="post" modelAttribute="book">
		<span>Title:</span>
		<form:input path="title" type="text" name="title"/>
		<span>ISBN:</span>
		<form:input path="isbn" type="number" name="isbn"/>
		<span>Author:</span>
		<form:select path="id_author">
			<c:forEach var="author" items="${authors}">
			<form:option value="${author.id_auth}">${author.name}</form:option>
			</c:forEach>
		</form:select>
		<input type="submit"/>
		
		
	</form:form>
</body>
</html>