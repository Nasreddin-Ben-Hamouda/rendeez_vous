package metier_model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.hopital;


public class metierhopital extends UnicastRemoteObject  {
	
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private  PreparedStatement st=null;
	private ResultSet result = null;
	
	public metierhopital () throws RemoteException {
		super();
		this.con = SingletonConnection.getConnetion();
	}
	
	
	public ArrayList<hopital> AfficherListe(hopital h) throws RemoteException {
		ArrayList<hopital> hop = new ArrayList<>();
		try {
			this.st = con.prepareStatement("SELECT * FROM hopitale where  specialite=? and region like ?");
			
			st.setString(1,h.getSpecialite());
			st.setString(2,"%" +h.getRegion()+ "%");
			this.result = st.executeQuery();
			while(this.result.next()) {
				hop.add(new hopital(this.result.getInt("num_hopitale"),this.result.getString("nom"),this.result.getString("region"),this.result.getString("adresse"),this.result.getString("specialite")));
			}
			
		}catch(SQLException sql) {
			
			sql.printStackTrace();
		}
		
		return hop;
	} 
	
	
	public ArrayList<hopital> Select_all_hopital() throws RemoteException {
		ArrayList<hopital> hop = new ArrayList<>();
		try {
			this.st = con.prepareStatement("SELECT * FROM hopitale ");
			
			
			this.result = st.executeQuery();
			while(this.result.next()) {
				hop.add(new hopital(this.result.getInt("num_hopitale"),this.result.getString("nom"),this.result.getString("region"),this.result.getString("adresse"),this.result.getString("specialite")));
			}
			
		}catch(SQLException sql) {
			
			sql.printStackTrace();
		}
		
		return hop;
	} 

}
