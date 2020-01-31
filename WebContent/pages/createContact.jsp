<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.ArrayList"
    import ="java.util.List"
	import = "entities.GroupeContact"
    
    
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
  <li role="presentation" class="active"><a href="pages/index.jsp"">Page d'accueil</a></li>
  <li role="presentation"><a href="ListContact">Liste des contacts</a></li>
  <li role="presentation"><a href="CreateGroupe">Liste des groupes</a></li>
</ul>



<div class="container">
  <form method="post" action="CreateContact">
    <h2>Créer un contact</h2>
    <div class="row">
      <div class="col-md-6">
        <div class="form-group">
          <label for="first">Nom</label>
          <input type="text" class="form-control" placeholder="Durand" name="nom">
        </div>

        <div class="form-group">
          <label for="last">Prénom</label>
          <input type="text" class="form-control" placeholder="toto" name="prenom">
        </div>

        <div class="form-group">
          <label for="company">Mail</label>
          <input type="text" class="form-control" placeholder="toto@gmail.com" name="mail">
        </div>
        
        <div class="form-group">
          <label for="phone">Téléphone</label>
          <input type="tel" class="form-control" name="phone" placeholder="0607080910">
        </div>
        
        <div class="form-group">
          <label for="phone">Description du téléphone</label>
          <input type="text" class="form-control" name="descphone" placeholder="Toto le collégue du bureau">
        </div>
        
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