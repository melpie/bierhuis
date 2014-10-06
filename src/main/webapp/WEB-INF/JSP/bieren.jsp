<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<!doctype html>
<html lang='nl'>
<head>
<title>Bieren</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css'>
</head>
<body>
	
	<c:import url="/WEB-INF/JSP/menu.jsp" />
	
	<h1>Alle bieren</h1>
	
	<ul class='opsomming'>
	<c:forEach items='${bieren}' var='bier'>
		<spring:url var='url' value='/bieren/{id}'>
			<spring:param name='id' value='${bier.id}' />
		</spring:url>
		<li>
			<a href='${url}'>${bier.naam} [${bier.alcohol}%]</a>
		</li>
	</c:forEach>
	</ul>
</body>
</html>