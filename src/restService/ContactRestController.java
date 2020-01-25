package restService;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import entities.Contact;
import service.ContactService;

@Path("/contact")
public class ContactRestController {
	//http://localhost:8080/procs/api/contact/
	
    /* Premier exemple avec un GET */
    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Contact getContactApi(@PathParam("id") long id) {
    	ContactService service = ContactService.getInstance(); 
    	Contact c = (Contact) service.getContact(id);
    	System.out.println(c.getPhones());
        return c;
    }
    
    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String deleteContactApi(@PathParam("id") long id, String json) {
    	String res = "";
    	try {
	    	ContactService service = ContactService.getInstance(); 
	    	Contact c = (Contact) service.getContact(id);
	    	JSONObject obj = new JSONObject(json);
	    	if(obj.has("firstName")) {
	    		c.setFirstName(obj.getString("firstName"));
	    	}
	    	if(obj.has("lastName")) {
	    		c.setLastName(obj.getString("lastName"));
	    	}
	    	if(obj.has("email")) {
	    		c.setEmail(obj.getString("email"));
	    	}
	    	service.saveOrUpdateContact(c);
	    	res = "OK";
    	}
    	catch(Exception ex ){
    		res = "Erreur";
    	}
        return res;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String postUser(String json ) {
    	String res = "";
    	try {
	    	JSONObject obj = new JSONObject(json);
	    	Contact contact = new Contact(obj.getString("firstName"), obj.getString("lastName"), obj.getString("email"));
	    	ContactService service = ContactService.getInstance();
	    	service.saveOrUpdateContact(contact);
	    	res = "OK";
    	}
    	catch(Exception ex ){
    		res = "Erreur";
    	}
        return res;
    }
    
    @DELETE()
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String deleteContactApi(@PathParam("id") long id) {
    	//ContactService service = new ContactService();
    	// Contact contact = (Contact) service.getContact(id);
    	// System.out.println(contact.toString());
    	ContactService service = ContactService.getInstance(); 
    	service.deleteContact(id);
        return "OK";
    }

}
