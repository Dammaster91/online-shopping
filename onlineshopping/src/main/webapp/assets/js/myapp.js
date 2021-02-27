$(function() {

	switch (menu) {

	case 'Abouts Us':
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
		
	case 'User Cart':
		$('#userCart').addClass('active');
		break;
		
	default:
		if(menu=="Home")break;
		$('#listProducts').addClass('active');
		$('#o_' + menu).addClass('active');
		break;

	}
	// to tackle csrf token
	
	var token=$('meta[name="_csrf"]').attr('content');
	var header=$('meta[name="_csrf_header"]').attr('content');
	if(token.length>0 && header.length>0){
		
	$(document).ajaxSend(function(e,xhr,option){
		xhr.setRequestHeader(header,token);
	});	
	}
	
	//code jquery tabatable
	//create a data set
	var jsonUrl='';
	if(window.categoryId=='')
		{
		jsonUrl=window.contextRoot +'/json/data/all/products';
		}else
		{	
			jsonUrl=window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
		}
	
	
	var $table=$('#productListTable');
	//execute the belwo code only where have this table
	if($table.length){
	//console.log('Inside the table');
		$table.DataTable({
		
			lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
			pageLength:5,
			ajax:{
				url:jsonUrl,
				dataSrc:''
			},
			columns : [ 
				     {
					data : 'code',
					mRender:function(data,type,row)
					{
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.png" class="dataTableImg"/>'
					}
				     },
				{
				data : 'name'

			     },
			{
				data : 'brand'

			}, 
			{
				data : 'unitPrice',
				mRender:function(data,type,row){
					return '&#8377; '+data;
				}

			},
			{
				data : 'quantity',
				mRender:function(data,type,row){
					if(data<1)
						{
						return '<span style="color:red">Out of Stock!</span>';
						}
					return data;
				}
			},
			{
				data:'id',
				bSortable:false,
				mRender:function(data,type,row){

					var str='';
					str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"</span></a> &#160;'
				
					if(userRole=='ADMIN'){
						str+='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"</span></a>'
					}else{
					if(row.quantity<1){
						str+='<a href="javascript void(0)" class="btn btn-primary disabled"><span class="glyphicon glyphicon-shopping-cart"</span></a>'
					}
					else{
						str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"</span></a>'
						
					}
					}
					
					return str;
				}
				
			}
			]
		});
	}
	var $alert=$('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
		},3000)
	}
	//---------------------
	
	
	//data table for admin
	//----------------------------------------

	var $adminProductsTable=$('#adminProductsTable');
	//execute the belwo code only where have this table
	if($adminProductsTable.length){
		var jsonUrl=window.contextRoot +'/json/data/admin/all/products';
		
	//console.log('Inside the table');
		$adminProductsTable.DataTable({
		
			lengthMenu:[[10,30,50,-1],['10 Records','30 Records','50 Records','ALL']],
			pageLength:30,
			ajax:{
				url:jsonUrl,
				dataSrc:''
			},
			columns : [ 
				{
					data:'id'
				},
				     {
					data : 'code',
					bSortable:false,
					mRender:function(data,type,row)
					{
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.png" class="dataTableImg"/>'
					}
				     },
				{
				data : 'name'

			     },
			{
				data : 'brand'

			},
			{
				data : 'quantity',
				mRender:function(data,type,row){
					if(data<1)
						{
						return '<span style="color:red">Out of Stock!</span>';
						}
					return data;
				}
			},
			{
				data : 'unitPrice',
				mRender:function(data,type,row){
					return '&#8377; '+data;
				}

			},
			
			{
				data:'active',
				bSortable:false,
				mRender:function(data,type,row){
				 var str='';
				 str = '<label class="switch">';
				 if(data){
									str += '<input type="checkbox" checked="checked" value="'+row.id+'">';
									
					
				}else{
					str += '<input type="checkbox" value="'+row.id+'">';

					}
				 str += '<div class="slider"></div></label>';
				return str;
				}
			},{
				
				data:'id',
				bSortable:false,
				mRender:function(data,type,row){
				var str='';
				//${contextRoot}
				str+='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
				str+='<span class="glyphicon glyphicon-pencil"></span></a>';
				return str;	
				}
				
			}
			
			],
			initComplete:function(){
				
				var api=this.api();
				api.$('.switch input[type="checkbox"]').on('change',function(){
					var checkbox=$(this);
					var checked=checkbox.prop('checked');
					var dMsg=(checked)?'You Want to activate the Product?':'You Want to deactivate the Product?';
				    var value=checkbox.prop('value');
				  
				  
				  bootbox.confirm({
					  size:'medium',
					  title:'product Activation & deactivation',
					  message:dMsg,
					  callback:function(confirmed){
						
						  if(confirmed){
							  console.log(value);
							  var activationUrl= window.contextRoot+'/manage/product/'+value+'/activation';
							  $.post(activationUrl,function(data){
								  bootbox.alert({
									  size:'medium',
									  title:'Information',
									  message:data
								  }) ;
							  });
							 
						  }else{
							  checkbox.prop('checked',!checked);
						  }
					  }
				  });
				});
			}
		});
	}

	//--------------------------------------
	
	var $loginForm=$('#loginForm');
	if($loginForm.length){
		$loginForm.validate({
			rules:{
				username:{
					required:true,
					email:true
				},
				password:{
					required:true,
				}
			},
			message:{
				username:{
					
					required:'please enter the username!',
					email:'please enter valid email address'
					
				},
          password:{
					
					required:'please enter the password!',
					
				}
			},errorElement:'em',
			errorPlacement:function(error,element){
				arror.addClass('help-block');
				error.insertAfter(element);
			}
			
		});
	}
	//----------------------
	//Handling click event of referesh button
	$('button[name="refreshCart"]').click(function(){
		// fetch ther cart line
		var cartLineId=$(this).attr('value');
		var countElement=$('#count_'+cartLineId);
		var originalCount=countElement.attr('value');
		var currentCount=countElement.val();
		// work only when count has changed
		if(currentCount!=originalCount){
			if(currentCount<1 || currentCount>3){
				//reverting back to the original count
				countElement.val(originalCount);
				bootbox.alert({
					size:'medium',
						title:'Error',
						message:'Product count should be minimum 1 and maximum 3!'
					
				})
			}else{
				var updateUrl=window.contextRoot+'/cart/'+cartLineId+'/update?count='+currentCount;
				window.location.href=updateUrl;
			}
			//console.log("current count"+currentCount);
			//console.log("original count"+originalCount);
		}
		
	} )
	
	
});