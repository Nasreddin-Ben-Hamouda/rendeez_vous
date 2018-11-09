package Models;

public class patient extends personne {


private int matricule;

    public patient(String nom, String prenom, String email, String sexe, int num_tel, String region,
		String date_naiss,int matricule) {
     	super(nom, prenom, email, sexe, num_tel, region, date_naiss);
	    this.matricule=matricule;
}
    public patient(String nom, String prenom, String email, String sexe, int num_tel, String region,
    		String date_naiss) {
         	super(nom, prenom, email, sexe, num_tel, region, date_naiss);
    	    
    }
	
	public patient(String email,String date_naiss) {
		super(email,date_naiss);
		
	}
	public patient(int matricule) {
		this.matricule=matricule;
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
    public String toString() {
		
		return super.toString()+"[Matricule: "+this.matricule+"]";
	}
}
