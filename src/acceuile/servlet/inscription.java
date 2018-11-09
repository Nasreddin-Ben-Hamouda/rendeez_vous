package acceuile.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Models.patient;

import metier_model.metierpatient;

/**
 * Servlet implementation class inscription
 */
@WebServlet("/inscription_patient")
public class inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/WEB-INF/inscription.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email= request.getParameter("email");
		String sexe= request.getParameter("sexe");
		int num_tel=Integer.parseInt(request.getParameter("num_tel"));
		String region= request.getParameter("region");
		String date_naiss= request.getParameter("date_naiss");
	
		
		
		patient pa= new patient(nom,prenom,email,sexe,num_tel,region,date_naiss);
		metierpatient pa1=new metierpatient();
		pa1.Ajouterpatient(pa);
		response.sendRedirect("/rendez_vous/connexion_patient");
	}
	

}
