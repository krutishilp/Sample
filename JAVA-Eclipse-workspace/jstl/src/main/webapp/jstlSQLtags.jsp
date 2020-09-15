<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m"%>
<%@page isELIgnored="false"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:setDataSource var="db" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/javafs" user="root" password="root" />

	<c:query dataSource="${db}" var="rs">
	select * from login
</c:query>
	<m:out value="${rs.rows}"></m:out>
	<m:forEach var="table" items="${rs.rows}">
		<br>
		<m:out value="${table.userName}"></m:out>
		<m:out value="${table.password}"></m:out>
		<br>
	</m:forEach>

	<m:set var="name" value="Ram" />
	<c:update dataSource="${db}" var="count">  
DELETE FROM login WHERE userName = ?  
 <c:param value="${name}" />
	</c:update>
	<m:out value="After Deletetion ie c:update"></m:out>
	<c:query dataSource="${db}" var="rs">
	select * from login
</c:query>
	<m:forEach var="table" items="${rs.rows}">
		<br>
		<m:out value="${table.userName}"></m:out>
		<m:out value="${table.password}"></m:out>
		<br>
	</m:forEach>


</body>
</html>