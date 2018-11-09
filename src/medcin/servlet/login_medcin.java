package medcin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier_model.metiermedcin;

/**
 * Servlet implementation class login_medcin
 */
@WebServlet("/login_medcin")
public class login_medcin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_medcin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/login_medcin.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String emailmedcin=request.getParameter("email");
		String date=request.getParameter("pass");
		try {
		metiermedcin med =new metiermedcin();
		boolean test=med.connexion_medcin(emailmedcin,date);
		session.setAttribute("emailmedcin",emailmedcin);
		
		if(test) {
			
			response.sendRedirect("/rendez_vous/pourcentage");
			
		}
		else {
	    	this.getServletContext().getRequestDispatcher( "/WEB-INF/login_medcin.jsp" ).forward( request, response );

		}
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		
		
		
	}

}
