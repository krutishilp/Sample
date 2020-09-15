<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP</title>
</head>
<body>
	<%
		response.setContentType("text/html");
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	%>

	<h5>JSP Expression Tag</h5>
	Time:
	<%="  " + java.util.Calendar.getInstance().getTime()%>
	<h3>
		Welcome<%="  " + userName%></h3>

	<h5>JSP Scriptlet Tag</h5>
	<%
		if (userName.equals("Zensar") && password.equals("Zensar")) {
		out.println("<h2>Authentication Successful</h2>");
	} else {
		out.println("<h2>Authentication Failed</h2>");
	}
	%>

	<h5>JSP Declaration Tag</h5>

	<%!int cube(int x) {
		return x * x * x;
	}%>

	<h4>
		Cube:
		<%=cube(3)%></h4>
</body>
</html>