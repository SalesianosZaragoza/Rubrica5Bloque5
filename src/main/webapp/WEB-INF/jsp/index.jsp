<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>

	</head>
	
	<body>
		<form:form action="insertAuthor" method="get" modelAttribute="author">
			<form:input type="text" name="name" path="name"  />
			<input type="submit" value="Submit"/>     
		</form:form>
	</body>
</html>
