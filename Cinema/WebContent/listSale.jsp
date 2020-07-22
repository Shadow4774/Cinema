<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class='t'>

		<tr class='head'>
			<th class='words'>Id Sala</th>
			<th class='words'>Titolo film</th>
			<th class='words'>tipo film</th>
			<th class='words'>spettatori</th>
			<th class='words'>Operation</th>
		</tr>
									
								
									<c:forEach items="${listaSale}" var="sala">
										
										<tr>
											
											<td class='block'>${sala.idSala }</td>
											<td class='block'>${sala.film.titolo }</td>
											<td class='block'>${sala.film.genere }</td>
											<td class='block'>${sala.spettatoriAttuali }</td>
											<td><a class='block'
												href="/CRUD-remake/ControlServlet?op=svuotaSala&id=<c:out value ="${sala.idSala }"/>">Svuota</a>
											</td>
										</tr>
									</c:forEach>
							</table>
</body>
</html>