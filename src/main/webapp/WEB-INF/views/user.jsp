<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add user</title>
</head>
<body>
	<sf:form method="post" modelAttribute="user" action="${url}?${_csrf.parameterName}=${_csrf.token}">
	City: <sf:select path="cities">
				<c:forEach var="city" items="${cities}">
					<sf:option value="${city.id}">${city.nameCity}</sf:option>
				</c:forEach>
			</sf:select>
	<br>
	First Name: <sf:select path="firstName">
						<c:forEach var="firstname" items="${firstnames}">
							<sf:option value="${firstname.id}">${firstname.nameUser}</sf:option>
						</c:forEach>
				</sf:select>
	<br>
	Sex:<sf:select path="sex">
						<sf:option value="MALE">Male</sf:option>
						<sf:option value="FEMALE">Female</sf:option>
				</sf:select>
		<br>
		Last name: <sf:input path="lastName"/>
		<br>
		Email: <sf:input path="email"/>
		<br>
		Password: <sf:input path="password"/> 
		<br>
		Phone: <sf:input path="phone"/>
		<br>
		<input type="submit" value="Add admin" />
	</sf:form>
	<table>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.lastName}</td>
				<c:url value="/user/${user.id}" var="url"/>
				<td><a href="${url}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>