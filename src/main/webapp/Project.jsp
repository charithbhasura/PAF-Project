<%@ page import="project.project"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>


<%
//Insert item---------------------------------
if (request.getParameter("pid") != null)
 {
	project itemObj = new project();
 String stsMsg = itemObj.addProject(request.getParameter("pid"),
 request.getParameter("pname"),
 request.getParameter("pdescription"),
 request.getParameter("pprice"));
 session.setAttribute("statusMsg", stsMsg);
 }

%>


<!DOCTYPE html>
<html>
<head>

 <link rel="stylesheet" href="Views/bootstrap.min.css">
<style>

input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 8px;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  align:center;
}
a:link, a:visited {
  background-color: grey;
  color: white;
  padding: 8px 8px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border-radius: 4px;
}

a:hover, a:active {
  background-color: light blue;
}
</style>

<meta charset="ISO-8859-1">
<title>Projects Management</title>


</head>
<body>

<div class="container"  >
 <div class="row"  >
 <div class="col"  >
<h1 align="center">Projects Management</h1>

<form name="myForm"  method="post" action="SystemEditor.jsp" onsubmit="return validateForm()">


<div class="form-group">
 Project Name: <input name="name"  type="text" class="form-control" ></div>
<div class="form-group"> 
 Project Description: <input name="company" type="text" class="form-control" ></div>
 <div class="form-group">
 Project Price: <input name="project" type="text" class="form-control" ></div> 
 
 <button onclick="myFunction()" class="btn btn-success" type="submit" value="Save">Save</button>
 <a href= "nav.jsp">Click here to go Back</a>
 
</form> 
</div></div></div>


<br> 
<script>

function myFunction() {
	  alert("Data inserted Successfully!");
} 
	

</script>



</body>
</html>