package restService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import entities.Contact;
import service.ContactService;

@Path("/contact")
public class ContactRestController {
	
    /* Premier exemple avec un GET */
    @GET()
    @Path("{id}")
    public String getContactApi(@PathParam("id") long id) {
    	ContactService service = new ContactService();
    	// Contact contact = (Contact) service.getContact(id);
    	// System.out.println(contact.toString());
        return "Hello";
    }

}
