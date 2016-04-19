<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
<sf:form method="post" modelAttribute="user" action="?${_csrf.parameterName}=${_csrf.token}">
		<table>
			<tr>
				<th>City*</th>
				<td><sf:select path="cities">
						<c:forEach var="city" items="${cities}">
							<sf:option value="${city.id}">${city.nameCity}</sf:option>
						</c:forEach>
				</sf:select></td>
			</tr>
			<tr>
				<th>First Name*</th>
				<td><sf:select path="firstName">
						<c:forEach var="firstname" items="${firstnames}">
							<sf:option value="${firstname.id}">${firstname.nameUser}</sf:option>
						</c:forEach>
				</sf:select></td>
			</tr>
			<tr>
				<th>Sex*</th>
				<td><sf:select path="sex">
						<sf:option value="MALE">Male</sf:option>
						<sf:option value="FEMALE">Female</sf:option>
				</sf:select></td>
			</tr>
			<tr>
				<th>Last name*</th>
				<td><sf:input path="lastName"/></td>
				<%-- <td><sf:errors path="lastName"></sf:errors></td> --%>
			</tr>
			<tr>
				<th>Email*</th>
				<td><sf:input path="email"/></td>
				<%-- <td><sf:errors path="email" cssClass="UniqueEmail"></sf:errors></td> --%>
			</tr>
			<tr>
				<th>Password*</th>
				<td><sf:input path="password"/></td>
				<%-- <td><sf:errors path="password"></sf:errors></td> --%>
			</tr>
			<tr>
				<th>Phone*</th>
				<td><sf:input path="phone"/></td>
				<%-- <td><sf:errors path="phone"></sf:errors></td> --%>
			</tr>
			<tr>
				<th>Place of work</th>
				<td><sf:input path="placeOfWork"/></td>
				<%-- <td><sf:errors path="placeOfWork"></sf:errors></td> --%>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="Enter" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>