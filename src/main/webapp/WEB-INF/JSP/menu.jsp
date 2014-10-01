<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<ul class="menu">
		<c:url value="/" var="welkomURL" />
		<c:url value="/brouwers" var="brouwersURL" />
		<c:url value="/winkelwagen" var="winkelwagenURL" />
		<li><a href="<c:out value='${welkomURL}'/>">Welkom</a></li>
		<li><a href="<c:out value='${brouwersURL}'/>">Brouwers</a></li>
		<li><a href="<c:out value='${winkelwagenURL}'/>">Winkelwagen</a></li>
	</ul>
</div>