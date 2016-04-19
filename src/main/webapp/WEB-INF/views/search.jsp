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
	Search
	<table>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>
					<c:url value="/profile/${user.id}" var="url"/>
					<td>
						<c:if test="${user.id ne userId}">
   							<a href="${url}">
								${user.firstName.nameUser} 
								${user.lastName}
							</a>
						</c:if>
					</td>
					<c:url value="/profile/${user.id}" var="url"/>
					<security:authorize 
					access="isAuthenticated() and principal.username!='${user.id}' and !hasRole('ROLE_ADMIN')">
       					<td>
							<c:url value="/addApplicationFriend/${user.id}" var="appFriend"/>
							<a href="${appFriend}">Add to friend</a>
							
							<c:url value="/message/${user.id}" var="sendMessage"/>
							<a href="${sendMessage}">Send message</a>
						</td>
    				</security:authorize>
			</tr>
		</c:forEach>
	</table>
</body>
</html>