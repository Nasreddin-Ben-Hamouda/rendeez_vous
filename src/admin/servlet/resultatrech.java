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
 * Servlet implementation class resultatrech
 */
@WebServlet("/resultat_recherche")
public class resultatrech extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resultatrech() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom= request.getParameter("q");
		
		metieradmin admin = new metieradmin();
		List<personne> adminArray = admin.select_admin(nom);
		
		request.setAttribute("adminArray",adminArray );
		request.setAttribute("nom",nom);

		this.getServletContext().getRequestDispatcher( "/WEB-INF/resultatrech.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
