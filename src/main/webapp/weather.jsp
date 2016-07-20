<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weather</title>
</head>
<body>
	<h1>Weather</h1>
	<p>
	Temperature: <%= request.getAttribute("temp") %><br>
	${temp}
	Temperature: <c:out value="${param.temp}"/>
	</p>
</body>
</html>