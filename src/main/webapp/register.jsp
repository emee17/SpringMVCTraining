<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is the home JSP</title>
</head>
<body>
	<div>
		<form action="/SpringMVCTraining/student" method="post">
			
			Name: 
			<input type="text" name="name" id="name">
			
			Email: 
			<input type="text" name="email" id="email">
			
			Password: 
			<input type="text" name="password" id="password">
			
			Age: 
			<input type="text" name="age" id="age">
			
			<input type="submit" value="Register">
		
		</form>
	
	</div>
	
	<a href="/SpringMVCTraining/login">Go to Login Page</a>
</body>
</html>