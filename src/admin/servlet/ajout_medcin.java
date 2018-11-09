package admin.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.medcin;
import Models.patient;
import metier_model.metieradmin;
import metier_model.metiermedcin;
import metier_model.metierpatient;

/**
 * Servlet implementation class ajout_medcin
 */
@WebServlet("/ajout_medcin")
public class ajout_medcin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajout_medcin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/WEB-INF/ajout_medcin.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		HttpSession session=request.getSession();
		String email=session.getAttribute("email").toString();
		metieradmin m=new metieradmin();
		ResultSet res=m.select_hopital_admin(email);
		try {
			while(res.next()) {
				 num=res.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email1= request.getParameter("email");
		String sexe= request.getParameter("sexe");
		int num_tel=Integer.parseInt(request.getParameter("num_tel"));
		String region= request.getParameter("region");
		String date_naiss= request.getParameter("date_naiss");
		medcin med= new medcin(nom,prenom,email1,sexe,num_tel,region,date_naiss,num);
		metiermedcin met=new metiermedcin();
		met.Ajoutermedcint(med);
		response.sendRedirect("/rendez_vous/liste_medecin");
	
	}

}
