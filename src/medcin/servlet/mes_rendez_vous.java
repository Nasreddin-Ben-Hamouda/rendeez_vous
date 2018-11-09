package medcin.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier_model.metierRDV;
import metier_model.metiermedcin;

/**
 * Servlet implementation class mes_rendez_vous
 */
@WebServlet("/liste_rdv_medcin")
public class mes_rendez_vous extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mes_rendez_vous() {
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
		 metierRDV r=new metierRDV();
		 ResultSet res1=r.RDVmedecin(id);
		 request.setAttribute("res1", res1);
		 
		
		
		
		
		
		
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/liste_rendez_vous_medcin.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num_rdv"));
		metierRDV r=new metierRDV();
		r.modifier_rendez_vous(num);
		response.sendRedirect("/rendez_vous/liste_rdv_medcin");
	}

}
