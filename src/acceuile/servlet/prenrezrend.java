package acceuile.servlet;

import java.io.IOException;



import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.RDV;


import metier_model.metierRDV;

import metier_model.metierpatient;



/**
 * Servlet implementation class prenrezrend
 */
@WebServlet("/prendre_rendez_vous")
public class prenrezrend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prenrezrend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/prendrend.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mat = 0;
		
		String email=request.getParameter("email");
		//System.out.println(email);
		//date
		/*DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date today = new Date();
		try {
			Date todayWithZeroTime = formatter.parse(formatter.format(today));
			System.out.println(todayWithZeroTime);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	java.sql.Timestamp timestamp= null; 
		java.util.Date date= new java.util.Date(timestamp.getTime()); 
		String sToday = date.toString();*/
		
		
		metierpatient a1=new metierpatient();
		ResultSet array=a1.select_patient_connect(email);
		
		try {
			while(array.next()) {
				 mat=array.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//System.out.println(mat);
		//boolean testmsg=false;
		String verifdate="";
		String msg="";
		String reg=request.getParameter("reg");
		String spec=request.getParameter("serv");
		int num_hop=Integer.parseInt(request.getParameter("hop"));
		int id_med=Integer.parseInt(request.getParameter("med"));
		String date= request.getParameter("date");
		String time= request.getParameter("time");
		String affectation="En Attent";
		String etat="Pas encore confirmer";
	    String vue_admin="non";
	    metierRDV test=new metierRDV();
	    boolean verif=test.test_date(date, time,num_hop,id_med);
	   
	    if(verif) {
	    	verifdate="Durant cette méme date,le médecin est occupé par une autre rendez-vous";
	    	//testmsg=true;
	    	//request.setAttribute("testmsg", testmsg);
	    	request.setAttribute("verifdate", verifdate);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/prendrend.jsp" ).forward( request, response );
			
			
	    }
	    else {
		RDV rend=new RDV(mat,num_hop,id_med,date,time,affectation,reg,spec,etat,vue_admin);
		metierRDV m=new metierRDV();
		if(m.AjouterRDV(rend)) {
		response.sendRedirect("/rendez_vous/gerer_rendez_vous");
		}
		else {
			
			msg="Erreur";
			request.setAttribute("msg", msg);
			response.sendRedirect("/rendez_vous/prendre_rendez_vous");
		}
	    }
	    
	    //System.out.println(rend);
	}
 
}
