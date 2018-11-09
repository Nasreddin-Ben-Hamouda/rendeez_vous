package admin.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.admin;
import Models.personne;
import metier_model.metieradmin;

/**
 * Servlet implementation class modifadmin
 */
@WebServlet("/modif_admin")
public class modifadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifadmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		admin a=new admin(id);
		metieradmin admin = new metieradmin();
		List<personne> adminArray = admin.select_special_admin(a);
		
		request.setAttribute("adminArray",adminArray );
		//System.out.println(adminArray.get(0));
				//System.out.print(adminArray.size());
		this.getServletContext().getRequestDispatcher( "/WEB-INF/modifadmin.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email= request.getParameter("email");
		String sexe= request.getParameter("sexe");
		int num_tel=Integer.parseInt(request.getParameter("num_tel"));
		String region= request.getParameter("region");
		String date_naiss= request.getParameter("date_naiss");
		String password= request.getParameter("password");
		int num_hopital=Integer.parseInt(request.getParameter("num_hopital"));
		
		admin ad= new admin(nom,prenom,email,sexe,num_tel,region,date_naiss,id,password,num_hopital);
		metieradmin ad1=new metieradmin();
		ad1.Modifieradmin(ad);
		response.sendRedirect("/rendez_vous/liste_admin");
	}

}
