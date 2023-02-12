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
	<form:form action="/listBooks" method="post" modelAttribute="search">
		<span>Search:</span>
		<form:input path="search" type="text" name="search" />
		<input type="submit" />
	</form:form>
	<br>
	<br>
	<table>
		<tr>
			<th>Title</th>
			<th>isbn</th>
			<th>Author</th>
		</tr>
		<c:forEach var="item" items="${books}">
			<tr>
				<td>${item.title}</td>
				<td>${item.isbn}</td>
				<td>${item.nom_author}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>