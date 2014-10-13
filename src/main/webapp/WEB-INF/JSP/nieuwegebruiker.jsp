<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='security'	uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!doctype html>
<html lang='nl'>
<head>
<title>Nieuwe gebruiker</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css'>
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp" />
	<h1>Nieuwe Gebruiker</h1>
	<c:url value='/nieuwegebruiker' var='url' />
	<form:form action="${url}" commandName='user' method='post'>
		<form:label path='username'>
			<b>Gebruikersnaam</b> <form:errors path='username' class='fout'/>
		</form:label>
		<br>
		<form:input path='username' autofocus='true' />
		<br>
		<form:label path='password'>
			<b>Paswoord</b> <form:errors path='password' class='fout'/>
		</form:label>
		<br>		
		<form:input path='password' autofocus='true' />
		<form:input path='enabled' value="1" type="hidden"/>
		<br>
		<form:label path='naam'>
			<b>Naam</b> <form:errors path='naam' class='fout'/>
		</form:label>
		<br>
		<form:input path='naam' autofocus='true' />
		<br>
		<form:label path='straat'>
			<b>Straat</b> <form:errors path='straat' class='fout'/>
		</form:label>
		<br>
		<form:input path='straat' autofocus='true' />
		<br>
		<form:label path='huisnummer'>
			<b>Huisnummer</b> <form:errors path='huisnummer' class='fout'/>
		</form:label>
		<br>
		<form:input path='huisnummer' autofocus='true' />
		<br>
		<form:label path='postcode'>
			<b>Postcode</b> <form:errors path='postcode' class='fout'/>
		</form:label>
		<br>
		<form:input path='postcode' autofocus='true' />
		<br>
		<form:label path='gemeente'>
			<b>Gemeente</b> <form:errors path='gemeente' class='fout'/>
		</form:label>
		<br>
		<form:input path='gemeente' autofocus='true' />
		<br>
		<input type='submit' value='Toevoegen'>
	</form:form>
</body>
</html>