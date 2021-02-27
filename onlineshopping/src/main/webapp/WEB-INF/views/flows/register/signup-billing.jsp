<%@taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp" %>
		<!-- Page Content -->
		
		<div class="container">
		<div class="row">
		<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-primary">
		<div class="panel-heading">
		<h4>Sign Up -Address</h4>
		</div>
		
		<div class="panel-body">
		<sf:form method="POST" class="form-horizontal" id="billingform" modelAttribute="billing">
		 
		<div class="form-group">
		<label class="control-lable col-md-4">Address Line One </label>
		<div class="col=md-8">
		<sf:input type="text" path="addressLineOne" class="form-control" 
		placeholder="Address Line One"/>
		<sf:errors type="text" path="addressLineOne" cssClass="help-block" element="em"/>
		
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">Address Line Two </label>
		<div class="col=md-8">
		<sf:input type="text" path="addressLineTwo" class="form-control" 
		placeholder="Address Line Two"/>
		<sf:errors type="text" path="addressLineTwo" cssClass="help-block" element="em"/>
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">City </label>
		<div class="col=md-8">
		<sf:input type="text" path="city" class="form-control" 
		placeholder="Enter City Name"/>
		<sf:errors type="text" path="city" cssClass="help-block" element="em"/>
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">Postal Code </label>
		<div class="col=md-8">
		<sf:input type="text" path="postalCode" class="form-control" 
		placeholder="XXXXXX" />
		<sf:errors type="text" path="postalCode" cssClass="help-block" element="em"/>
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">State </label>
		<div class="col=md-8">
		<sf:input type="text" path="state" class="form-control" 
		placeholder="Enter State Name"/>
		<sf:errors type="text" path="state" cssClass="help-block" element="em"/>
		</div>
		</div>
		
		<div class="form-group">
		<label class="control-lable col-md-4">Contry </label>
		<div class="col=md-8">
		<sf:input type="text" path="country" class="form-control" 
		placeholder="Enter Contry Name"/>
		<sf:errors type="text" path="country" cssClass="help-block" element="em"/>
		</div>
		</div>
		
		<div class="form-group">
		<div class="col-md-offset-4 col-md-8">
		<button  type="submit" class="btn btn-primary" name="_eventId_personal">
		<span class="glyphicon glyphicon-chevron-right"></span>Previous-Personal
		</button>
		
		<button  type="submit" class="btn btn-primary" name="_eventId_confirm">
		Next-Confirm<span class="glyphicon glyphicon-chevron-right"></span>
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