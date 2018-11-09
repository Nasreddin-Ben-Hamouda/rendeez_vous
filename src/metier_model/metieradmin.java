package metier_model;

import java.rmi.RemoteException;


import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import Models.admin;
import Models.patient;
import Models.personne;

public class metieradmin extends UnicastRemoteObject  {
	
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private  PreparedStatement st=null;
	private ResultSet result = null;
	
	public metieradmin () throws RemoteException {
		super();
		this.con = SingletonConnection.getConnetion();
	}
	
	
	public ArrayList<personne> AfficherListe() throws RemoteException {
		ArrayList<personne> admin = new ArrayList<>();
		try {
			this.st = con.prepareStatement("SELECT * FROM admin");
			this.result = st.executeQuery();
			while(this.result.next()) {
				admin.add(new admin(this.result.getString("nom"),this.result.getString("prenom"),this.result.getString("email"),this.result.getString("sexe"),this.result.getInt("num_tel"),this.result.getString("region"),this.result.getString("date_naiss"),this.result.getInt("id_admin"),this.result.getString("password"),this.result.getInt("num_hopital_respons")));
			}
			
		}catch(SQLException sql) {
			
			sql.printStackTrace();
		}
		
		return admin;
	}
	public void Ajouteradmin(admin a) throws RemoteException {
		try {
			this.st = con.prepareStatement("INSERT INTO admin(nom,prenom,email,password,sexe,date_naiss,region,num_hopital_respons,num_tel) VALUES (?,?,?,?,?,?,?,?,?)");
			st.setString(1, a.getNom());
			st.setString(2, a.getPrenom());
			st.setString(3, a.getEmail());
			st.setString(5, a.getSexe());
			st.setInt(9, a.getNum_tel());
			st.setString(7, a.getRegion());
			st.setString(6, a.getDate_naiss());
			st.setString(4, a.getPassword());
			st.setInt(8, a.getNum_hopital());
			int numRows = st.executeUpdate();
			if(numRows == 1) {
				System.out.println("Ajout avec success");
			}
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
	}
		public void Modifieradmin(admin a) throws RemoteException {
			try {
				this.st = con.prepareStatement("UPDATE admin SET nom=?,prenom=?,email=?,password=?,sexe=?,region=?,date_naiss=?,num_hopital_respons=?,num_tel=? WHERE id_admin=?");
				st.setString(1, a.getNom());
				st.setString(2, a.getPrenom());
				st.setString(3, a.getEmail());
				st.setString(5, a.getSexe());
				st.setInt(9, a.getNum_tel());
				st.setString(6, a.getRegion());
				st.setString(7, a.getDate_naiss());
				st.setString(4, a.getPassword());
				st.setInt(8, a.getNum_hopital());
				st.setInt(10, a.getId_admin());
				st.executeUpdate();
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			}
			
			
		}
		public void supprimeradmin(admin a) throws RemoteException {
			try {
				this.st = con.prepareStatement("DELETE FROM admin where id_admin=?");
				
				st.setInt(1, a.getId_admin());
				st.executeUpdate();
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			}
			
			
			
		}
		public ArrayList<personne>  select_special_admin( admin a) throws RemoteException {
			ArrayList<personne> admin = new ArrayList<>();
			
			try {
				this.st = con.prepareStatement("SELECT * FROM admin where id_admin=?");
				
				st.setInt(1, a.getId_admin());
				this.result=st.executeQuery();
				while(this.result.next()) {
					admin.add(new admin(this.result.getString("nom"),this.result.getString("prenom"),this.result.getString("email"),this.result.getString("sexe"),this.result.getInt("num_tel"),this.result.getString("region"),this.result.getString("date_naiss"),this.result.getInt("id_admin"),this.result.getString("password"),this.result.getInt("num_hopital_respons")));
				}
				
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			}
			
			return admin;
			
		}
		public boolean login( admin a) throws RemoteException {
			//ArrayList<personne> admin = new ArrayList<>();
		 boolean test=false;
			try {
				this.st = con.prepareStatement("SELECT email,password FROM admin where email=? and password=?");
				
				st.setString(1, a.getEmail());
				st.setString(2, a.getPassword());
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
		
		public ArrayList<personne> select_admin( String nom) throws RemoteException {
			ArrayList<personne> admin = new ArrayList<>();
			
			try {
				this.st = con.prepareStatement("SELECT * FROM admin where nom=? ");
				
				st.setString(1, nom);
				this.result=st.executeQuery();
				while(this.result.next()) {
					admin.add(new admin(this.result.getString("nom"),this.result.getString("prenom"),this.result.getString("email"),this.result.getString("sexe"),this.result.getInt("num_tel"),this.result.getString("region"),this.result.getString("date_naiss"),this.result.getInt("id_admin"),this.result.getString("password"),this.result.getInt("num_hopital_respons")));
				}
				
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			}
			
			return admin;
			
		}
		public ResultSet  select_hopital_admin( String email) throws RemoteException {
			
			
			try {
				this.st = con.prepareStatement("SELECT num_hopital_respons FROM admin where email=?");
				
				st.setString(1, email);
				this.result=st.executeQuery();
				
				
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			}
			
			return result;
			
		}
		
}
