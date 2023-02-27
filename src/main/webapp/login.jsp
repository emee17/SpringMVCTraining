<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is the Login</title>
</head>
<body>
	<h1> Login Page </h1>
	<div>${error_message}</div>
	
	<form action="/SpringMVCTraining/logintoapp" method="post">  
    	Email:<input type="text" name="email"/>
    <br/><br/>  
    	Password:<input type="password" name="password"/>
    <br/><br/>  
    <input type="submit" value="Login"/>  
    </form>  
    
</body>
</html>