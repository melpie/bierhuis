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

	<c:choose>
	
	<c:when test="${winkelwagen.size() < 1}">
		Uw winkelwagen is leeg.
	</c:when>

	<c:otherwise>	

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
	
	<c:url value='/winkelwagen' var='url' />
	<form:form action="${url}" method='post'>
		<input type='submit' value='Bestelling bevestigen'>
	</form:form>
	
	</c:otherwise>
	
	</c:choose>

</body>
</html>