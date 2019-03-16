<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>
				<div class="panel-body">
					<sf:form 
						method = "POST"
						class= "form-horizontal"
						id="registerForm"
						modelAttribute="user"
						>
						
						<!-- first name -->
						<div class="form-group">
							<label class="control-lable col-md-4" >First Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="firstName" 
									placeholder="First Name" class="form-control" />
								<sf:errors path="firstName" cssClass="form-text" element="em"></sf:errors>	
							</div>
						</div>
						
						<!-- last name -->
						<div class="form-group">
							<label class="control-lable col-md-4" >Last Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="lastName" 
									placeholder="Last Name" class="form-control" />
								<sf:errors path="lastName" cssClass="form-text" element="em"></sf:errors>	
							</div>
						</div>
						
						<!-- email -->
						<div class="form-group">
							<label class="control-lable col-md-4" >Email</label>
							<div class="col-md-8">
								<sf:input type="text" path="email" 
									placeholder="abc@xyz.com" class="form-control" />
								<sf:errors path="email" cssClass="form-text" element="em"></sf:errors>		
							</div>
						</div>
						
						<!-- contact number -->
						<div class="form-group">
							<label class="control-lable col-md-4" >Contact Number</label>
							<div class="col-md-8">
								<sf:input type="text" path="contactNumber" 
									placeholder="xxxxxxxxxx" class="form-control" maxlength = "10"/>
								<sf:errors path="contactNumber" cssClass="form-text" element="em"></sf:errors>		
							</div>
						</div>
						
						<!-- password -->
						<div class="form-group">
							<label class="control-lable col-md-4" >Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" 
									placeholder="password" class="form-control" />
								<sf:errors path="password" cssClass="form-text" element="em"></sf:errors>		
							</div>
						</div>
						
						<!-- confirm password -->
						<div class="form-group">
							<label class="control-lable col-md-4" >Confirm Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="confirmPassword" 
									placeholder="re enter password" class="form-control" />
								<sf:errors path="confirmPassword" cssClass="form-text" element="em"></sf:errors>		
							</div>
						</div>
						
						<!-- radio button using bootstrap class radio-inline -->
						<div class="form-group">
							<label class="control-lable col-md-4" >Select Role</label>
							<div class="col-md-8">
								<label class = "radio-inline">
								<sf:radiobutton path="role" value = "USER" checked = "checked"></sf:radiobutton>User
								</label>
								<label class = "radio-inline">
								<sf:radiobutton path="role" value = "SUPPLIER" ></sf:radiobutton>Supplier
								</label>	
							</div>
						</div>
						
						<!-- submit button -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type = "submit" class = "btn btn-primary" 
								name ="_eventId_billing"
								>Next<span class = "fas fa-chevron-right"></span>
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