<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<!doctype html>
<html lang='nl'>
<head>
<title>Brouwers</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css'>
<link rel='stylesheet' href='//cdn.datatables.net/1.10.3/css/jquery.dataTables.min.css'>
</head>
<body>

	<c:import url="/WEB-INF/JSP/menu.jsp" />

	<h1>Brouwers</h1>

	<table id="brouwers" class='opsomming'>
	<thead>
	<tr role="row">
	<th class="sorting_asc" tabindex="0" rowspan="1" colspan="1" style="width: 150px;">Brouwer</th>
	<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="width: 20px;">Gemeente</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach items='${brouwers}' var='brouwer'>
			<spring:url var='url' value='/brouwers/{id}'>
				<spring:param name='id' value='${brouwer.id}' />
			</spring:url>
			<tr>
				<td align="center">
					<a href='${url}'>${brouwer.naam}</a>
				</td>
				<td align="center">
					${brouwer.gemeente}
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</body>

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.10.3/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function(){
    $('#brouwers').DataTable();
});
</script>

</html>