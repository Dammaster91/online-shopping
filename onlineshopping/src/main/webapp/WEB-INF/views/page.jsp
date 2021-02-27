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
	<div class="wrapper">
		<!-- Navigation -->

		<%@include file="./shared/navbar.jsp"%>
		<!-- Page Content -->
		<div class="content">
			<!--Load only when user clicks Home  -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!--Load only wher user clicks about  -->
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!--Load only wher user clicks contact  -->
			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!--Load only when user clicks contact  -->
			<c:if
				test="${userClickAllProducts==true or userClickCategoryProducts==true }">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<!--Load only when user clicks view product  -->
			<c:if test="${userClickShowProduct==true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

			<!--Load only when user clicks view product  -->
			<c:if test="${userClickManageProducts==true}">
				<%@include file="manageProduct.jsp"%>
			</c:if>
			
			<!--Load only when user clicks view product  -->
			<c:if test="${userClickShowCart==true}">
				<%@include file="cart.jsp"%>
			</c:if>



		</div>
		<!-- Footer -->
		
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
<%--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>--%>

 <link href="${css}/bootstrap.3.4.0.min.css" rel="stylesheet"> 
<script src="${js}/jquery.3.4.1.min.js"></script>
<script src="${js}/bootstrap.3.4.0.min.js"></script>
<script src="${js}/bootbox.min.js"></script>

		<%-- <script src="${js}/jquery.js"></script>
		<script src="${js}/bootbox.min.js"></script>
		<script src="${js}/bootstrap.min.js"></script> --%>
		<!-- Datatable -->
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap4.js"></script>
	


		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
