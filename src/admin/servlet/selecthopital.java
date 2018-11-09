package admin.servlet;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;

import Models.hopital;
//import jdk.incubator.http.HttpResponse;
import metier_model.metierhopital;

/**
 * Servlet implementation class selecthopital
 */
@WebServlet("/select_hopital")
public class selecthopital extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selecthopital() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/hopital.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String specialite =request.getParameter("specialite");
		String region =request.getParameter("regi");
		//String specialitev = String.valueOf(request.getAttribute("specialite"));
		//System.out.println(specialite );
	     hopital h=new hopital(region,specialite);
	     
		 metierhopital hop = new metierhopital();
		 List<hopital> hopitalArray = hop.AfficherListe(h);
		 //System.out.println(hopitalArray.size());
		 request.setAttribute("hopitalArray",hopitalArray );
		// HashMap<String,hopital> data = new HashMap<>();
		// Iterator<hopital> it= hopitalArray.iterator();
		 Gson j = new Gson();
		 String res =j.toJson(hopitalArray);
		 
		 
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
