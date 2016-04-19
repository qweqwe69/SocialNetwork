<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<form method="post" action="?${_csrf.parameterName}=${_csrf.token}">
			<a href="registration">Registration</a>
			<br> 
			<a href="login">Login</a>
			<br> 
	</form>
</body>
</html>
<!-- http://liminspace.com/author/liminspace, engineX, spring boot, sololearn -->