$(document).ready(function()
{ 
	if ($("#alertSuccess").text().trim() == "") 
	{ 
		$("#alertSuccess").hide(); 
	} 
	$("#alertError").hide(); 
}); 

//SAVE
$(document).on("click", "#btnSave", function(event)
{ 
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide();
 
	// Form validation-------------------
	var status = validateCartForm(); 
	if (status != true) 
	{ 
		$("#alertError").text(status); 
		$("#alertError").show(); 
		return; 
 	} 

	// If valid------------------------
	var type = ($("#sid").val() == "") ? "POST" : "PUT"; 
	 $.ajax( 
	 { 
	 url : "system_editorAPI", 
	 type : type, 
	 data : $("#formItem").serialize(), 
	 dataType : "text", 
	 complete : function(response, status) 
	 { 
	 	onSystem_editorSaveComplete(response.responseText, status); 
	 } 
 }); 
});

function onSystem_editorSaveComplete(response, status)
{ 
	if (status == "success") 
	{ 
		 var resultSet = JSON.parse(response); 
		 if (resultSet.status.trim() == "success") 
		 { 
		 $("#alertSuccess").text("Successfully saved."); 
		 $("#alertSuccess").show(); 
		 $("#divItemsGrid").html(resultSet.data); 
		 } else if (resultSet.status.trim() == "error") 
		 { 
		 $("#alertError").text(resultSet.data); 
		 $("#alertError").show(); 
		 } 
		 } else if (status == "error") 
		 { 
		 $("#alertError").text("Error while saving."); 
		 $("#alertError").show(); 
		 } else
		 { 
		 $("#alertError").text("Unknown error while saving.."); 
		 $("#alertError").show(); 
		 } 
		 $("#sid").val(""); 
		 $("#formItem")[0].reset(); 
	}

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{ 
	 $("#sid").val($(this).closest("tr").find('#sid').val()); 
	 $("#usernmae").val($(this).closest("tr").find('td:eq(0)').text()); 
	 $("#email").val($(this).closest("tr").find('td:eq(1)').text()); 
	 $("#password").val($(this).closest("tr").find('td:eq(2)').text()); 
	 
});

// CLIENT-MODEL================================================================
function validateSystem_editorForm() 
{ 
	// usernmae-------------------------------
	if ($("#usernmae").val().trim() == "") 
	{ 
	 	return "Please Insert username."; 
	} 
	// email-------------------------------
	if ($("#email").val().trim() == "") 
	{ 
	 	return "Please Insert email."; 
	}
	// password-------------------------------
	if ($("#password").val().trim() == "") 
	{ 
	 	return "Please Insert password."; 
	} 
	
	return true;
}

$(document).on("click", ".btnRemove", function(event)
{ 
	 $.ajax( 
	 { 
		 url : "system_editorAPI", 
		 type : "DELETE", 
		 data : "sid  =" + $(this).data("sid"),
		 dataType : "text", 
	 complete : function(response, status) 
	 { 
	 	onSystem_editorDeleteComplete(response.responseText, status); 
	 } 
 }); 
});

function onSystem_editorDeleteComplete(response, status)
{ 
if (status == "success") 
	 { 
	 var resultSet = JSON.parse(response); 
	 if (resultSet.status.trim() == "success") 
	 { 
	 $("#alertSuccess").text("Successfully deleted."); 
	 $("#alertSuccess").show(); 
	 $("#divItemsGrid").html(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
	 $("#alertError").text(resultSet.data); 
	 $("#alertError").show(); 
	 } 
	 } else if (status == "error") 
	 { 
	 $("#alertError").text("Error while deleting."); 
	 $("#alertError").show(); 
	 } else
	 { 
	 $("#alertError").text("Unknown error while deleting.."); 
	 $("#alertError").show(); 
	 } 
}