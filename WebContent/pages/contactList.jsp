<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"
    import ="java.util.ArrayList"
	import ="java.util.List"
	import ="java.util.Iterator"
	import = "entities.Contact"
	import = "entities.Phone"
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

<ul class="nav nav-pills">
  <li role="presentation"><a href="pages/index.jsp">Page d'accueil</a></li>
  <li role="presentation" class="active"><a href="ListContact">Liste des contacts</a></li>
  <li role="presentation"><a href="CreateGroupe">Liste des groupes</a></li>
</ul>


<% 
List<Contact> liste = new ArrayList<Contact>();
liste = (ArrayList<Contact>) request.getAttribute("list");
String type = "";
for(int i = 0;i<liste.size();i++)
{
	out.println("");
	out.println("<br/>");
	out.println("<br/>");
	pageContext.setAttribute("id", liste.get(i).getId());
	
	type = liste.get(i).getClass().getSimpleName();
	
	out.println("<div class='card'>");
	out.println("<div class='card-header'>" + type + "</div>");
	out.println("<div class='card-block'>");
	
	out.println("<h4 class='card-title'>" + liste.get(i).getFirstName() +" "+ liste.get(i).getLastName() + "</h4>");
	out.println("<p class='card-text'>" + liste.get(i).getEmail() + "</p> <br/>");
	for(Phone p : liste.get(i).getPhones())
	{		
		out.println("<p class='card-text'> <b>Description:</b> " + p.getDesc() + ".  <b>Numéro:</b> "+ p.getNumber() +"  </p> <br/>");
	}
	
	out.println("<a href='UpdateContact?modifier="+liste.get(i).getId()+"'>Modifier</a>");
	out.println("<a href='UpdateContact?supprimer="+liste.get(i).getId()+"'>Supprimer</a>");
	
}
out.println("</div>");
out.println("</div>");
%>
</body>
</html:html>


