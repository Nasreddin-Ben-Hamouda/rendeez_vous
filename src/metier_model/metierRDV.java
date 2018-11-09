package metier_model;

import java.rmi.RemoteException;




import java.rmi.server.UnicastRemoteObject;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;

import Models.RDV;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import metier_model.SingletonConnection;

public class metierRDV extends UnicastRemoteObject  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private  PreparedStatement st=null;
	private ResultSet result=null;

	
	public metierRDV () throws RemoteException {
		super();
		this.con = SingletonConnection.getConnetion();
	}
	
	
	
	public boolean AjouterRDV(RDV a) throws RemoteException {
		boolean test=false;
		try {
			this.st = con.prepareStatement("INSERT INTO rdv(matricule_patinet,num_hopital,id_medcin,date_rdv,time,affectation,region,nature_rdv,etat,vue_admin) VALUES (?,?,?,?,?,?,?,?,?,?)");
		
			st.setInt(1, a.getMat_patient());
			st.setInt(2, a.getNum_hopital());
			st.setInt(3, a.getId_medcin());
			st.setString(4, a.getDate_rdv());
			st.setString(5, a.getHeure_rdv());
			st.setString(6, a.getAffectation());
			st.setString(7, a.getRegion());
			st.setString(8, a.getNature());
			st.setString(9, a.getEtat());
			st.setString(10, a.getVu_admin());
			
			int numRows = st.executeUpdate();
			if(numRows>0) {
				test=true;
				System.out.println("Ajout avec success");
			}
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
		
	
		return test;
	}
	public ResultSet select_rendez_vous(String email) throws RemoteException {
		
		
		try {
			this.st = con.prepareStatement("SELECT r.num_rdv,h.nom,m.nom,m.prenom,r.date_rdv,r.time,r.affectation,r.region,r.etat FROM patient p,rdv r,hopitale h,medcin m where p.matricule=r.matricule_patinet and h.num_hopitale=r.num_hopital AND h.num_hopitale=m.id_hopital and r.id_medcin=m.id_medcin and p.email=? and r.affectation like'%En Attent%'");
			
			st.setString(1, email);
			this.result=st.executeQuery();
			
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		
		return result;
		
	}
	public void anuler(int num) throws RemoteException {
		try {
			this.st = con.prepareStatement("Update rdv set affectation='Annuler' where num_rdv=?");
			
			st.setInt(1, num);
			st.executeUpdate();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		

     }
public ResultSet select_rendez_admin(int num) throws RemoteException {
		
		
		try {
			this.st = con.prepareStatement("SELECT r.num_rdv,p.nom,p.prenom,m.nom,m.prenom,r.date_rdv,r.time,r.etat FROM patient p,rdv r,hopitale h,medcin m where h.num_hopitale=m.id_hopital AND h.num_hopitale=r.num_hopital and r.id_medcin=m.id_medcin and r.matricule_patinet=p.matricule and h.num_hopitale=? and r.affectation like'%En Attent%' ");
			
			st.setInt(1, num);
			this.result=st.executeQuery();
			
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		
		return result;
		
	}
public void modifier_rendez_vous(int num) throws RemoteException {
	try {
		this.st = con.prepareStatement("UPDATE rdv set affectation='Passer' where num_rdv=?");
		
		st.setInt(1, num);
		st.executeUpdate();
	}
	catch(SQLException sql) {
		sql.printStackTrace();
	}
	}
	public void modifier_etat_rdv(int num) throws RemoteException {
		try {
			this.st = con.prepareStatement("UPDATE rdv set etat='Confirmer' where num_rdv=?");
			
			st.setInt(1, num);
			st.executeUpdate();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}

 }
	public void modifier_etat_rdv2(int num) throws RemoteException {
		try {
			this.st = con.prepareStatement("UPDATE rdv set etat='Refuser a cause de probleme du service' where num_rdv=?");
			
			st.setInt(1, num);
			st.executeUpdate();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
	}
		public ResultSet select_mat_patient(String nom) throws RemoteException {
			try {
				this.st = con.prepareStatement("select matricule from patient where nom like ?");
				
				st.setString(1,"%" + nom +"%" );
				this.result=st.executeQuery();
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			} 
			return result;

}
		public ResultSet select_natur(int num) throws RemoteException {
			try {
				this.st = con.prepareStatement("select specialite from hopitale where num_hopitale=?");
				
				st.setInt(1,num );
				this.result=st.executeQuery();
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			} 
			return result;

}
		
		
		public ResultSet medcin(int num) throws RemoteException {
			try {
				this.st = con.prepareStatement("select id_medcin,nom,prenom from medcin where id_hopital=?");
				
				st.setInt(1,num );
				this.result=st.executeQuery();
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			} 
			return result;

}
		
		
		public ArrayList<RDV> select_notification(int num) throws RemoteException {
			ArrayList<RDV> array=new ArrayList<>();
			try {
				this.st = con.prepareStatement("select * from rdv where num_hopital=? and vue_admin='non'");
				
				st.setInt(1,num );
				this.result=st.executeQuery();
				while(result.next()) {
					array.add(new RDV(this.result.getInt("num_rdv"),this.result.getInt("mat_patient"),this.result.getInt("num_hopital"),this.result.getInt("id_medcin"),this.result.getString("date_rdv"),this.result.getString("heure_rdv"),this.result.getString("affectation"),this.result.getString("region"),this.result.getString("nature"),this.result.getString("etat"),this.result.getString("vu_admin")));
				}
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			} 
			return array;

}
		public ResultSet select_coun_notification(int num) throws RemoteException {
			
			try {
				this.st = con.prepareStatement("select count(*) from rdv where num_hopital=? and vue_admin='non'");
				
				st.setInt(1,num );
				this.result=st.executeQuery();
				while(result.next()){
	                System.out.println(result.getInt(1));
	            }
				
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			} 
			return result;

}
	public boolean test_date(String date,String heure,int num_hop,int id_med) throws RemoteException {
			boolean test=false;
			try {
				this.st = con.prepareStatement("select date_rdv,time from rdv where date_rdv=? and time=? and num_hopital=? and id_medcin=? ");
				
				st.setString(1,date );
				st.setString(2,heure );
				st.setInt(3, num_hop);
				st.setInt(4, id_med);
				this.result=st.executeQuery();
				while(result.next()){
	               test=true;
	            }
				
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			} 
			return test;

}
	
	public ResultSet RDVmedecin(int id) throws RemoteException {
		try {
			this.st = con.prepareStatement("select r.num_rdv,p.nom,p.prenom,r.date_rdv,r.time,r.etat from rdv r,patient p where r.matricule_patinet=p.matricule and r.id_medcin=? and r.affectation like '%En Attent%'");
			
			st.setInt(1,id );
			this.result=st.executeQuery();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		} 
		return result;

}
	
	//------------------ rendez vou par hopital---------------------------
	public ResultSet count_all_hop(int num) throws RemoteException {
		try {
			this.st = con.prepareStatement("select count(*) from rdv where num_hopital=?");
			
			st.setInt(1,num );
			this.result=st.executeQuery();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		} 
		return result;

}
	public ResultSet count_statistique_hop(int num ,String affect) throws RemoteException {
		try {
			this.st = con.prepareStatement("select count(*) from rdv where num_hopital=? and affectation=?");
			
			st.setInt(1,num );
			st.setString(2,affect);
			this.result=st.executeQuery();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		} 
		return result;

}
	public ResultSet count_statistique_hop_absent(int num ) throws RemoteException {
		try {
			this.st = con.prepareStatement("select count(*) from rdv where num_hopital=? and affectation='En Attent' and date_rdv<CURDATE()");
			
			st.setInt(1,num );
			
			this.result=st.executeQuery();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		} 
		return result;

}
	//------------------ rendez vou par medcin---------------------------
	public ResultSet count_all_hop_med(int id) throws RemoteException {
		try {
			this.st = con.prepareStatement("select count(*) from rdv where id_medcin=?");
			
			st.setInt(1,id );
			this.result=st.executeQuery();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		} 
		return result;

}
	public ResultSet count_statistique_hop_med(int id ,String affect) throws RemoteException {
		try {
			this.st = con.prepareStatement("select count(*) from rdv where id_medcin=? and affectation=?");
			
			st.setInt(1,id );
			st.setString(2,affect);
			this.result=st.executeQuery();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		} 
		return result;

}
	public ResultSet count_statistique_hop_absent_med(int id ) throws RemoteException {
		try {
			this.st = con.prepareStatement("select count(*) from rdv where id_medcin=? and affectation='En Attent' and date_rdv <CURDATE()");
			
			st.setInt(1,id );
			
			this.result=st.executeQuery();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		} 
		return result;

}
		}
