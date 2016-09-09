<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td,tr, th {
    border: 1px solid #dddddd;
    text-align: center;
    padding: 8px;
}
</style>
</head>
<body>

${msg1}
<c:url var="editaction" value="editsupplier"></c:url>
<form:form action="${editaction}" modelAttribute="supplier">
		<c:choose>
		<c:when test="${supplier.id gt 0}" >
	    ID:<form:input path="id" readonly="true"/>
	    </c:when></c:choose>
	    Name:<form:input path="name" />
        Address:<form:input path="address" />
		<input type="submit" value="save">
</form:form>
${msg}
<div align="center">
<table style="width:80%">
<caption>Suppliers</caption>
<thead>
<tr>
<th>Supplier Id</th>
<th>Supplier Name</th>
<th>Supplier Address</th>
<th>Edit</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<c:forEach items="${supplierList}" var ="supplier">
<tr>
<td><c:out value="${supplier.id}"/>
<td><c:out value="${supplier.name}"/>
<td><c:out value="${supplier.address}"/>
<td><a href="addeditsupplier/${supplier.id }">edit</a>
<td><a href="adddeletesupplier/${supplier.id }">delete</a>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>