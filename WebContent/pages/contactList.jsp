<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"
    import ="java.util.ArrayList"
	import ="java.util.List"
	import ="java.util.Iterator"
	import = "entities.Contact"
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<title>Liste Contact</title>
</head>
<body>
<h1>Tous vos contacts</h1>

<table class="table">
<tr>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Modifier</th>
	<th>Supprimer</th>
</tr>
<%
/* 
List<Contact> c = (ArrayList<Contact>)request.getAttribute("list");
 
    for(Contact student : c)
    {
        out.print("Id: " + student.getId());
        out.print("<br/>");
        out.print("Name: " + student.getFirstName());
        out.print("<br/>");
        out.print("Age: " + student.getLastName());
        
        out.print("<br/>");
        out.print("<br/>");
    }
 */
%>
</table>
</body>
</html:html>

