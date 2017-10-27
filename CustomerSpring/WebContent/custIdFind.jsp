<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
   <%--  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> --%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>


<div align = "center">
	<div class="dropdown">
	  <button class="dropbtn">select ID</button>
	  	<div class="dropdown-content">
	  		<c:forEach items = "${idList}" var = "list">
	    		<a href="find.obj?customerid=${list}"><c:out value="${list}"></c:out></a>
	    	</c:forEach>
	    </div>
	</div>
</div>





<%-- 
<form action = "find.obj">
<table align = "center">
	<tr>
		<th>Enter Id:</th>
	</tr>
	<tr>
		<td>

			<select id="customerId"  name = "customerId">
			
			<c:forEach items = "${idList}" var = "list">
				<option><c:out value="${list}"></c:out></option>
			</c:forEach>
					
			</select>
		</td>
	</tr>

	<tr><td><input type = "submit" value = "submit"/></td></tr>
</table>
</form> --%>



</body>
</html>