<%@ page import="system_editor.system_editor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>system editor</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
	<script src="Components/Cart.js"></script>
</head>
<body>
	<div class="container"><div class="row"><div class="col-6"> 
	
	<h1>System Editor Management</h1>
	<form id="formItem" name="formItem">
 		Username: 
 		 <input id="usernmae" name="usernmae" type="text" 
 				class="form-control form-control-sm">
 				
 		 <br> Email : 
		 <input id="email" name="email" type="email" 
		 		class="form-control form-control-sm">
		 		
		 <br> Password : 
		 <input id="password" name="password" type="password" 
		 		class="form-control form-control-sm">
		 		
		 		
		 <br>
		 <input id="btnSave" name="btnSave" type="button" value="Save" 
		 		class="btn btn-primary">
		 <input type="hidden" id="sid" 
		 		name="sid" value="">
	</form>
	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
	<br>
	<div id="divItemsGrid">
		 <%
				system_editor itemObj = new system_editor();
 				out.print(itemObj.readsystem_editor());
		 %>
	</div>
</div> </div> </div>
</body>
</html>