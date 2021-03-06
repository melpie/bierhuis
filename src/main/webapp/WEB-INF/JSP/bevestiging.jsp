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

	<h1>Je winkelwagentje is bevestigd als bestelbon ${bestelBon.id}.</h1>
	
	<h3>Bieren:</h3>
	
	<c:forEach var="bestelBonLijn" items="${bestelBonLijnen}">
	${bestelBonLijn.bier.naam} (${bestelBonLijn.aantal}) <br>
	</c:forEach>
	
	<h3>Op naam van:</h3>
	
	${bestelBon.naam}<br>
	${bestelBon.straat} ${bestelBon.huisNr}<br>
	${bestelBon.postcode} ${bestelBon.gemeente}	

</body>
</html>