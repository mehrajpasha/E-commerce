<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1 align="center">Login</h1>
<div align="center">
<c:url var="action" value="adduser"></c:url>
<form:form action="${action}" modelAttribute="userdetails">
<table>
<tr><td>Username:</td><td><form:input path="username" required="true" /></td></tr>
<tr><td>Password:</td><td><form:input path="password" required="true" /></td></tr>
<tr><td>E-mail:</td><td><form:input path="mail" required="true" /></td></tr>
<tr><td>Mobile:</td><td><form:input path="contact" required="true" /></td></tr>
<tr><td>Address:</td><td><form:input path="address" required="true" /></td></tr>
</table>
<div align="center">
<tr><td></td><td><input type="submit" value="Register"/></td></tr>
</div>
</div>

</form:form>
${register}
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta charset="ISO-8859-1">
<title>Login Here</title></head>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>
p{
border : 1px solid powderblue;
margin : 
}
</style>
</head>
<body>
<h1 align="center">Register</h1>
<div align="center">
<c:url var="action" value="adduser"></c:url>
<form class="form-horizontol" action="${action}" modelAttribute="userdetails"  >
<table>
<tr>
<td><label for="username">Username:</label></td>
<td><p><input type="text" path="username" name="username"placeholder="Enter Name" /></p></td>
</tr>
<tr>
<td><label for="password">Password:</label></td>
<td><p><input type="text" path="password" name="password" placeholder="Enter Password" /></p></td>
</tr>
<tr>
<td><label for="mail">E-mail:</label></td>
<td><p><input type="text" path="mail" name="mail" placeholder="Enter E-mail" /></p></td>
</tr>
<tr>
<td><label for="contact">Mobile:</label></td>
<td><p><input type="text" path="contact" name="contact" placeholder="Enter Mobile" /></p></td>
</tr>
<tr>
<td><label for="address">Address:</label></td>
<td><p><input type="text" path="address" name="address" placeholder="Enter Address" /></p></td>
</tr>
</table>
<div align="center">
<button type="submit" class="btn btn-primary">Register</button>
 </div> 
</form>
</div>
${register}
  <script src="bootstrap/js/bootstrap.min.js"></script>  
</body>
</html>
