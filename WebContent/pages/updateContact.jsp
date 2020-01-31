<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.ArrayList"
    import ="java.util.List"
	import = "entities.GroupeContact"
    import = "entities.Contact"
    import = "entities.Phone"
    
    %>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Créer un contact</title>
</head>

<body>

<ul class="nav nav-pills">
  <li role="presentation"><a href="pages/index.jsp">Page d'accueil</a></li>
  <li role="presentation"><a href="ListContact">Liste des contacts</a></li>
  <li role="presentation"><a href="CreateGroupe">Liste des groupes</a></li>
</ul>

<% Contact c = (Contact)request.getAttribute("contact");%>

<div class="container">
  <form method="post" action="UpdateContact">
    <h2>Modifier un contact</h2>
    <div class="row">
      <div class="col-md-6">
        <div class="form-group">
          <label for="first">Nom</label>
          <%out.println("<input type='text' class='form-control' name='nom' value='"+c.getLastName()+"'>");%>
        </div>
		<%out.println("<input type='hidden' class='form-control' name='id' value='"+c.getId()+"'>");%>
        <div class="form-group">
          <label for="last">Prénom</label>
          <%out.println("<input type='text' class='form-control' name='prenom' value='"+c.getFirstName()+"'>");%>
        </div>

        <div class="form-group">
          <label for="company">Mail</label>
          <%out.println("<input type='text' class='form-control' name='mail' value='"+c.getEmail()+"'>");%>
        </div>

          <%
          for(Phone p : c.getPhones())
		      	{		
        	  		out.println("<div class='form-group'><label for='phone'>Téléphone</label>");
        	  		out.println("<input type='text' class='form-control' name='phone' value='"+p.getNumber()+"'>");
        	  		out.println("</div>");
		      	}
          %>        
        
          <%
          for(Phone p : c.getPhones())
		      	{	
        	  		out.println("<div class='form-group'><label for='phone'>Description du téléphone</label>");
        	  		out.println("<input type='text' class='form-control' name='descphone' value='"+p.getDesc()+"'>");
        	  		out.println("</div>");
		      	}
          %> 
        
         <div class="form-group">
          <label for="phone">Groupe</label>
          <input list="groupes" name="groupe" class="form-control">
		  <datalist id="groupes">
		  <%
		  List<GroupeContact> liste = new ArrayList<GroupeContact>();
          liste = (ArrayList<GroupeContact>) request.getAttribute("listGroupe");
   		  for(int i = 0;i<liste.size();i++)
   		  {
   		  	out.println("<option value='"+liste.get(i).getId()+"-"+ liste.get(i).getName()+"'>");
   		  }
		  %>
		  </datalist>
        </div>
        
      </div>
    </div>
    <button type="submit" class="btn btn-primary">Envoyer</button>
  </form>
</div>

</body>
</html>