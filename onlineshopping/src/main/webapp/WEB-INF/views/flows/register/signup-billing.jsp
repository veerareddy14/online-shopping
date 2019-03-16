<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Billing</h4>
				</div>
				<div class="panel-body">
					<sf:form 
						method = "POST"
						class= "form-horizontal"
						id="billingForm"
						modelAttribute="billing"
						>
						
						<!-- Address Line 1 -->
						<div class="form-group">
							<label class="control-lable col-md-4" >Address Line 1</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineOne" 
									placeholder="Address" class="form-control" />
								<sf:errors path="addressLineOne" cssClass="form-text" element="em"></sf:errors>		
							</div>
						</div>
						
						<!-- Address Line 2 -->
						<div class="form-group">
							<label class="control-lable col-md-4" >Address Line 2</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineTwo" 
									placeholder="Address" class="form-control" />
								<sf:errors path="addressLineTwo" cssClass="form-text" element="em"></sf:errors>		
							</div>
						</div>
						
						<!-- city -->
						<div class="form-group">
							<label class="control-lable col-md-4" >City</label>
							<div class="col-md-8">
								<sf:input type="text" path="city" 
									placeholder="Enter your city" class="form-control" />
								<sf:errors path="city" cssClass="form-text" element="em"></sf:errors>		
							</div>
						</div>
						
						<!-- state -->
						<div class="form-group">
							<label class="control-lable col-md-4" >State</label>
							<div class="col-md-8">
								<sf:input type="text" path="state" 
									placeholder="Enter your state" class="form-control" />
								<sf:errors path="state" cssClass="form-text" element="em"></sf:errors>		
							</div>
						</div>
						
						<!-- country -->
						<div class="form-group">
							<label class="control-lable col-md-4" >Country</label>
							<div class="col-md-8">
								<sf:input type="text" path="country" 
									placeholder="Enter your country" class="form-control" />
								<sf:errors path="country" cssClass="form-text" element="em"></sf:errors>		
							</div>
						</div>
						
						<!--Postal code -->
						<div class="form-group">
							<label class="control-lable col-md-4" >Postal code</label>
							<div class="col-md-8">
								<sf:input type="text" path="postalCode" 
									placeholder="postal code" class="form-control" />
								<sf:errors path="postalCode" cssClass="form-text" element="em"></sf:errors>		
							</div>
						</div>
						
						
						
						<!-- submit buttons -->
						<div class="form-group">
							
							
							<div class="col-md-offset-4 col-md-8">
								<!--  submit button to go to previous view state  - personal -->
								<button type = "submit" class = "btn btn-primary" 
								name ="_eventId_personal"
								>
								<span class = "fas fa-chevron-left"></span>Previous 
								</button>
							
							
								<!--  submit button to go to next view state  - confirm -->
							
								<button type = "submit" class = "btn btn-primary" 
								name ="_eventId_confirm"
								>
								Next<span class = "fas fa-chevron-right"></span>
								</button>
							</div>
							
						</div>
					
					</sf:form>
					
				</div>

			</div>
		</div>

	</div>
</div>

<%@ include file="../shared/flows-footer.jsp"%>