<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Uspesno ste se ulogovali
	<form action="BlogServlet" method="post">
		Tekst <input type="text" name="text"> <select
			name="idKategorije">
			<c:forEach items="${ listaKategorija }" var="item">
				<option value="${item.id }">${item.naziv }</option>
			</c:forEach>
		</select> Broj lajkova <input type="text" name="likesNo">
		<button type="submit">Save</button>
	</form>
<a href="/BlogWEB/pretraga.jsp">Link za pretragu</a>
</body>
</html>