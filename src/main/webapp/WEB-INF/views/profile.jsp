<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	profile
	<security:authorize
        access="isAuthenticated() and principal.username=='${user.id}'">
        <c:url value="/friend" var="friend"/>
		<br> <a href="${friend}">Friends</a>
		
		<c:url value="/message" var="message"/>
		<br> <a href="${message}">Message</a>
    </security:authorize>
	<security:authorize
        access="isAuthenticated() and principal.username!='${user.id}' and !hasRole('ROLE_ADMIN')">
        <td>
			<c:url value="/addApplicationFriend/${user.id}" var="appFriend"/>
			<a href="${appFriend}">Add to friend</a>
		</td>
    </security:authorize>
</body>
</html>