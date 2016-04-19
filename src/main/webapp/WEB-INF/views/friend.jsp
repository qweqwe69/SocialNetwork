<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/search" var="search"/>
	<br> <a href="${search}">Search</a>
	<c:url value="/followers" var="followers"/>
	<br> <a href="${followers}">Followers</a>
	<br>
	friend
	
	<c:forEach var="friend" items="${friends}">
    	<p>${friend.lastName}</p>
	</c:forEach>
		
</body>
</html>