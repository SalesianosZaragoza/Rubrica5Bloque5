<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authors</title>
</head>
<body>
	<div>
		<form:form id="author" action="/searchAuthor" method="post"
			modelAttribute="author">
			<span>Find by name:</span>
			<form:input type="text" path="name" />
			<span>Find by birthday:</span>
			<form:input id="date" type="date" path="birthday" />
			<input type="submit" value="search">
		</form:form>
		<table>
			<tr>
				<th>Name</th>
				<th>Birthday</th>
			</tr>
			<c:forEach items="${list}" var="author">
				<tr>
					<td><c:out value="${author.name}" /></td>
					<td><c:out value="${author.birthday}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>