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
<form:form action="/listAuthors" method="post" modelAttribute="search">
		<span>Search:</span>
		<form:input path="search" type="text" name="search"/>
		<input type="submit"/>
	</form:form>
<br><br>
	<table>
	<tr>
		<th>Name</th>
		<th>Birthday</th>
	</tr>
	<c:forEach var="item" items="${authors}">
	<tr>
		<td>
		${item.name}
		</td>
		<td>
		${item.birthday}
		</td>
	</tr>
	</c:forEach>
	</table>
	
	
</body>
</html>