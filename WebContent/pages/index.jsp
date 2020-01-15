<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import = "service.ContactService"
import = "service.GroupeService"
import = "entities.Contact"
import = "entities.GroupeContact"
import = "entities.Phone"
import = "entities.Entreprise"
import = "java.util.List"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
<p>Bonjour</p>

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
   
</body>
</html>