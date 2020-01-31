<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.ArrayList"
    import ="java.util.List"
	import = "entities.GroupeContact"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Liste des groupes</title>
</head>
<body>

<ul class="nav nav-pills">
  <li role="presentation"><a href="pages/index.jsp"">Page d'accueil</a></li>
  <li role="presentation"><a href="ListContact">Liste des contacts</a></li>
  <li role="presentation" class="active"><a href="CreateGroupe">Liste des groupes</a></li>
</ul>


		  <%
		  List<GroupeContact> liste = new ArrayList<GroupeContact>();
          liste = (ArrayList<GroupeContact>) request.getAttribute("listGroupe");
   		  for(int i = 0;i<liste.size();i++)
   		  {
   		  	out.println("<b>Nom du groupe :</b> "+liste.get(i).getId()+"-"+ liste.get(i).getName()+"  <b>Description :</b>"+liste.get(i).getDescription()+" <br/>");
   		  }
		  %>


</body>
</html>