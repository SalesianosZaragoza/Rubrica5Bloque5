<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 20/12/21
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Create Libro</title>
</head>
<body>
<form:form action="/libro/create" method="post">
	<label>
		<input type="text" name="titulo">
	</label>
	<label>
		<input type="text" name="isbn">
	</label>
	<label>
		<select name="autorID">
			<jsp:useBean id="autores" scope="request" type="java.util.List"/>
			<c:forEach var="autor" items="${autores}">
				<option value="${autor.ID}">${autor.nombre}</option>
			</c:forEach>
		</select>
	</label>
	<input type="submit" value="Send">
</form:form>
</body>
</html>
