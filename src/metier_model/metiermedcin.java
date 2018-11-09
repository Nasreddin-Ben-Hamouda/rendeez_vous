package metier_model;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.medcin;
import Models.patient;
import Models.personne;

public class metiermedcin {
	private Connection con=null;
	private  PreparedStatement st=null;
	private ResultSet result = null;
	
	public metiermedcin () throws RemoteException {
		super();
		this.con = SingletonConnection.getConnetion();
	}
	
	public void Ajoutermedcint(medcin a) throws RemoteException {
		try {
			this.st = con.prepareStatement("INSERT INTO medcin(nom,prenom,email,sexe,date_naiss,region,num_tel,id_hopital) VALUES (?,?,?,?,?,?,?,?)");
			st.setInt(8,a.getNum_hopital());
			st.setString(1, a.getNom());
			st.setString(2, a.getPrenom());
			st.setString(3, a.getEmail());
			st.setString(4, a.getSexe());
			st.setInt(7, a.getNum_tel());
			st.setString(6, a.getRegion());
			st.setString(5, a.getDate_naiss());			
		
			int numRows = st.executeUpdate();
			if(numRows == 1) {
				System.out.println("Ajout avec success");
			}
		}catch(SQLException sql) {
			sql.printStackTrace();
			
		}
	}

	public ArrayList<personne> AfficherListe(int num,int id) throws RemoteException {
		ArrayList<personne> medcin = new ArrayList<>();
		try {
			this.st = con.prepareStatement("SELECT * FROM medcin where id_hopital=? and id_medcin!=?");
			st.setInt(1, num);
			st.setInt(2, id);
			this.result = st.executeQuery();
			while(this.result.next()) {
				medcin.add(new medcin(this.result.getString("nom"),this.result.getString("prenom"),this.result.getString("email"),this.result.getString("sexe"),this.result.getInt("num_tel"),this.result.getString("region"),this.result.getString("date_naiss"),this.result.getInt("id_medcin"),this.result.getInt("id_hopital")));
			}
			
		}catch(SQLException sql) {
			
			sql.printStackTrace();
		}
		
		return medcin;
	}
	
	public ArrayList<personne> AfficherListe1(int num) throws RemoteException {
		ArrayList<personne> medcin = new ArrayList<>();
		try {
			this.st = con.prepareStatement("SELECT * FROM medcin where id_hopital=? ");
			st.setInt(1, num);
		
			this.result = st.executeQuery();
			while(this.result.next()) {
				medcin.add(new medcin(this.result.getString("nom"),this.result.getString("prenom"),this.result.getString("email"),this.result.getString("sexe"),this.result.getInt("num_tel"),this.result.getString("region"),this.result.getString("date_naiss"),this.result.getInt("id_medcin"),this.result.getInt("id_hopital")));
			}
			
		}catch(SQLException sql) {
			
			sql.printStackTrace();
		}
		
		return medcin;
	}
	public boolean connexion_medcin(String email,String date) throws RemoteException {
		//ArrayList<personne> admin = new ArrayList<>();
	 boolean test=false;
		try {
			this.st = con.prepareStatement("SELECT email,date_naiss FROM medcin where email=? and date_naiss=?");
			
			st.setString(1,email);
			st.setString(2, date);
			this.result=st.executeQuery();
		   if(this.result.next()) {
				
				test=true;
			}
			else {
				test=false;
			}
			
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		
	
		return test;
	}
	public ResultSet id_medcin(String email) throws RemoteException {
		try {
			this.st = con.prepareStatement("select id_medcin from medcin where email=?");
			
			st.setString(1,email );
			this.result=st.executeQuery();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		} 
		return result;

}
	public ResultSet num_hop(String email) throws RemoteException {
		try {
			this.st = con.prepareStatement("select id_hopital from medcin where email=?");
			
			st.setString(1,email );
			this.result=st.executeQuery();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		} 
		return result;

}
	

}
