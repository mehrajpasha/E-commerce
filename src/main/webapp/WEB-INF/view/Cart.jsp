<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
	<div align="center">
		<table class="table" style="width: 80%">
			<thead>
				<tr id="tr1">
					<th>Cart Id</th>
					<th>Productname</th>
					<th>Quantity</th>
					<th>Delete</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartlist}" var="cart">
					<tr id="tr1">
						<td id="td1"><c:choose><c:when test="${cart.cartid gt 0}"></c:when></c:choose><c:out value="${cart.cartid}" />
						<td id="td1"><c:out value="${cart.productname}" />
						<td id="td1"><c:out value="${cart.quantity}" />
						<td id="td1"><a href="deletecart/${cart.cartid }">delete</a>
						<td id="td1"><c:out value="${cart.price}" />
						
				</tr>
				</c:forEach>		
			</tbody>
			<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total </strong></td>
						</tr>
						<tr>
							<td><a href="#" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total: Rs ${CartPrice}</strong></td>
							<td><a href="checkoutFlow" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>	
		</table>
		</div>
		
<script type="text/javascript">
function checkAndSubmit()
{
  if (document.getElementById('sel1').selectedIndex > -1)
  {
      document.formID.submit();
     // alert('both have been selected!');
  }
}
</script>					
						 
</body>
</html>