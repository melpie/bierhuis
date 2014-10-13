<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='security'	uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!doctype html>
<html lang='nl'>
<head>
<title>Aanmelden</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css'>
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp" />
	<h1>Aanmelden</h1>
	<form method='post'>
		<label>Gebruikersnaam:<input name='username' autofocus></label>
		<label>Paswoord:<input name='password' type='password'></label>
		<security:csrfInput />
		<input type='submit' value='Aanmelden'>
	</form>
	<h1>Nieuwe Gebruiker</h1>
	<c:url value='/nieuwegebruiker' var='url' />
	<form:form action="${url}" method='get'>
		<input type='submit' value='Niewe gebruiker toevoegen'>
	</form:form>
</body>
</html>