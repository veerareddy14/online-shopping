<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>

<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>




<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content="${csrf.token}">
<meta name="_csrf_header" content="${_csrf_headerName}">

<title>Online Shopping - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<%-- <!-- Bootstrap Litera theme -->
<link href="${css}/bootstrap-litera-theme.min.css" rel="stylesheet"> --%>

<!-- Bootstrap dataTables -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Fontawesome-->
<link href="${css}/fontawesome.all.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@ include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!--  loading the Home Content -->
			<c:if test="${userClickHome == true }">
				<%@ include file="home.jsp"%>
			</c:if>

			<!--  include only when user clicks About -->
			<c:if test="${userClickAbout == true }">
				<%@ include file="about.jsp"%>
			</c:if>

			<!--  include only when user clicks Contact -->
			<c:if test="${userClickContact == true }">
				<%@ include file="contact.jsp"%>
			</c:if>
			
			<!--  include only when user clicks AllProducts or category products -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true }">
				<%@ include file="listProducts.jsp"%>
			</c:if>
			
			<!--  include only when user clicks Show product -->
			<c:if test="${userClickShowProduct == true }">
				<%@ include file="singleProduct.jsp"%>
			</c:if>
			
			<!--  include only when user clicks manage products -->
			<c:if test="${userClickManageProducts == true }">
				<%@ include file="manageProducts.jsp"%>
			</c:if>
			
			<!--  include only when user clicks show cart -->
			<c:if test="${userClickShowCart == true }">
				<%@ include file="cart.jsp"%>
			</c:if>
		</div>
		
		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>

		<!-- JQUERY-->
		<script src="${js}/jquery.js"></script>
		
		<!-- JQUERY VALIDATOR-->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.bundle.min.js"></script>
		
		<!-- Bootbox plugin -->
		<script src="${js}/bootbox.all.min.js"></script>
		
		<!-- DataTable Plugin-->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap Script-->
		<script src="${js}/dataTables.bootstrap4.js"></script>
		
		
		<!-- fontawesome-->
		<script src="${js}/fontawesome.all.js"></script>
		
		
		<!-- self coded JavaScript -->
		<script src="${js}/myapp.js"></script>
	</div>
	oo
</body>

</html>
