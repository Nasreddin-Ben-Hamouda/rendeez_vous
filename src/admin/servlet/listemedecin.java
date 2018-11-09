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



import metier_model.metieradmin;
import metier_model.metiermedcin;
import Models.medcin;
import Models.personne;

/**
 * Servlet implementation class listemedecin
 */
@WebServlet("/liste_medecin")
public class listemedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listemedecin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		metiermedcin med=new metiermedcin();
		List<personne> l=med.AfficherListe1(num);
		request.setAttribute("l", l);
		
		
		
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/listemedecin.jsp" ).forward( request, response );
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
