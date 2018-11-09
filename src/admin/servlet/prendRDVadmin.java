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

import Models.RDV;
import metier_model.metierRDV;
import metier_model.metieradmin;

/**
 * Servlet implementation class prendRDVadmin
 */
@WebServlet("/prend_RDV_admin")
public class prendRDVadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prendRDVadmin() {
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
		metierRDV rende=new metierRDV();
		ResultSet res1=rende.medcin(num);
		request.setAttribute("res1", res1);
		
		
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/prendRDVadmin.jsp" ).forward( request, response );
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String verifdate="";
		String natur="";
		int mat=0;
		int num = 0;
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		metieradmin m=new metieradmin();
		ResultSet res=m.select_hopital_admin(email);
		try {
			while(res.next()) {
				 num=res.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		String nom=request.getParameter("mat");
		metierRDV re=new metierRDV();
		ResultSet s=re.select_mat_patient(nom);
		try {
			while(s.next()) {
				 mat=s.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		metierRDV re2=new metierRDV();
		ResultSet s2=re2.select_natur(num);
		try {
			while(s2.next()) {
				 natur=s2.getString(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		int id_med=Integer.parseInt(request.getParameter("num_med"));
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String reg=request.getParameter("reg");
		String affect="En Attent";
		
		String etat="confirmer";
	    String vue_admin="oui";
	    metierRDV test=new metierRDV();
	    boolean verif=test.test_date(date, time,num,id_med);
	    if(verif) {
	    	verifdate="Il ya un Rendez vous a ce temps";
	    	//testmsg=true;
	    	//request.setAttribute("testmsg", testmsg);
	    	
              response.sendRedirect("/rendez_vous/prend_RDV_admin");			
			
	    }
	    else {
		RDV r=new RDV(mat,num,id_med,date,time,affect,reg,natur,etat,vue_admin);
		metierRDV ren=new metierRDV();
		if(ren.AjouterRDV(r)) {
			response.sendRedirect("/rendez_vous/liste_RDV");
		}
		else {
			response.sendRedirect("/rendez_vous/prend_RDV_admin");
		
		  }
		
		
	    }
	    request.setAttribute("verifdate", verifdate);
	    }

}
