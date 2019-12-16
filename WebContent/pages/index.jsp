<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import = "service.ContactService"
import = "entities.Contact"
import = "entities.Phone"
import = "entities.Entreprise"
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
	ContactService service = new ContactService();
	Contact c = new Contact ("toto", "Jaime", "lalala@gmail.com");
	service.saveOrUpdateContact(c);
   	Phone p1 = new Phone("066788876","Mobile");
	service.addPhone(c, p1);
	service.addPhone(c, new Phone("12345432","Fix"));
	service.addPhone(new Contact("tata","titi","azert@dzefd.com"), new Phone ("00987","phone"));
	Phone p2 = service.getPhone(3);
	p2.setNumber("000000000");
	service.saveOrUpdatePhone(p2);
	service.deleteContact(c.getId());
	Entreprise ent = new Entreprise("entreprise", "siège", "mail@gmail.com", "0000123");
	service.saveOrUpdateContact(ent);
	service.addPhone(ent, new Phone ("00002", "Test"));
   %>
   
</body>
</html>