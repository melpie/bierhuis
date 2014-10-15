<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>

<div>
	<ul class='menu'>
		<c:url value="/" var="welkomURL" />
		<c:url value="/brouwers" var="brouwersURL" />
		<c:url value="/bieren" var="bierenURL" />
		<c:url value="/winkelwagen" var="winkelwagenURL" />
		<li><a href="<c:out value='${welkomURL}'/>">Welkom</a></li>
		<li><a href="<c:out value='${brouwersURL}'/>">Brouwers</a></li>
		<li><a href="<c:out value='${bierenURL}'/>">Bieren</a></li>
		<security:authorize access='isAuthenticated()'>
			<li><a href="<c:out value='${winkelwagenURL}'/>">Winkelwagen</a></li>
		</security:authorize>
		<security:authorize access='isAnonymous()'>
			<li><a href="<c:url value='/login'/>">Aanmelden</a></li>
		</security:authorize>
	</ul>
</div>