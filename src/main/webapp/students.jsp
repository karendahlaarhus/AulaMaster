<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>AulaMaster</title>
</head>
<body>
<%@page import="java.util.*, beans.*, dao.*"%>   
<h1>Student Administration</h1> 

<form id="addStudentForm" action="addStudent" method="post">  
	NIE:<input type="text" name="nie" required="required"/><br/><br/>  
	Firstname: <input type="text" name="firstname" required="required"/><br/><br/>  
	Surname: <input type="text" name="surname" required="required"/><br/><br/>
	Date of birth: <input type="date" name="birthdate" required="required"/><br/><br/> 	
	<input type="submit" value="Add Student"/> 
</form>

<% List<Student> students = StudentDao.getStudents();
request.setAttribute("students", students);%>

<table>
	<tr>
		<th> NIE </th>
		<th> Name </th>
		<th> Surname </th>
		<th> Date of birth (yyyy-mm-dd)</th>
	</tr>
	<c:forEach items="${students}" var="student">
	<tr>
		<th> ${student.getNie()} </th>
		<th> ${student.getName()} </th>
		<th> ${student.getSurname()} </th>
		<th> ${student.getBirthdate()} </th>
	</tr>
	</c:forEach>
</table>
 
</body>
</html>