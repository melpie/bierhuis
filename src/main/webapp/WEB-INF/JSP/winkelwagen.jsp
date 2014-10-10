<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!doctype html>
<html lang='nl'>
<head>
<title>Bieren</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css'>
</head>
<body>

	<c:import url="/WEB-INF/JSP/menu.jsp" />

	<h1>Winkelwagen</h1>

	<table>

		<thead>
			<tr>
				<th><b>Bier</b></th>
				<th><b>Prijs</b></th>
				<th><b>Aantal</b></th>
				<th><b>Te Betalen</b></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entry" items="${winkelwagen}">
				<tr>
					<td>${entry.key.naam}</td>
					<td>&euro; ${entry.key.prijs}</td>
					<td>${entry.value}</td>
					<td>&euro; ${entry.key.prijs * entry.value}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<br>
	<br>
	<c:url value='/winkelwagen' var='url' />
	<form:form action="${url}" commandName='bestelBonGegevens' method='get'>
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