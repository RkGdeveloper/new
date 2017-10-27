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
	<table align = "center" style='font-family:"Courier New", Courier, monospace; font-size:120%'>
		<tr>
			<td colspan = "5"><h1 align = "center">Customer  list Information.</h1></td>
		</tr>
		<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>MOBILE</th>
		<th>EMAIL</th>
		<th>DOB</th>
		</tr>
		<c:forEach items = "${list}" var = "list">
			<tr>
				<td><c:out value="${list.custId}"></c:out></td>
				<td><c:out value="${list.custName}"></c:out></td>
				<td><c:out value="${list.mobile}"></c:out></td>
				<td><c:out value="${list.email}"></c:out></td>
				<td><c:out value="${list.birthDate}"></c:out></td>
			</tr>
		</c:forEach>
	</table> 
	
	<h2 align = "center"><a href = "index.obj">Go back to home</a></h2>
</body>
</html>