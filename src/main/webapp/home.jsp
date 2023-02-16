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
	<h1> Home </h1>
	<h5>${message}</h5>
	
	${student.id}
	${student.name}
	${student.age}
	
	<a href="/SpringMVCTraining/login">Go to Login Page</a>
	<a href="/SpringMVCTraining/register">Go to Register Page</a>
</body>
</html>