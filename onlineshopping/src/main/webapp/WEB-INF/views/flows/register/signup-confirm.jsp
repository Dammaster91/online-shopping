<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<!-- Page Content -->

<div class="row">
	<div class="col-md-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Personal Details</h4>
			</div>
			<div class="panel-body">

				<div class="text-center">
					<h4>Name:-
						${registerModel.user.firstName}${registerModel.user.lastName}</h4>
					<h5>Email:- ${registerModel.user.email}</h5>
					<h5>Number:- ${registerModel.user.contactNumber}</h5>
					<h5>Role:- ${registerModel.user.role}</h5>
				</div>
				<!-- code to display personal details -->
			</div>
			<div class="panel-body">
				<!-- anchor  to move to edit  personal details -->
				<a href="${flowExecutionUrl}&_eventId_personal"
					class="btn btn-primary">Edit</a>

			</div>
		</div>
	</div>

	<div class="col-md-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Billing Address</h4>
			</div>
			<div class="panel-body">
				<!-- code to display Billing Address -->
				<div class="text-center">
					<h4>Address:- ${registerModel.billing.addressLineOne}</h4>
					<h4>${registerModel.billing.addressLineTwo}</h4>
					<h4>${registerModel.billing.city}-${registerModel.billing.postalCode}</h4>
					<h4>${registerModel.billing.state}-${registerModel.billing.country}</h4>
				</div>
			</div>
			<div class="panel-body">
				<!-- anchor  to move to edit  Billing Address -->
				<a href="${flowExecutionUrl}&_eventId_billing"
					class="btn btn-primary">Edit</a>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-4 col-sm-offset-4">
		<div class="text-center">
			<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Confirm</a>

		</div>

	</div>


</div>

<%@include file="../shared/flows-footer.jsp"%>
