<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><spring:message code="login.title"/></h1>
Language: <a href="?language=en">English</a> | <a href="?language=es">Spanish</a>
<form:form commandName="userLogin">
<table>
	<tr>
		<td><spring:message code="login.username"/></td>
		<td><form:input path="userName"/></td>
	</tr>
	<tr>
		<td><spring:message code="login.password"/></td>
		<td><form:password path="password"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Click Enter"></td>
	</tr>
</table>
</form:form>
</body>
</html>