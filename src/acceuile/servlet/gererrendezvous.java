package acceuile.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier_model.metierRDV;

/**
 * Servlet implementation class gererrendezvous
 */
@WebServlet("/gerer_rendez_vous")
public class gererrendezvous extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gererrendezvous() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email="";
		HttpSession session = request.getSession();
		
		email = (String) session.getAttribute("emailpatient");
		if( email=="") {
			response.sendRedirect("/rendez_vous/connexion_patient");
		}
		else {
       
		metierRDV met=new metierRDV();
		ResultSet arrayrend=met.select_rendez_vous(email);
		request.setAttribute("rend", arrayrend);
		}
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/gererrend.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num_rdv"));
		metierRDV r=new metierRDV();
		r.anuler(num);
		response.sendRedirect("/rendez_vous/gerer_rendez_vous");
		
		
	
		

}
	}
