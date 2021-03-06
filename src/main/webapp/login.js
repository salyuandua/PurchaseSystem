$(function() {

	//==============================sign up
	$("#signupLink").api({
		action:"getSignup",
		onComplete:function(res){
			//console.log(res);
			$("#signupModel").children().remove();
			$("#signupModel").append(res);
			$("#signupModel").modal({
				onVisible:function(){
					$(".exclamation.circle.orange.icon").popup();
					$(".ui.selection.dropdown").dropdown();
					//=======================sign in form========================
					var signinForm=$("#signinForm");
					
					signinForm.form({
						//=================validating rules====================
						fields:{
							firstName:{
								rules:[{type:"empty",prompt:"Please enter your first name"}]
							},
							lastName:{
								rules:[{type:"empty",prompt:"Please enter your last name"}]
							},
							
							
							email:{
								rules:[{type:"empty",prompt:"Please enter email"},{type:"email",prompt:"Please enter vaild email"}]
								
							},
							password:{
								rules:[{type:"minLength[6]",prompt:"Min lenth of password is 6"}]
							},
							role:{
								rules:[{type:"empty",prompt:"Please select role"}]
							},
							code:{
								rules:[{type:"empty",prompt:"Please enter code"}]
								
							}
							
						},
						//validate success
						onSuccess:function(){
							//console.log(signinForm.form("get values"));
							$.api({
								action:"signup",
								data:signinForm.form("get values"),
								on:"now",
								method:"POST",
								onComplete:function(res){
									
									
									
								}
								
							});
							
							
							
						}
						
						
					});
					
					//==============sign in event
					$("#signupBut").click(function(){
						signinForm.form("validate form");
						
						
					});
					
				}
			
			}).modal("show");
			
			
			
		}
		
	});

	//==================================log in function
	utils.post({
		action:"login",
		dom:$("#login_but"),
		isForm:true,
		success:function(data){
			location.href="home";
		},
		failure:function(message){
			$("#invalidated_msg").children("div.header").html(message.message);
			$("#invalidated_msg").removeClass("hidden");

		},
		error:function(message){
			$("#invalidated_msg").children("div.header").html("Server Error");
			$("#invalidated_msg").removeClass("hidden");
		}
	});
	
	
	
	
	//===================================send password function
	utils.post({
		action:"sendPassword",
		dom:$("#sendPassword"),
		isForm:false,
		success:function(data){
			
			$("#msgDiv").removeClass("negative hidden").addClass("positive");
			$("#respMsg").html(data.message);
		},
		failure:function(message){
			
			$("#msgDiv").removeClass("positive hidden").addClass("negative");
			$("#respMsg").html(message.message);
		},
		error:function(message){
			$("#msgDiv").removeClass("positive hidden").addClass("negative");
			$("#respMsg").html("Server error");
		}
	});
	
	//login function
	$("#login_but").click(function(){
		//test

		
	});
	

      $('.ui.accordion').accordion();		

      
    });