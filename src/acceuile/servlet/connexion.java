package acceuile.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Models.patient;

import metier_model.metierpatient;

/**
 * Servlet implementation class connexion
 */
@WebServlet("/connexion_patient")
public class connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/WEB-INF/connexion.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String Emailpatient= request.getParameter("emailpatient");
		String date=request.getParameter("num_tel");
		patient ad=new patient(Emailpatient,date);
		metierpatient met=new metierpatient();
	    boolean admin=met.connexion(ad) ;
		
		if(admin) {
			response.sendRedirect("/rendez_vous/bienvenu");
			session.setAttribute("emailpatient", Emailpatient);
			
		}
		else {
			  
				this.getServletContext().getRequestDispatcher( "/WEB-INF/connexion.jsp" ).forward( request, response );
			    
		}
		
	}

}
