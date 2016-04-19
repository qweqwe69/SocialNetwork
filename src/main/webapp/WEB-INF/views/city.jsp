<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add city</title>
</head>
<body>
	<sf:form method="post" modelAttribute="user" action="?${_csrf.parameterName}=${_csrf.token}">
	<select name="countryId">
		<c:forEach var="country" items="${countries}">
			<option value = "${country.id}">
			${country.nameCountry}</option>
		</c:forEach>
	</select>
		<input name="nameCity" type="text" /> 
		<input type="submit" value="add" />
	</sf:form>
	<table>
		<c:forEach var="city" items="${cities}">
			<tr>
				<td>${city.country.nameCountry}</td>
				<td>${city.nameCity}</td>
				<c:url value="/city/${city.id}" var="url"/>
				<td><a href="${url}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>