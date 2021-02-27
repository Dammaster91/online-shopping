<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Online Shopping -${title}</title>
<script type="text/javascript">
	window.menu = '${title}'
	window.contextRoot = '${contextRoot}'
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap-readabletheam.css" rel="stylesheet">
<link href="${css}/bootstrap-theme.css" rel="stylesheet">

<!-- Bootstrap DataTable CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
<div class="container">
	<c:if test="${not empty message}">
	<div class="alert alert-info">
	<h3 class="text-center">
	${message}
	</h3>
	</div>
	</c:if>

	<c:choose>
		<c:when test="${not empty cartLines}">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${cartLines}" var="cartLine">
				<tr>
				<td data-th="Product">
							<div class="row">
								<div class="col-sm-2 hidden-xs">
									<img src="${images}/${cartLine.product.code}.png" alt="${cartLine.product.name}"
										class="img-responsive cartImg" />
								</div>
								<div class="col-sm-10">
								<c:if test="${cartLine.isAvaliable=false}">
								<strong class="unavailable">(Not Available)</strong>
								</c:if>
								
									<h4 class="nomargin">${cartLine.product.name}</h4>
									<p>Brand - ${cartLine.product.brand}</p>
									<p>Description - ${cartLine.product.description}</p>
								</div>
							</div>
						</td>
						<td data-th="Price">&#8377;${cartLine.buyingPrice}</td>
						<td data-th="Quantity"><input type="number" id="count_${cartLine.id}" min="1" max="3"
							class="form-control text-center" value="${cartLine.productCount}"></td>
						<td data-th="Subtotal" class="text-center">&#8377;${cartLine.total}</td>
						<td class="actions" data-th="">
							<button type="button" name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm">
								<span class="glyphicon glyphicon-refresh"></span>
							</button>
							<button class="btn btn-danger btn-sm">
								<span class="glyphicon glyphicon-trash"></span>
							</button>
						</td>
					</tr>
					</c:forEach>
				</tbody>
				
						
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total &#8377;${userModel.cart.grandTotal}</strong></td>
					</tr>
					<tr>
						<td><a href="#" class="btn btn-warning"><span
								class="glyphicon glyphicon-chevron-left"></span> Continue
								Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								&#8377;${userModel.cart.grandTotal}</strong></td>
						<td><a href="#" class="btn btn-success btn-block">Checkout
								<span class="glyphicon glyphicon-chevron-right"></span>
						</a></td>
					</tr>
				</tfoot>
			</table>
		</c:when>
		<c:otherwise>
			<div class="jumbotron">
				<div class="text-center">
					<h1>Your cart is empty</h1>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>

</body>