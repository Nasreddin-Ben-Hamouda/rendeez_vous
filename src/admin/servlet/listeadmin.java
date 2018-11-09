package admin.servlet;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import Models.admin;
import Models.personne;
import metier_model.metieradmin;

/**
 * Servlet implementation class listeadmin
 */
@WebServlet("/liste_admin")
public class listeadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listeadmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		metieradmin admin = new metieradmin();
		List<personne> adminArray = admin.AfficherListe();
	
		request.setAttribute("adminArray",adminArray );
		//System.out.println(adminArray.get(0));
		//System.out.print(adminArray.size());
		//HttpSession session=request.getSession(false);
		//String email = (String) session.getAttribute("email");
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/listeadmin.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id_admin"));
		admin ad=new admin(id);
		metieradmin met=new metieradmin();
		met.supprimeradmin(ad);
		response.sendRedirect("/rendez_vous/liste_admin");
		
	}

}
