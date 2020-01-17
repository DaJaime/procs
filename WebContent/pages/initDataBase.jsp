<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import = "util.InitDataBase"
%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Contact app</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>

<link rel="stylesheet" href="css/styleIndex.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body id="#bodyInitDataBase">

<div id="DivinitDataBase" class="alert alert-primary">
  <h1>Base de donnée peuplée</h1>
  <a href="index.jsp"> <button id="btnInitDataBase" type="button" class="btn btn-primary">OK</button> </a>
</div>

<%
	//mes services
	InitDataBase data = new InitDataBase();
	data.init();
   %>
   
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>
</html>