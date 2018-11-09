package admin.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.patient;
import Models.personne;
import metier_model.metieradmin;
import metier_model.metierpatient;

/**
 * Servlet implementation class listepatient
 */
@WebServlet("/liste_patient")
public class listepatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listepatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = 0;
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		metieradmin m=new metieradmin();
		ResultSet res=m.select_hopital_admin(email);
		try {
			while(res.next()) {
				 num=res.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		metierpatient pat = new metierpatient();
		List<personne> adminArray = pat.AfficherListe(num);
	
		request.setAttribute("adminArray",adminArray );
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/listepatient.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("matricule"));
		patient ad=new patient(id);
		metierpatient met=new metierpatient();
		met.supprimerpatient(ad);
		response.sendRedirect("/rendez_vous/liste_patient");
	}

}
