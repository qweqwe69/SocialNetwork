<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add fistname</title>
</head>
<body>
	<form method="post" action="?${_csrf.parameterName}=${_csrf.token}">
		<input name="nameUser" type="text" /> 
		<input type="submit" value="add" />
	</form>
	<table>
		<c:forEach var="firstname" items="${firstnames}">
			<tr>
				<td>${firstname.nameUser}</td>
				<c:url value="/firstname/${firstname.id}" var="url"/>
				<td><a href="${url}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>