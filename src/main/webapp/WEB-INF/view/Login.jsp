<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta charset="ISO-8859-1">
<title>Login Here</title>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>
p{
border : 1px solid powderblue;
margin : 
}
</style>
</head>
<body>
<h1 align="center">Login</h1>
<div align="center">

<form class="form-horizontol" action="perform_login"  method="post">
<table>
<tr>
<td><label for="username">Name:</label></td>
<td><p><input type="text"  name="username" placeholder="Enter Name" /></p></td>
</tr>
<tr>
<td><label for="password">Password:</label></td>
<td><p><input type="password" name="password" placeholder="Enter Password"  /></p></td>
</tr>
</table>
<div align="center">
<button type="submit" class="btn btn-primary">Login</button>
 </div> 
New User? <a href=Register>Register Here</a>
</form>
</div>  
${error}  
</body>
</html>
