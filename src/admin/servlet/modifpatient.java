package admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.patient;
import Models.personne;

import metier_model.metierpatient;

/**
 * Servlet implementation class modifpatient
 */
@WebServlet("/modifier_patient")
public class modifpatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifpatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("mat"));
		patient a=new patient(id);
		metierpatient admin = new metierpatient();
		List<personne> adminArray = admin.select_special_patient(a);
		
		request.setAttribute("adminArray",adminArray );
		//System.out.println(adminArray.get(0));
				//System.out.print(adminArray.size());
		this.getServletContext().getRequestDispatcher( "/WEB-INF/modifpatient.jsp" ).forward( request, response );	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("mat"));
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email= request.getParameter("email");
		String sexe= request.getParameter("sexe");
		int num_tel=Integer.parseInt(request.getParameter("num_tel"));
		String region= request.getParameter("region");
		String date_naiss= request.getParameter("date_naiss");
		
		patient ad= new patient(nom,prenom,email,sexe,num_tel,region,date_naiss,id);
		metierpatient ad1=new metierpatient();
		ad1.Modifierpatient(ad);
		response.sendRedirect("/rendez_vous/liste_patient");
	}

}
