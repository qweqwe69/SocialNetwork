<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add country</title>
</head>
<body>
	<form method="post" action="?${_csrf.parameterName}=${_csrf.token}">		
		<input name="nameCountry" type="text" /> 
		<input type="submit" value="add" />
	</form>
	<table>
		<c:forEach var="country" items="${countries}">
			<tr>
				<td>${country.nameCountry}</td>
				<c:url value="/country/${country.id}" var="url"/>
				<td><a href="${url}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>