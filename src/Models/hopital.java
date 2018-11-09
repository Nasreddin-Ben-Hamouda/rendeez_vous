package Models;

public class hopital {
	private int num_hopital;
	private String nom;
	private String region;
	private String adresse;
	private String specialit�;
	
	
    public hopital(String specialite) {
		
		this.specialit�=specialite;
	}
	public hopital(int num_hopital, String nom, String region, String adresse,String specialit�) {
		
		this.num_hopital = num_hopital;
		this.nom = nom;
		this.region = region;
		this.adresse = adresse;
		this.specialit�= specialit�;
	}
	public hopital(String region,String specialite) {
		this.region=region;
		this.specialit�=specialite;
	}
	
	public int getNum_hopital() {
		return num_hopital;
	}
	public void setNum_hopital(int num_hopital) {
		this.num_hopital = num_hopital;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSpecialite() {
		return specialit�;
	}
	public void setSpecialite(String Specialite) {
		this.specialit� = Specialite;
	}
	@Override
	public String toString() {
		
		return "[Nom: "+this.nom+", Num: "+this.num_hopital+", Region: "+this.region+",Adresse:"+this.adresse+",Specialit�:"+this.specialit�+"]";
	}
	

}
