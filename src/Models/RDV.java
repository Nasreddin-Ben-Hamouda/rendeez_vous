package Models;

public class RDV {
	private int num_rdv;
	private int mat_patient;
	
	private int num_hopital;
	private int id_medcin;
	private String date_rdv;
	private String heure_rdv;
	private String affectation;
	private String region;
	private String nature;
	private String etat;
	private String vu_admin;
	
	
	public RDV(int num_rdv, int mat_patient, int num_hopital, int id_medcin, String date_rdv,
			String heure_rdv,String affectation,String region,String nature,String etat,String vu_admin) {
		
		this.num_rdv = num_rdv;
		this.mat_patient = mat_patient;
		
		this.num_hopital = num_hopital;
		this.id_medcin = id_medcin;
		this.date_rdv = date_rdv;
		this.heure_rdv = heure_rdv;
		this.affectation=affectation;
		this.region=region;
		this.nature=nature;
		this.etat=etat;
		this.vu_admin=vu_admin;
	}
	
	public RDV( int mat_patient, int num_hopital, int id_medcin, String date_rdv,
			String heure_rdv,String affectation,String region,String nature,String etat,String vu_admin) {
		
		
		this.mat_patient = mat_patient;
		
		this.num_hopital = num_hopital;
		this.id_medcin = id_medcin;
		this.date_rdv = date_rdv;
		this.heure_rdv = heure_rdv;
		this.affectation=affectation;
		this.region=region;
		this.nature=nature;
		this.etat=etat;
		this.vu_admin=vu_admin;
	}
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getVu_admin() {
		return vu_admin;
	}

	public void setVu_admin(String vu_admin) {
		this.vu_admin = vu_admin;
	}

	public String getAffectation() {
		return affectation;
	}
	public void setAffectation(String affectation) {
		this.affectation = affectation;
	}
	public int getNum_rdv() {
		return num_rdv;
	}
	public void setNum_rdv(int num_rdv) {
		this.num_rdv = num_rdv;
	}
	public int getMat_patient() {
		return mat_patient;
	}
	public void setMat_patient(int mat_patient) {
		this.mat_patient = mat_patient;
	}
	
	public int getNum_hopital() {
		return num_hopital;
	}
	public void setNum_hopital(int num_hopital) {
		this.num_hopital = num_hopital;
	}
	public int getId_medcin() {
		return id_medcin;
	}
	public void setId_medcin(int id_medcin) {
		this.id_medcin = id_medcin;
	}
	public String getDate_rdv() {
		return date_rdv;
	}
	public void setDate_rdv(String date_rdv) {
		this.date_rdv = date_rdv;
	}
	public String getHeure_rdv() {
		return heure_rdv;
	}
	public void setHeure_rdv(String heure_rdv) {
		this.heure_rdv = heure_rdv;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	
	public String toString() {
		
		return "[Num: "+this.num_rdv+", Matricule_patient: "+this.mat_patient+",Num_hopital:"+this.num_hopital+",Id_medcin:"+this.id_medcin+",Date:"+this.date_rdv+",Heure_rdv:"+this.heure_rdv+",affectation:"+this.affectation+",region:"+this.region+",nature:"+this.nature+"]";
	}
	

}
