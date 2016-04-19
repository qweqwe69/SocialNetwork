<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Followers</title>
</head>
<body>
	followers
	<br>
	<c:forEach var="appFriends" items="${appFriends}">
		<tr>
			<td>
				<c:url value="/profile/${appFriends.appSender.id}" var="url"/>
					<td>
   						<a href="${url}">
							${appFriends.appSender.firstName.nameUser} 
							${appFriends.appSender.lastName}
							<br>
						</a>
					</td>
				<c:url value="/profile/${user.id}" var="url"/>
       				<td>
						<c:url value="/acceptToFriend/${appFriends.appSender.id}" var="aceptToFriend"/>
						<a href="${aceptToFriend}">Accept</a>
							
						<c:url value="/rejectApp/${user.id}" var="rejectApp"/>
						<a href="${rejectApp}">Reject</a>
					</td>
		</tr>
		<br>
	</c:forEach>
</body>
</html>