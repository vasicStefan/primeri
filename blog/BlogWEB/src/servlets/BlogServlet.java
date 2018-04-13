package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BlogBean;
import beans.BlogPretraga;
import model.Blog;
import model.BlogKorisnik;

/**
 * Servlet implementation class BlogServlet
 */
@WebServlet("/BlogServlet")
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	BlogBean bb;
	@EJB
	BlogPretraga bp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("text");
		List<Blog> lista = bp.pretrazi(text);
		request.setAttribute("blogs", lista);
		RequestDispatcher rd = request.getRequestDispatcher("pretraga.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bb.addBlog((BlogKorisnik) request.getSession().getAttribute("user"),Integer.parseInt(request.getParameter("idKategorije")), request.getParameter("text"),Integer.parseInt(request.getParameter("likesNo")));
		RequestDispatcher rd = request.getRequestDispatcher("dodajBlog");
		doGet(request, response);
	}

}
