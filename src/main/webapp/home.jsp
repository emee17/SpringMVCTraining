<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is the home JSP</title>
</head>
<body>
	<h1>Home</h1>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Age</th>
			<th>Edit</th>
			<th>Delete ?</th>
		</tr>
		<c:forEach var="student" items="${studentList}">
			<tr>
				<td>${student.id}</td>	
				<td>${student.name}</td>
				<td>${student.email}</td>
				<td align="center">${student.age}</td>
				<td align="center"><a href="/SpringMVCTraining/edit/${student.id}">Edit</a></td>
				<td align="center"><a href="/SpringMVCTraining/student/delete/${student.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="/SpringMVCTraining/login">Go to Login Page</a>
	</br>
	<a href="/SpringMVCTraining/register">Go to Register Page</a>
</body>
</html>