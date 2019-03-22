(function(window){
	window.utils={};
	// define api 
	$.fn.api.settings.api = {
			"getSignup":"getSignup",
			"signup":"signup",
			"addProjectPage":"project/getAddPage"
			};
	
	//define some doms
	window.utils.dom={
		equipment_table_tr:"<tr>"+
						"<th><div class='ui fluid input'><input type='text' placeholder=''></div></th>"+
						"<th><div class='ui fluid input'><input type='text' placeholder=''></div></th>"+
						"<th><div class='ui fluid input'><input type='text' placeholder=''></div></th>"+
						"<th style='width: 1%'><button class='mini red ui button'>Delete</button></th>"+
					    "</tr>"	
			
	};
	
	
	
	
	
	//load main modal
	window.utils.loadMainModel=function(html,init){
		var mainModel$=$("#mainModel");
		if(typeof mainModel$===undefined || typeof html===undefined || html===null){
			console.error("variable error!")
			return;
		}
		
		mainModel$.children().remove();
		mainModel$.append(html);
		mainModel$.modal({
			onVisible:function(){
				init();
				
			}
			
			
		}).modal("show");
		
		
		return mainModel$;
		
	}
	
	
	
	window.utils.alert=function(msg){
		
//		$("#notify_msg").html(msg);
//		$("#notify_modal").modal("show");
		alert(msg);
	};

	

	
	//load first level segment
		window.utils.loadContent=function(url,content_seg,success){
			var content$=$(content_seg);
			//set segment to loading
			content$.removeClass("loading").addClass("loading")
			$.ajax({
			
				url:url,
				success:function(data){
					content$.children().remove();
					content$.append(data);
					content$.removeClass("loading");
					success(data);

				},
				error:function(){
					content$.removeClass("loading");
				}
				
			});
		}

		
		
	function getData(){
		//get all element marked 'data-name'
		var allEl=$("[data-name]");
		var data={};
		$.each(allEl,function(k,v){
			var el=$(v);
			var key=el.attr("data-name");
			if(el.is("input")){
				data[key]=el.val();
			}
		});
		return data;
		
	}


	  

	
})(window)