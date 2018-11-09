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
import metier_model.metieradmin;
import metier_model.metiermedcin;

/**
 * Servlet implementation class mes_colege
 */
@WebServlet("/liste_colleg_medcin")
public class mes_colege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mes_colege() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=0;
		int num = 0;
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("emailmedcin");
		metiermedcin m=new metiermedcin();
		ResultSet res=m.num_hop(email);
		try {
			while(res.next()) {
				 num=res.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		metiermedcin med=new metiermedcin();
		ResultSet res1=med.id_medcin(email);
		try {
			while(res1.next()) {
				id=res1.getInt(1);
				//System.out.println(res.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		metiermedcin med1=new metiermedcin();
		List<personne> l=med1.AfficherListe(num,id);
		request.setAttribute("l", l);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/colege_medcin.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
