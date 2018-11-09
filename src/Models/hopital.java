package Models;

public class hopital {
	private int num_hopital;
	private String nom;
	private String region;
	private String adresse;
	private String specialité;
	
	
    public hopital(String specialite) {
		
		this.specialité=specialite;
	}
	public hopital(int num_hopital, String nom, String region, String adresse,String specialité) {
		
		this.num_hopital = num_hopital;
		this.nom = nom;
		this.region = region;
		this.adresse = adresse;
		this.specialité= specialité;
	}
	public hopital(String region,String specialite) {
		this.region=region;
		this.specialité=specialite;
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
		return specialité;
	}
	public void setSpecialite(String Specialite) {
		this.specialité = Specialite;
	}
	@Override
	public String toString() {
		
		return "[Nom: "+this.nom+", Num: "+this.num_hopital+", Region: "+this.region+",Adresse:"+this.adresse+",Specialité:"+this.specialité+"]";
	}
	

}
