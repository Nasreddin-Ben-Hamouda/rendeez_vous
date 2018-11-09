package acceuile.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


import Models.personne;

import metier_model.metiermedcin;

/**
 * Servlet implementation class selectmedcin
 */
@WebServlet("/select_medcin")
public class selectmedcin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectmedcin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num_hopital=Integer.parseInt(request.getParameter("num_hop"));
		
            // System.out.println(num_hopital);
		 metiermedcin med = new metiermedcin();
		 List<personne> medArray = med.AfficherListe1(num_hopital);
		 System.out.println(medArray.size());
		 request.setAttribute("medArray",medArray );
		// HashMap<String,hopital> data = new HashMap<>();
		// Iterator<hopital> it= hopitalArray.iterator();
		 Gson j = new Gson();
		 String res =j.toJson(medArray);
		 
		 
		 /*JsonArray ja= new JsonArray();
		 while(it.hasNext()) {
			 JsonElement jse = it.next();
			 ja.add(new JsonElement(it.next()));
			 
			 
		 }*/
		
		 

		 
		 response.setContentType("application/json");
		 //System.out.println("hamza");
			response.getWriter().write(res);

}
	}
