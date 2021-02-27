<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- Navigation -->
<nav class="<navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<!-- <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li> -->
				<li id="about" class="nav-item"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
				<li id="contact" class="nav-item"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
				<li id="listProducts" class="nav-item"><a class="nav-link"
					href="${contextRoot}/show/all/products">view Products</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
					<li id="manageProducts" class="nav-item"><a class="nav-link"
						href="${contextRoot}/manage/product">Manage Products</a></li>
				</security:authorize>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li id="register" class="nav-item"><a class="nav-link"
						href="${contextRoot}/register">Sign Up</a></li>

					<li id="login" class="nav-item"><a class="nav-link"
						href="${contextRoot}/login">Login</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="dropown" id="userCart">
					
					<a href="javascript:void(0)"
						class="btn btn-default dropdown-toggle" id="dropdownMenu1"
						data-toggle="dropdown"> ${userModel.fullName} <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<security:authorize access="hasAuthority('USER')">

								<li><a href="${contextRoot}/cart/show"> <span
										class="glyphicon glyphicon-shopping-cart"></span> <span
										class="badge">${userModel.cart.cartLines}</span>
										-&#8377;${userModel.cart.grandTotal}
								</a></li>
							</security:authorize>
							<li class="divider" role="separator"></li>
							<li>
							<a href="${contextRoot}/perform-logout">Logout</a>
							</li>
						</ul></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>
<script>
	window.userRole = '${userModel.role}';
</script>