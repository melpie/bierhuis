<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!doctype html>
<html lang='nl'>
<head>
<title>${bier.naam}</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css'>
</head>
<body>

	<c:import url="/WEB-INF/JSP/menu.jsp" />

	<c:choose>

		<c:when test="${not empty fout}">
			<p class="fout">${fout}</p>
		</c:when>

		<c:otherwise>

			<spring:url var='brouwerURL' value='/brouwers/{id}'>
				<spring:param name='id' value='${bier.brouwer.id}' />
			</spring:url>
			<spring:url var='soortURL' value='/soort/{id}'>
				<spring:param name='id' value='${bier.soort.id}' />
			</spring:url>

			<h1>${bier.naam}</h1>

			<b>Alcohol</b>
			<br>
			${bier.alcohol}%
			<br>
			<br>
			<b>Prijs</b>
			<br>
			${bier.prijs} euro
			<br>
			<br>
			<b>Soort</b>
			<br>
			<a href='${soortURL}'>${bier.soort.naam}</a>
			<br>
			<br>
			<b>Brouwer</b>
			<br>
			<a href='${brouwerURL}'>${bier.brouwer.naam}</a>
			<br>
			<br>
			<c:url value='/winkelwagen' var='url'/>
			<form:form action="${url}" commandName='bierAantal' method='post'>
				<form:label path='aantal'>
					<b>Aantal</b> <form:errors path='aantal' class='fout'/>
				</form:label>
				<br>
				<form:input path='aantal' autofocus='true'/>
				<form:input path='bierId' value="${bier.id}" type="hidden"/>
				<br>
				<input type='submit' value='Toevoegen'>
			</form:form>

		</c:otherwise>
		
	</c:choose>

</body>
</html>