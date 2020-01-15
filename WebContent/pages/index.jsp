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
	GroupeService groupeservice = new GroupeService();
	
	//créer contact
	Contact contact = new Contact("Damien", "Jaime", "lalala@gmail.com");
	service.saveOrUpdateContact(contact);
	
   	//phone
	Phone p1 = new Phone("066788876","Mobile");
	service.addPhone(contact, p1);
	service.addPhone(contact, new Phone("12345432","Fix"));
	
	//créer groupe
	GroupeContact groupecontact = new GroupeContact("Amies", "bla");
	
	groupeservice.addContactGroupe(groupecontact,contact);
	System.out.println(groupecontact.getContacts());
	groupeservice.deleteContactGroupe(groupecontact,contact);
	System.out.println(groupecontact.getContacts());
	
	//groupecontact.setName("famille");
	//groupeservice.saveOrUpdateGroupeContact(groupecontact);
   
   %>
   
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>
</html>