package admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier_model.metierRDV;

/**
 * Servlet implementation class modif_rend
 */
@WebServlet("/modif_rendez_vous")
public class modif_rend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modif_rend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num=Integer.parseInt(request.getParameter("num"));
		
		metierRDV rend=new metierRDV();
		rend.modifier_etat_rdv(num);
		response.sendRedirect("/rendez_vous/liste_RDV");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num"));
		
		metierRDV rend=new metierRDV();
		rend.modifier_etat_rdv(num);
		response.sendRedirect("/rendez_vous/liste_RDV");
	}

}
