package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Contact;
import entities.IContact;
import entities.IPhone;
import entities.Phone;
import service.ContactService;

/**
 * Servlet implementation class HelloServlet
 */
public class CreateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String descphone = request.getParameter("descphone");
		String groupe = request.getParameter("groupe");
		
		IContact contact = new Contact(nom,prenom,mail);
		Phone tel = new Phone(phone, descphone);
		ContactService cs = ContactService.getInstance();
		
		cs.saveOrUpdateContact(contact);
		cs.addPhone(contact, tel);
		    
	}

}
