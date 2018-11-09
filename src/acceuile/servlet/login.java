package acceuile.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.admin;

import metier_model.metieradmin;

/**
 * Servlet implementation class login
 */
@WebServlet("/login_admin")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String message;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String Email= request.getParameter("email");
		String pass= request.getParameter("pass");
		admin ad=new admin(Email,pass);
		metieradmin met=new metieradmin();
	    boolean admin=met.login(ad) ;
	    session.setAttribute("email", Email);
		if(admin) {
			response.sendRedirect("/rendez_vous/taux_RDV");
			
			
		}
		else {
			    message="erruer!!!";
				this.getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
			    
		}
		
		
		
	}

}
