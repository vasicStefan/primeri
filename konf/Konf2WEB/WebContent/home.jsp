<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="KonfServlet" method="post">
	Naziv konferencije: <input type="text" name="naziv"><br>
	Drzava: <input type="text" name="drzava"><br>
	Grad: <input type="text" name="grad"><br>
	Oblast: <input type="text" name="oblast"><br>
	<input type="submit" value="Dalje">
</form>
</body>
</html>