$(function() {
	// solving active menu problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;	
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	//to tackle the csrf token
	
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	if(token.length>0 && header.length>0){
		//set the token header for ajax request
		$(document).ajaxSend(function(e,xhr,options){
			xhr.setRequestHeader(header,token);
		});
	}
	// code for Jquery Datatable

	var $table = $('#productListTable');

	// execute the below code only where we have this table

	if ($table.length) {
		// console.log('inside the table');
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId + '/products';
		}

		$table
				.dataTable({
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'All Records' ] ],
					pageLength : 5,
					ajax: {
						url: jsonUrl,
						dataSrc: ''
					},
					columns:[
						{
							data: 'code',
							mRender: function(data,type,row){
								return '<img src="'+window.contextRoot+'/resources/images/'+data+'.png" class = "dataTableImg"/>';
							}
						},
						{
							data: 'name'
						},
						{
							data: 'brand'
						},
						{
							data: 'unitPrice',
							mRender: function(data,type,row){
								return '&#8377; ' + data;
							}
						},
						{
							data: 'quantity',
							mRender: function(data,type,row){
								if (data < 1 ){
									return '<span style = "color:red">Out of Stock !!</span>';
								}
								return data;
							}
						},
						{
							data: 'id',
							bSortable: false,
							mRender: function(data,type,row){
								var str='';
									str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class ="btn btn-primary"><span class= "fas fa-eye"></span></a> &#160;';
								if(row.quantity <1){
									str += '<a href="javascript:void(0)" class ="btn btn-success disabled"><span class= "fas fa-shopping-cart"></span></a>';	
								}
								else {
									str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class ="btn btn-success"><span class= "fas fa-shopping-cart"></span></a>';
								}
								return str;
							}
						}
					]

				});
	}
	
	//dismissing the alert after 3 seconds
	
	var $alert = $('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
		},3000)
	}
	
	
	//----------------------------------
	
	
	
	//------------------------------
	//Data Table for Admin starts
	//-------------------------------
	
	var $adminProductsTable = $('#adminProductsTable');

	// execute the below code only where we have this table

	if ($adminProductsTable.length) {
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		$adminProductsTable
				.dataTable({
					lengthMenu : [
							[ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records',
									'All Records' ] ],
					pageLength : 30,
					ajax: {
						url: jsonUrl,
						dataSrc: ''
					},
					columns:[
						{
							data:'id',
						},
						{
							data: 'code',
							mRender: function(data,type,row){
								return '<img src="'+window.contextRoot+'/resources/images/'+data+'.png" class = "admindataTableImg"/>';
							}
						},
						{
							data: 'name'
						},
						{
							data: 'brand'
						},

						{
							data: 'quantity',
							mRender: function(data,type,row){
								if (data < 1 ){
									return '<span style = "color:red">Out of Stock !!</span>';
								}
								return data;
							}
						},
						{
							data: 'unitPrice',
							mRender: function(data,type,row){
								return '&#8377; ' + data;
							}
						},
						{
							data: 'active',
							bSortable: false,
							mRender:function(data,type,row){
								var str = '';
								str+='<label class="switch">';
								if(data){
									str+='<input type="checkbox" checked="checked"  value = "'+ row.id+'"/>';
								}else{
									str+='<input type="checkbox"  value = "'+ row.id+'"/>';
								}
								str+='<div class="slider round "></div></label>';
								
								return str;
							}
						},
						{
							data: 'id',
							bSortable: false,
							mRender: function(data,type,row){
								var str='';
								str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class ="btn btn-warning"><span class= "fas fa-edit"></span></a> &#160;';
								return str;
							}
						}
					],
					initComplete: function(){
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change', function(){
							
							var checkbox = $(this);
							var checked = checkbox.prop('checked');
							var dMsg = (checked)?'Do you want to activate the product?':
												'Do you want to deactivate the product?';
							var value = checkbox.prop('value');
							bootbox.confirm({
								size:'medium',
								title:'Product Activation & Deactivation',
								message: dMsg,
								callback: function(confirmed){
									if(confirmed){
										console.log(value);
										var activationUrl = window.contextRoot + '/manage/product/'+ value +'/activation';
										console.log(activationUrl)
										$.post(activationUrl, function(data){
											bootbox.alert({
												size:'medium',
												title:'Information',
												message: data
											});	
										});
									}
									else   {
										checkbox.prop('checked',!checked);
									}	
								}	
							});		
						});
					}

				});
	}
	
	//------------------------------
	//Data Table for Admin ends
	//-------------------------------
	
	//------------------------------
	//client side validation code for category begins
	//-------------------------------
	
	var $categoryForm = $('#categoryForm');
	if($categoryForm.length){
		
		$categoryForm.validate({
			rules:{
				name:{
					required:true,
					minlength:2
				},
				description:{
					required:true
				}
			},
			messages:{
				name:{
					required:'Please add the category name!',
					minlength:'The category name should not be less than 2 characters!'
				},
				description:{
					required:'Please add a description for this category!'
				}
			},
			errorElement:'em',
			errorPlacement:function(error,element){
				//add the class of form-text
				error.addClass('form-text');
				// add the error after the element
				error.insertAfter(element);
			}
		});
		
	}
	
	
	//------------------------------
	//client side validation code for category ends
	//-------------------------------
	
	//-------------------------------------------------
	//client side validation code for login page begins
	//--------------------------------------------------
	
	var $loginForm = $('#loginForm');
	if($loginForm.length){
		
		$loginForm.validate({
			rules:{
				username:{
					required:true,
					email:true
				},
				password:{
					required:true
				}
			},
			messages:{
				username:{
					required:'Please enterthe user name!',
					email:'Please enter a valid email address!'
				},
				password:{
					required:'Please enter the password!'
				}
			},
			errorElement:'em',
			errorPlacement:function(error,element){
				//add the class of form-text
				error.addClass('form-text');
				// add the error after the element
				error.insertAfter(element);
			}
		});
		
	}
	
	
	//---------------------------------------------
	//client side validation code for login page ends
	//----------------------------------------------
	
// close of jquery
});