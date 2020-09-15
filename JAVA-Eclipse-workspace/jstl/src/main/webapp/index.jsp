<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html>
<body>
	<h2>
		<c:out value="Hello JSTL"></c:out>
	</h2>
	<h2>
		<c:out value="c:import example"></c:out>
	</h2>
	<c:import var="info" url="https://zenloungeplus.zensar.com"></c:import>
	<c:out value="${info}"></c:out>

	<h2>
		<c:out value="c:set example (a+b)"></c:out>
	</h2>
	<c:set var="a" value="20"></c:set>
	<c:set var="b" value="30"></c:set>
	<c:out value="result of a+b= ${a+b}"></c:out>

	<h2>
		<c:out value="After c:remove var='a' example (a+b)"></c:out>
	</h2>
	<c:remove var="a" />
	<c:out value="result of a+b= ${a+b}"></c:out>

	<c:catch var="catchtheException">
		<%
			int x = 2 / 0;
		%>
	</c:catch>
	<h2>
		<c:out value="c:catch example"></c:out>
	</h2>
	<c:if test="${catchtheException != null}">
		<p>
			The type of exception is : ${catchtheException} <br /> There is an
			exception: ${catchtheException.message}
		</p>
	</c:if>
	<h2>
		<c:out value="c:if example"></c:out>
	</h2>
	<c:set var="income" value="10000"></c:set>
	<c:if test="${income==10000}">
		<p>
			My income is:
			<c:out value="${income}" />
		<p>
	</c:if>

	<h2>
		<c:out value="c:choose example"></c:out>
	</h2>
	<c:set var="income" scope="session" value="${4000*4}" />
	<p>
		Your income is :
		<c:out value="${income}" />
	</p>
	<c:choose>
		<c:when test="${income <= 1000}">  
       Income is not good.  
    </c:when>
		<c:when test="${income > 10000}">  
        Income is very good.  
    </c:when>
		<c:otherwise>  
       Income is undetermined...  
    </c:otherwise>
	</c:choose>
	<br>
	<h2>
		<c:out value="c:forEach example"></c:out>
		<br>
	</h2>
	<c:forEach var="i" begin="1" end="10">
		Item:<c:out value="${i} "></c:out>
		<p>
	</c:forEach>
	<h2>
		<c:out value="c:forTokens example"></c:out>
		<br>
	</h2>
	<c:forTokens items="Hello-I-am-Krutishil" delims="-" var="name">
		<c:out value="${name}"></c:out>
	</c:forTokens>

	<h2>
		<c:out value="c:url example with c:param"></c:out>
		<br>
	</h2>
	<c:url value="www.google.com">
		<c:param name="id" value="123"></c:param>
		<c:param name="pass" value="456"></c:param>
	</c:url>
<c:out value="c:redirect example with c:param"></c:out>
	<%-- <c:set var="url" value="0" scope="request" />
	<c:if test="${url<1}">
		<c:redirect url="http://javatpoint.com" />
	</c:if>
	<c:if test="${url>1}">
		<c:redirect url="http://facebook.com" />
	</c:if> --%>

</body>
</html>
