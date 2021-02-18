<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
	<div>
		<form:form action="/searchBook" method="post" modelAttribute="book">
			<span>Find by title:</span>
			<form:input type="text" path="title" />
			<span>Find by ISBN:</span>
			<form:input type="text" path="isbn" />
			<span>Find by author:</span>
			<form:input type="text" path="author" />
			<input type="submit" value="search">
		</form:form>
		<table>
			<tr>
				<th>Title</th>
				<th>ISBN</th>
				<th>Author</th>
			</tr>
			<c:forEach items="${list}" var="book">
				<tr>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.isbn}" /></td>
					<td><c:out value="${book.author}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>