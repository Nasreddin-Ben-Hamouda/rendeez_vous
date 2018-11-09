package admin.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.RDV;
import metier_model.metierRDV;
import metier_model.metieradmin;

/**
 * Servlet implementation class headeradmin
 */
@WebServlet("/headeradmin")
public class headeradmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public headeradmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email="";
		 int num = 0;
			HttpSession ses=request.getSession();
			 email=(String)ses.getAttribute("email");
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
			
			int nbr=0;
			metierRDV cou=new metierRDV();
			ResultSet count=cou.select_coun_notification(num) ;
			try {
				while(count.next()){
				    nbr=count.getInt(1);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			request.setAttribute("nbr",nbr);
			
			
			metierRDV rend=new metierRDV();
			List<RDV> noti=rend.select_notification(num);
			
		    request.setAttribute("noti",noti);
		    
		    
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/headeradmin.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
