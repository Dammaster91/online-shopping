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
		<nav class="<navbar  navbar-inverse navbar-fixed-top"
			role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Online
						Shopping</a>
				</div>
			</div>
		</nav>
		<!-- Page Content -->
		<div class="content">
			<div class="container">
				<c:if test="${not empty message}">
					<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-danger">${message}</div>
					</div>
					</div>
				</c:if>
				
				<c:if test="${not empty logout}">
					<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-success">${logout}</div>
					</div>
					</div>
				</c:if>
			</div>

			<div class="row">
				<div class="col-md-offset-3 col-md-6">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							<h4>Login</h4>
						</div>
						<div class="panel-body">
							<form action="${contextRoot}/login" method="POST"
								class="form-horizontal" id="loginForm">
								<div class="form-group">
									<label for="username" class="col-md-4 control-Lable">Email:</label>
									<div class="col-md-8">
										<input type="text" name="username" id="username"
											class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-md-4 control-Lable">Password:</label>
									<div class="col-md-8">
										<input type="password" name="password" id="password"
											class="form-control">
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										<input type="submit" value="login" class="btn btn-primary">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}"/>
									</div>
								</div>
							</form>
						</div>
						<div class="panel-footer">
							<div class="text-right">
								New User- <a href="${contextRoot}/register">Register Here</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<script src="${js}/jquery.3.4.1.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/localization/methods_pt.min.js"></script>
		<script src="${js}/bootstrap.3.4.0.min.js"></script>
		<script src="${js}/bootbox.min.js"></script>


		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
