package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Contact;
import entities.GroupeContact;
import entities.Phone;
import service.ContactService;

/**
 * Servlet implementation class UpdateContact
 */
public class UpdateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		String id = "";
		if(request.getParameter("modifier") != null)
		{
			id = request.getParameter("modifier");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/updateContact.jsp");
			ContactService cs = ContactService.getInstance();
			Contact contact = (Contact) cs.getContact(Long.parseLong(id, 10));
			request.setAttribute("contact", contact);
			List<GroupeContact> listGroupe = cs.getListGroupe();
			request.setAttribute("listGroupe", listGroupe);
			requestDispatcher.forward(request, response);	
			
		}
		else
		{
			id = request.getParameter("supprimer");
			ContactService cs = ContactService.getInstance();
			cs.deleteContact(Long.parseLong(id, 10));
			response.sendRedirect("pages/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nom = request.getParameter("nom");
		String id = request.getParameter("id");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String descphone = request.getParameter("descphone");
		String groupe = request.getParameter("groupe");
		
		ContactService cs = ContactService.getInstance();
		Contact contact = (Contact) cs.getContact(Long.parseLong(id, 10));
		contact.setFirstName(prenom);
		contact.setLastName(nom);
		contact.setEmail(mail);
		
		for(Phone phoneObject : contact.getPhones()) 
		{
			cs.deletePhone(phoneObject.getId());
		}
		contact.getPhones().clear();
		System.out.println(contact.getPhones());
		Phone p = new Phone(phone, descphone);
		cs.addPhone(contact, p);
		
		cs.saveOrUpdateContact(contact);
		response.sendRedirect("pages/index.jsp");
		
	}

}
