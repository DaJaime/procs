<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import = "service.ContactService"
import = "service.GroupeService"
import = "entities.Contact"
import = "entities.GroupeContact"
import = "entities.Phone"
import = "entities.Entreprise"
import = "java.util.List"
%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Contact app</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>

<link rel="stylesheet" href="./css/style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<!--Made with Love by Larry Geams-->

<nav>
  <ul>
    <li><a href="">Afficher les contacts</a></li>
    <li><a href="">Afficher les groupes</a></li>
    <li><a href="">Work</a></li>
    <li><a href="">Contact</a></li>
  </ul>
</nav>

<%
	//mes services
	ContactService service = new ContactService();
	Contact c = new Contact ("Damien", "Jaime", "lalala@gmail.com");
	service.saveOrUpdateContact(c);
	System.out.println("------1----");
	service.getContact(c.getId());
	System.out.println("------2----");
	service.getContact(c.getId());
	/* Phone p = new Phone("0101010110", "Mobile");
	service.addPhone(c, p);
	c.setFirstName("Dada");
	service.saveOrUpdateContact(c); */
   %>
   
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>
</html>