package Models;

public class personne {
	private String nom;
	 private String prenom;
	 private String email;
	 private String sexe;
	 private int num_tel;
	 private String region;
	 private String date_naiss;
	 
	 public personne() {}
	 public personne(String nom,String prenom,String email,String sexe,int num_tel,String region, String date_naiss) {
		 this.nom=nom;
		 this.prenom=prenom;
		 this.email=email;
		 this.sexe=sexe;
		 this.num_tel=num_tel;
		 this.region=region;
		 this.date_naiss=date_naiss;
	 }
	 public personne(String email) {
		 this.email=email;
	 }
	 public personne(String email,String date_naiss) {
		 this.email=email;
		 this.date_naiss=date_naiss;
	 }



	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public int getNum_tel() {
		return num_tel;
	}


	public void setNum_tel(int num_tel) {
		this.num_tel = num_tel;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}
	public String getDate_naiss() {
		return date_naiss;
	}
	public void setDate_naiss(String date_naiss) {
		this.date_naiss = date_naiss;
	}

	
	public String toString() {
		
		return  "[Nom: "+this.nom+", Prenom: "+this.prenom+", Email: "+this.email+",Sexe:"+this.sexe+",Num_tel:"+this.num_tel+",Region:"+this.region+"]";
	}
	 

}
