<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<!doctype html>
<html lang='nl'>
<head>
<title>Brouwers</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css'>
</head>
<body>

	<c:import url="/WEB-INF/JSP/menu.jsp" />

	<h1>Brouwers</h1>

	<ul class='opsomming'>
		<c:forEach items='${brouwers}' var='brouwer'>
			<spring:url var='url' value='/brouwers/{id}'>
				<spring:param name='id' value='${brouwer.id}' />
			</spring:url>
			<li>
				<a href='${url}'>${brouwer.naam} (${brouwer.gemeente})</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>