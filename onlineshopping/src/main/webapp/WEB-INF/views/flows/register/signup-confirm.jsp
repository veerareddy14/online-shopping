<%@ include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class= "row">
	<!-- column to display personal details -->
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Personal Details</h4>
			</div>
			<div class="panel-body">
				<!-- Code to display personal details -->
				<div class = "text-center">
					<h4>${registerModel.user.firstName} ${registerModel.user.firstName}</h4>
					<h5>Email: ${registerModel.user.email} </h5>
					<h5>Contact Number: ${registerModel.user.contactNumber} </h5>
					<h5>Role: ${registerModel.user.role} </h5>
				</div>
				
			</div>
			<div class="panel-footer">
				<!-- Anchor to edit personal details -->
				<a href="${flowExecutionUrl}&_eventId_personal" class = "btn btn-primary"> Edit </a>
			</div>
		</div>
	</div>

	<!-- column to display address details -->
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Billing Address</h4>
			</div>
			<div class="panel-body">
				<!-- Code to display billing address details -->
				<div class = "text-center">
					<h4>${registerModel.billing.addressLineOne}</h4>
					<h4>${registerModel.billing.addressLineTwo}</h4>
					<h4>${registerModel.billing.city} - ${registerModel.billing.postalCode}</h4>
					<h4>${registerModel.billing.state} - ${registerModel.billing.country}</h4>
				</div>
			</div>
			<div class="panel-footer">
				<!-- Anchor to edit billing address details -->
				<a href="${flowExecutionUrl}&_eventId_billing" class = "btn btn-primary">Edit </a>
			</div>
		</div>
	</div>
	</div>
	<!--  to provide confirm button after dispalying the details -->
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">
			<div class="text-center">
				<a href="${flowExecutionUrl}&_eventId_submit" class = "btn btn-primary">Confirm</a>
			</div>
		</div>
	</div>
</div>

<%@ include file="../shared/flows-footer.jsp"%>