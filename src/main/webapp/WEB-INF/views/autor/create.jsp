<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Create</title>
</head>
<body>
<%--@elvariable id="autor" type="com.kerjox.rubrica5bloque5.entities.Autor"--%>
<form:form action="/autor/create" method="post" modelAttribute="autor">
	<label>
		<input type="text" name="nombre">
	</label>
	<label>
		<input type="date" name="fNac">
	</label>
	<input type="submit" value="Send">
</form:form>
</body>
</html>
