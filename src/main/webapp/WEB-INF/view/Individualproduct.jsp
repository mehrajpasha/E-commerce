 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="padding-top: 80px">

	 <div class="container">
		<c:forEach items="${IndividualProduct}" var="product1">
			<div class="col-xs-6 ">
				<div class="img">
					<img alt="${product1.id}"  height="200px" width="200px"			
							src="<c:url value="/resources/images/product/${product.id}.jpg"></c:url>">
					<div class="desc">
						<strong>${product1.name}</strong>
					</div>
				</div>
			</div> 
			

			<div class="col-xs-6 ">
				<div class="img">
					<div class="desc">
						<p>
						<div class="form-group">
							<input
								type="text" class="form-control" value="${product1.name}"
								readonly="readonly">
						</div>
						
						<div class="form-group">
							 <input type="text"
								class="form-control" value="Rs. ${product1.price}"
								readonly="readonly">
						</div>
						
						<div class="form-group">
							<input type="text" class="form-control btn-block"
								value="${product1.description}" readonly="readonly">
						</div>
						<form action="addtocart/${userid}/${product.id}">
										<input type="number" value="1" name="quantity"
											class=" form-control  btn-block  "> 
											<br><input
											type="submit" value="Add to Cart"
											class="btn btn-xs btn-default btn-block">
									</form>
							</div>
				</div>
			</div> 


		 </c:forEach>
	 </div> 

</body>
</html>

						
	 