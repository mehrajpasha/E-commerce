<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style type="text/css">
h1 {
	height: 100px;
	width: 100%;
	background-color: #c3c3c3;
	text-align: center;
	padding-top: 20px;
}
body {
	color: #000;
	font: 14px Arial;
	margin: 0 auto;
	padding: 0;
	position: relative;
}

.container {
	padding:25px auto;
	margin: 25px auto;
	position: relative;
}

div.img {
	margin-left: 30px;
	border: 1px solid #ccc;
	float: left;
	padding:25px auto;
	width: 192px;
	margin-bottom:30px;
}

div.img:hover {
	border: 1px solid #777;
}

div.img img {
	width: 100%;
	height: auto;
}

div.desc {
	padding: 15px;

}
</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>
<style>
.dropdown-submenu {
	position: relative;
}

.dropdown-submenu .dropdown-menu {
	top: 0;
	left: 100%;
	margin-top: -1px;
}
</style>

</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">

		<ul class="nav navbar-nav">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"><span
					class="glyphicon glyphicon-th" align="right"></span></a>
				<ul class="dropdown-menu">
					<li><c:forEach items="${categoryList}" var="category">
							<a href="view/${category.id}"><c:out value="${category.name}" /><span
								class="glyphicon glyphicon-menu-right"></span></a>
							<br>
						</c:forEach></li>
				</ul></li>
		</ul>



		<ul class="nav navbar-nav navbar-right">
			<li><a href="Cart"> <span
					class="glyphicon glyphicon-shopping-cart"></span>
			</a> <sec:authorize access="isAuthenticated()">

					<li><a href="<c:url value="/perform_logout" />">Logout</a></li>
					<li><a href="">Welcome<sec:authentication
								property="principal.username" /></a></li>
				</sec:authorize> <sec:authorize access="!isAuthenticated()">
					<li><a href="Register"><span
							class="glyphicon glyphicon-user" id="register-form-link"></span>Sign Up</a></li>
					<li><a href="Login"><span
							class="glyphicon glyphicon-log-in" "login-form-link"></span> Login</a></li>
				</sec:authorize>
		</ul>
	</div>
	</nav>

	</div>



<!-- $(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

}); -->


	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="D:\pics\1.jpg" alt="Chania" width="400" height="300">
				</div>

				<div class="item">
					<img src="D:\pics\2.jpg" alt="Chania" width="400" height="300">
				</div>

				<div class="item">
					<img src="D:\pics\4.jpg" alt="Flower" width="400" height="300">
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>


	<div class="row"
		style="padding-top: 15px; padding-botton: 15px; padding-left: 15px; padding-bottom: 15px;">
		<c:forEach items="${Productlist}" var="product">
			<div class="col-xs-2 w3-animate-zoom">
				<div class="img">
					<img height="192px" width="192px" alt="${product.id}"
						src="<c:url value="/resources/images/product/${product.id}.jpg"></c:url>">
					<div class="desc w3-black" style="opacity: 0.9">
						<p>
							${product.name}<br> <i class="fa fa-inr" aria-hidden="true"></i>
							${product.price}
						</p>
					</div>
				</div>
			</div>
			<form action="addtocart/${product.id}/${userid}">
				<input type="submit" value="Add to Cart"
					class="btn btn-xs btn-success btn-block">
			</form>
		</c:forEach>
		</div>

		<%-- <ul style="margin: 50px">
			<c:forEach items="${categoryList}" var="category">

				<li><a href="/singlecategory/${category.id}">
						${category.name}</a></li>

			</c:forEach>
		</ul> --%>
		<c:choose>
			<c:when test="${IndividualItemClicked}">
				<c:import url="/WEB-INF/view/Individualproduct.jsp">
				</c:import>
			</c:when>

			<c:when test="${ViewCategoryClicked}">
				<c:import url="/WEB-INF/view/viewproduct.jsp">
				</c:import>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${UserclickedLogin}">
				<c:import url="/WEB-INF/view/Login.jsp"></c:import>
			</c:when>
		</c:choose>

		<c:choose>
			<%-- <c:when test="${UserClickedcart}">
		<c:import url="/WEB-INF/view/Cart.jsp"></c:import>
	</c:when> --%>
			<c:when test="${UserClickeduser}">
				<c:import url="/WEB-INF/view/Register.jsp"></c:import>
			</c:when>
			<c:when test="${cartClicked}">
				<c:import url="/WEB-INF/view/Cart.jsp"></c:import>
			</c:when>
		</c:choose>
</body>
<%-- <div class="container">
		<c:forEach items="${productList}" var="product">
			<div class="col-xs-3 w3-animate-zoom">
				<div class="img"><a href="IndividualItem/${product.id}">
					<img height="220px" width="22px" alt="${product.id}" 
						src="<c:url value="/resources/images/product/${product.id}.jpg"></c:url>">
					<div class="desc">
						<p>
						
							${product.name}<br> <i class="fa fa-inr" aria-hidden="true"></i> ${product.price}
							<c:choose>
								<c:when test="${LoggedIn}">
									<form action="addtoCart/${userId}/${product.id}">
										<input type="number" value="1" name="quantity"
											class=" form-control  btn-block  "> <input
											type="submit" value="Add to Cart"
											class="btn btn-xs btn-success btn-block">
											
									</form>
								</c:when>
							</c:choose>
						</p>

					</div>
				</div>
			</div>
		</c:forEach>
	</div> --%>
</html>