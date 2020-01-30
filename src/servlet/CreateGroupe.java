package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.GroupeContact;
import entities.IGroupeContact;
import service.ContactService;

/**
 * Servlet implementation class CreateGroupe
 */
public class CreateGroupe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGroupe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nom = request.getParameter("nomGroupe");
		String desc = request.getParameter("descGroupe");
		GroupeContact gc = new GroupeContact(nom, desc);
		ContactService cs = ContactService.getInstance();
		cs.saveOrUpdateGroupeContact(gc);
		response.sendRedirect("pages/index.jsp");
		
	}

}
