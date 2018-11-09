package metier_model;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Models.patient;
import Models.personne;

public class metierpatient extends UnicastRemoteObject  {
	
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private  PreparedStatement st=null;
	private ResultSet result = null;
	
	public metierpatient () throws RemoteException {
		super();
		this.con = SingletonConnection.getConnetion();
	}
	
	
	public ArrayList<personne> AfficherListe(int num) throws RemoteException {
		ArrayList<personne> patient = new ArrayList<>();
		try {
			this.st = con.prepareStatement("SELECT DISTINCT p.matricule,p.nom,p.prenom,p.sexe,p.date_naiss,p.email,p.region,p.num_tel FROM patient p,rdv r,hopitale h where p.matricule=r.matricule_patinet and h.num_hopitale=r.num_hopital and h.num_hopitale=?");
			st.setInt(1,num);
			this.result = st.executeQuery();
			while(this.result.next()) {
				patient.add(new patient(this.result.getString("nom"),this.result.getString("prenom"),this.result.getString("email"),this.result.getString("sexe"),this.result.getInt("num_tel"),this.result.getString("region"),this.result.getString("date_naiss"),this.result.getInt("matricule")));
			}
			
		}catch(SQLException sql) {
			
			sql.printStackTrace();
		}
		
		return patient;
	}
	public void Ajouterpatient(patient a) throws RemoteException {
		try {
			this.st = con.prepareStatement("INSERT INTO patient(nom,prenom,email,sexe,date_naiss,region,num_tel) VALUES (?,?,?,?,?,?,?)");
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
	public boolean connexion(patient a) throws RemoteException {
		//ArrayList<personne> admin = new ArrayList<>();
	 boolean test=false;
		try {
			this.st = con.prepareStatement("SELECT email,date_naiss FROM patient where email=? and date_naiss=?");
			
			st.setString(1, a.getEmail());
			st.setString(2, a.getDate_naiss());
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
	public void supprimerpatient(patient a) throws RemoteException {
		try {
			this.st = con.prepareStatement("DELETE FROM patient where matricule=?");
			
			st.setInt(1, a.getMatricule());
			st.executeUpdate();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
	}
	
	
	public ArrayList<personne>  select_special_patient( patient a) throws RemoteException {
		ArrayList<personne> patient = new ArrayList<>();
		
		try {
			this.st = con.prepareStatement("SELECT * FROM patient where matricule=?");
			
			st.setInt(1, a.getMatricule());
			this.result=st.executeQuery();
			while(this.result.next()) {
				patient.add(new patient(this.result.getString("nom"),this.result.getString("prenom"),this.result.getString("email"),this.result.getString("sexe"),this.result.getInt("num_tel"),this.result.getString("region"),this.result.getString("date_naiss"),this.result.getInt("matricule")));
			}
			
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		
		return patient;
		
	}
	
	
	public void Modifierpatient(patient a) throws RemoteException {
		try {
			this.st = con.prepareStatement("UPDATE patient SET nom=?,prenom=?,email=?,sexe=?,region=?,date_naiss=?,num_tel=? WHERE matricule=?");
			st.setString(1, a.getNom());
			st.setString(2, a.getPrenom());
			st.setString(3, a.getEmail());
			st.setString(4, a.getSexe());
			st.setInt(7, a.getNum_tel());
			st.setString(5, a.getRegion());
			st.setString(6, a.getDate_naiss());
			st.setInt(8,a.getMatricule());
			
			st.executeUpdate();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
	}
		
		public ResultSet  select_patient_connect( String email) throws RemoteException {
			  
			
			try {
				this.st = con.prepareStatement("SELECT matricule FROM patient where email=?");
				st.setString(1, email);
				result=st.executeQuery();
				
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			}
			
			return result;
			
		}
		public ArrayList<personne> AfficherListe_patient_par_medcin(int id) throws RemoteException {
			ArrayList<personne> patient = new ArrayList<>();
			try {
				this.st = con.prepareStatement("SELECT DISTINCT p.matricule,p.nom,p.prenom,p.sexe,p.date_naiss,p.email,p.region,p.num_tel FROM patient p,rdv r where p.matricule=r.matricule_patinet and r.id_medcin=?");
				st.setInt(1,id);
				this.result = st.executeQuery();
				while(this.result.next()) {
					patient.add(new patient(this.result.getString("nom"),this.result.getString("prenom"),this.result.getString("email"),this.result.getString("sexe"),this.result.getInt("num_tel"),this.result.getString("region"),this.result.getString("date_naiss"),this.result.getInt("matricule")));
				}
				
			}catch(SQLException sql) {
				
				sql.printStackTrace();
			}
			
			return patient;
		}
	
}
