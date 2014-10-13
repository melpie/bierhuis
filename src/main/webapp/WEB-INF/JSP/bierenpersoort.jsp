<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!doctype html>
<html lang='nl'>
<head>
<title>${bieren[0].soort.naam}</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css'>
<link rel='stylesheet' href='//cdn.datatables.net/1.10.3/css/jquery.dataTables.min.css'>
</head>
<body>

	<c:import url="/WEB-INF/JSP/menu.jsp" />

	<c:choose>

		<c:when test="${not empty fout}">
			<p class="fout">
				${fout}
			</p>
		</c:when>

		<c:otherwise>
	
			<h1>${bieren[0].soort.naam}</h1>
		
			<table id="bieren" class='opsomming'>
			
			<thead>
			<tr role="row">
			<th class="sorting_asc" tabindex="0" rowspan="1" colspan="1" style="width: 150px;">Bier</th>
			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="width: 20px;">Brouwer</th>
			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="width: 20px;">Soort</th>
			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="width: 10px;">Alcohol</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items='${bieren}' var='bier'>
					<spring:url var='bierURL' value='/bieren/{id}'>
						<spring:param name='id' value='${bier.id}' />
					</spring:url>
					<spring:url var='brouwerURL' value='/brouwers/{id}'>
						<spring:param name='id' value='${bier.brouwer.id}' />
					</spring:url>
					<tr>
						<td align="center"><a href='${bierURL}'>${bier.naam}</a></td>
						<td align="center"><a href='${brouwerURL}'>${bier.brouwer.naam}</a></td> 
						<td align="center"> ${bier.soort.naam} </td> 
						<td align="center"> ${bier.alcohol}% </td>
					</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			
		</c:otherwise>

	</c:choose>

</body>

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.10.3/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function(){
    $('#bieren').DataTable();
});
</script>

</html>