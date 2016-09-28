<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/table1.css" />">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>

	<div class="text-center myForm">
		<c:url var="action" value="editproduct"></c:url>
		<form:form action="${action}" modelAttribute="product"
			enctype="multipart/form-data" method="post">
			<table>
				<c:choose>
					<c:when test="${product.id gt 0}">
						<tr>
							<td>ID:</td>
							<td><form:input class="input1" path="id" readonly="true" /></td>
						</tr>
					</c:when>
				</c:choose>
				<tr>
					<td>Name:</td>
					<td><form:input class="input1" path="name" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:input class="input1" path="description" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input class="input1" path="price" /></td>
				</tr>
				
				<tr>
				<td>Category:</td>
				<td><form:select path="categoryid" required="true">
				<c:forEach items="${categoryList}" var="category">
								<form:option class="input1" value="${category.id}">${category.name}</form:option>
							</c:forEach>
								</form:select></td>
								<tr>
								<td>Supplier:</td>
				<td><form:select path="suppliername" required="true">
				<c:forEach items="${supplierList}" var="supplier">
								<form:option class="input1" value="${supplier.name}">${supplier.name}</form:option>
							</c:forEach>
								</form:select></td></tr>
								
											<tr>
								
				
								
								
				<tr>
					<td>Image:</td>
					<td><form:input type="file"
							class=" btn btn-default btn-block form-control" path="image"
							required="true" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" class="btn btn-primary" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div align="center">
		<table class="table" style="width: 100%">
			<caption>Products</caption>
			<thead>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th>Supplier</th>
					<th>Category</th>
					<th>Image</th>
					<th>Edit</th>
					<th>Delete</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td><c:out value="${product.id}" />
						<td><c:out value="${product.name}" />
						<td><c:out value="${product.description}" />
						<td><c:out value="${product.price}" />
						<td><c:out value="${product.suppliername}" />
						<td><c:out value="${product.categoryid}"/>
						<td><div class="thumbnail">
								<img height="100px" width="100px" alt="${product.id }"
									src="<c:url value="/resources/images/product/${product.id }.jpg"></c:url>">
							</div>
						<td><a href="addeditproduct/${product.id }">edit</a>
						<td><a href="adddeleteproduct/${product.id }">delete</a>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	
</body>
</html>