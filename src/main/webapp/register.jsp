<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is the home JSP</title>
</head>
<body>
	<div>
	${student.name}
	<form:form modelAttribute="student" action="/SpringMVCTraining/student" method="post">
		<table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:input path="password"/></td>
                </tr>
                <tr>
                    <td><form:label path="age">Age</form:label></td>
                    <td><form:input path="age"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
	</form:form>
		
	
	</div>
	
	<a href="/SpringMVCTraining/login">Go to Login Page</a>
</body>
</html>