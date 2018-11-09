package medcin.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier_model.metierRDV;
import metier_model.metieradmin;
import metier_model.metiermedcin;

/**
 * Servlet implementation class pourcentage
 */
@WebServlet("/pourcentage")
public class pourcentage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pourcentage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double pourcentage_rendez_vous_pass=0;
		double pourcentage_rendez_vous_absent=0;
		
		double pourcentage_rendez_vous_annuler=0;
		double count_all=0;
		double count_all_pass=0;
		double count_all_ab=0;
		double stat_anuler=0;
		double stat_absent=0;
		double stat_pass=0;
		int num = 0;
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
	//  ----pourcentage de les rendez_vous annuler----- 	 
		metierRDV all=new metierRDV();
		ResultSet res_count_all=all.count_all_hop(id);
		try {
			while(res_count_all.next()) {
				count_all=res_count_all.getDouble(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String affect_anule="Annuler";
		metierRDV metanul=new metierRDV();
		ResultSet resmetanul=metanul.count_statistique_hop(id, affect_anule);
		try {
			while(resmetanul.next()) {
				stat_anuler=resmetanul.getDouble(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		String pour=null;
		 pourcentage_rendez_vous_annuler=((stat_anuler/count_all)*100);
		 DecimalFormat f = new DecimalFormat();
			f.setMaximumFractionDigits(0);
			 pour=f.format(pourcentage_rendez_vous_annuler);
		 
		 request.setAttribute("anule", pour);
		
		// --------------pourcentage des rendez vous de les patient absent-----------
		
		 metierRDV all_ab=new metierRDV();
			ResultSet res_count_ab=all_ab.count_all_hop(id);
			try {
				while(res_count_ab.next()) {
					count_all_ab=res_count_ab.getDouble(1);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			metierRDV metab=new metierRDV();
			ResultSet resmetab=metab.count_statistique_hop_absent_med(id);
			try {
				while(resmetab.next()) {
					stat_absent=resmetab.getDouble(1);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			String pour_ab=null;
			 pourcentage_rendez_vous_absent=((stat_absent/count_all_ab)*100);
			 DecimalFormat s = new DecimalFormat();
				s.setMaximumFractionDigits(0);
				 pour_ab=s.format(pourcentage_rendez_vous_absent);
			 
			 request.setAttribute("absent", pour_ab);
		
		//----------------pourcentage des rendez vous de les patient present------------
			 
			 metierRDV all_pass=new metierRDV();
				ResultSet res_count_pass=all_pass.count_all_hop(id);
				try {
					while(res_count_pass.next()) {
						count_all_pass=res_count_pass.getDouble(1);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				String affect_pass="Passer";
				metierRDV metpass=new metierRDV();
				ResultSet resmetpass=metpass.count_statistique_hop(id, affect_pass);
				try {
					while(resmetpass.next()) {
						stat_pass=resmetpass.getDouble(1);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				String pour_pass=null;
				 pourcentage_rendez_vous_pass=((stat_pass/count_all_pass)*100);
				 DecimalFormat p = new DecimalFormat();
					p.setMaximumFractionDigits(0);
					 pour_pass=s.format(pourcentage_rendez_vous_pass);
				 
				 request.setAttribute("pass", pour_pass);
			
			 
			 
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/pourcentage_medcin.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
