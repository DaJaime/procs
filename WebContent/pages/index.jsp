<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import = "dao.DAOContact"
import = "entities.Contact"
import = "entities.Phone"
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
   DAOContact dao = new DAOContact();
  // DAOPhone daoPhone = new DAOPhone();
   Contact c = new Contact ("Damien", "Jaime", "lalala@gmail.com");
   Phone p = new Phone ("0102030405", "haseebtropfort");
   dao.saveOrUpdateContact(c,p);
   /* dao.deleteContact(1);
   dao.saveOrUpdateContact(new Contact ("Toto", "Tata", "lilala@gmail.com"));
   Contact c = new Contact ("Haseeb", "Chauchau", "haseeb@gmail.com");
   dao.saveOrUpdateContact(c);
   c.setFirstName("Has");
   dao.saveOrUpdateContact(c); */
   
   
   %>
   
</body>
</html>