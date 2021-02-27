<%@taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp" %>
		<!-- Page Content -->
		
		<div class="container">
		<div class="row">
		<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-primary">
		<div class="panel-heading">
		<h4>Sign Up -Personal</h4>
		</div>
		
		<div class="panel-body">
		<sf:form method="POST" class="form-horizontal" id="registerform" modelAttribute="user">
		<div class="form-group">
		<label class="control-lable col-md-4">First Name </label>
		<div class="col=md-8">
		<sf:input type="text" path="firstName" class="form-control" placeholder="First Name"/>
		<sf:errors type="text" path="firstName" cssClass="help-block" element="em"/>
		
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">Last Name </label>
		<div class="col=md-8">
		<sf:input type="text" path="lastName" class="form-control" 
		placeholder="Last Name"/>
		<sf:errors type="text" path="lastName" cssClass="help-block" element="em"/>
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">Email </label>
		<div class="col=md-8">
		<sf:input type="text" path="email" class="form-control" 
		placeholder="abc@gmail.com"/>
		<sf:errors type="text" path="email" cssClass="help-block" element="em"/>
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">Contact Number </label>
		<div class="col=md-8">
		<sf:input type="text" path="contactNumber" class="form-control" 
		placeholder="XXXXXX" maxlength="10"/>
		<sf:errors type="text" path="contactNumber" cssClass="help-block" element="em"/>
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">Password </label>
		<div class="col=md-8">
		<sf:input type="password" path="password" class="form-control" 
		placeholder="password"/>
		<sf:errors type="password" path="password" cssClass="help-block" element="em"/>
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">Confirm Password </label>
		<div class="col=md-8">
		<sf:input type="confirmPassword" path="confirmPassword" class="form-control" 
		placeholder="Re-enter password"/>
		<sf:errors type="confirmPassword" path="confirmPassword" cssClass="help-block" element="em"/>
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">Select Role </label>
		<div class="col-md-8">
		<label class="radio-inline">
		<sf:radiobutton path="role" value="USER" checked="checked"/>User
		</label>
		<label class="radio-inline">
		<sf:radiobutton path="role" value="SUPPLIER" checked="checked"/>Supplier
		</label>
		</div>
		</div>
		<div class="form-group">
		<div class="col-md-offset-4 col-md-8">
		<button  type="submit" class="btn btn-primary" name="_eventId_billing">
		Next-Billing<span class="glyphicon glyphicon-chevron-right"></span>
		</button>
		</div>
		</div>
		</sf:form>
		</div>
		</div>
		</div>
		
		</div>
		</div>
		
<%@include file="../shared/flows-footer.jsp" %>		