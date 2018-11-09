package Models;

public class medcin extends personne {

private int id_medcin;
private int num_hopital;


public medcin(String nom, String prenom, String email, String sexe, int num_tel, String region, String date_naiss,int id_medcin,int num_hopital) {
	super(nom, prenom, email, sexe, num_tel, region, date_naiss);
	this.id_medcin=id_medcin;
	this.num_hopital=num_hopital;
	
}
public medcin(String nom, String prenom, String email, String sexe, int num_tel, String region, String date_naiss,int num_hopital) {
	super(nom, prenom, email, sexe, num_tel, region, date_naiss);
	
	this.num_hopital=num_hopital;
	
}


public int getId_medcin() {
	return id_medcin;
}

public void setId_medcin(int id_medcin) {
	this.id_medcin = id_medcin;
}

public int getNum_hopital() {
	return num_hopital;
}

public void setNum_hopital(int num_hopital) {
	this.num_hopital = num_hopital;
}


public String toString() {
	
	return super.toString()+"[Id: "+this.id_medcin+",Num_hopital:"+this.num_hopital+"]";
}

}
