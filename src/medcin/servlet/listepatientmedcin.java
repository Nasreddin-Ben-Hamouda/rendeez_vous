package medcin.servlet;

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

import Models.personne;
import metier_model.metiermedcin;
import metier_model.metierpatient;

/**
 * Servlet implementation class listepatientmedcin
 */
@WebServlet("/liste_patient_medcin")
public class listepatientmedcin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listepatientmedcin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		HttpSession session=request.getSession();
		String email= (String) session.getAttribute("emailmedcin");
		//System.out.println(email);
		metiermedcin med=new metiermedcin();
		ResultSet res=med.id_medcin(email);
		try {
			while(res.next()) {
				id=res.getInt(1);
				//System.out.println(res.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		metierpatient pat = new metierpatient();
		List<personne> adminArray = pat.AfficherListe_patient_par_medcin(id);
	
		request.setAttribute("adminArray",adminArray );
		
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/listepatientmedcin.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
