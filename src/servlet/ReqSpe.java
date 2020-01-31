package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Contact;
import service.ContactService;

/**
 * Servlet implementation class ReqSpe
 */
public class ReqSpe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqSpe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contact> list = null;
		String hql = request.getParameter("hql");
		String criteria = request.getParameter("criteria");
		String sql = request.getParameter("sql");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/contactList.jsp");
		System.out.println("Avant");
		ContactService cs = ContactService.getInstance();
		if(!hql.equals("")) {
			list = cs.getListContactFilterFirstName(hql);
		}
		if(!criteria.equals("")) {
			list = cs.getListContactFilterMail(criteria);
		}
		if(!sql.equals("")) {
			list = cs.getListContactFilterlastName(sql);
		}
		request.setAttribute("list", list);
		requestDispatcher.forward(request, response);
	}

}
