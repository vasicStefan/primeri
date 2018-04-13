package servlets;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.KonfBean;
import model.Conference;

/**
 * Servlet implementation class KonfServlet
 */
@WebServlet("/KonfServlet")
public class KonfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	KonfBean kb;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KonfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String naziv = request.getParameter("naziv");
		String drzava = request.getParameter("drzava");
		String grad = request.getParameter("grad");
		String oblast = request.getParameter("oblast");
		Date datumOd = new Date();
		Date datumDo = new Date();
		Conference c = new Conference();
		c.setTitle(naziv);
		c.setCountry(drzava);
		c.setCity(grad);
		c.setField(oblast);
		c.setDateFrom(datumOd);
		c.setDateTo(datumDo);
		kb.sendToQueue(c);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
