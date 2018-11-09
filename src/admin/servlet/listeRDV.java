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

import metier_model.metierRDV;
import metier_model.metieradmin;

/**
 * Servlet implementation class listeRDV
 */
@WebServlet("/liste_RDV")
public class listeRDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listeRDV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email="";
		int num = 0;
		HttpSession session=request.getSession();
		 email=(String)session.getAttribute("email");
		if(email=="") {
			response.sendRedirect("/rendez_vous/login_admin");
		}
		metieradmin m=new metieradmin();
		ResultSet res=m.select_hopital_admin(email);
		try {
			while(res.next()) {
				 num=res.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		metierRDV rend= new metierRDV();
		
		ResultSet result=rend.select_rendez_admin(num);
		request.setAttribute("rend", result);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/listeRDV.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num_rdv"));
		metierRDV r=new metierRDV();
		r.modifier_rendez_vous(num);
		response.sendRedirect("/rendez_vous/liste_RDV");
		
	}

}
