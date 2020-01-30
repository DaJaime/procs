<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Créer un groupe</title>
</head>

<body>

<ul class="nav nav-pills">
  <li role="presentation" class="active"><a href="index.jsp">Page d'accueil</a></li>
  <li role="presentation"><a href="#">Liste des contacts</a></li>
  <li role="presentation"><a href="#">Liste des groupes</a></li>
</ul>



<div class="container">
  <form method="post" action="../CreateGroupe">
    <h2>Créer un groupe</h2>
    <div class="row">
      <div class="col-md-6">
        <div class="form-group">
          <label for="first">Nom du groupe</label>
          <input type="text" class="form-control" placeholder="" name="nomGroupe">
        </div>

        <div class="form-group">
          <label for="last">Description du groupe</label>
          <input type="text" class="form-control" placeholder="" name="descGroupe">
        </div>
        
      </div>
    </div>
    <button type="submit" class="btn btn-primary">Envoyer</button>
  </form>
</div>

</body>
</html>