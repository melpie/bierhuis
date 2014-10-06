<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<!doctype html>
<html lang='nl'>
<head>
<title>${bier.naam}</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css'>
</head>
<body>

	<c:import url="/WEB-INF/JSP/menu.jsp" />

	<h1>${bier.naam}</h1>

	<b>Alcohol</b><br>
	${bier.alcohol}%<br><br>
	<b>Prijs</b><br>
	${bier.prijs} euro<br><br>
	<b>Soort</b><br>
	${bier.soort.naam}<br><br>
	<b>Brouwer</b><br>
	${bier.brouwer.naam}<br><br>
	
</body>
</html>