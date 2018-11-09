package Models;

public class admin extends personne{
	
 private int id_admin;
 private String password;
 private int num_hopital;
public admin(int id_admin) {
	super();
	this.id_admin=id_admin;
} 
public admin(String email,String password) {
	super(email);
	this.password=password;
}
public admin(String nom, String prenom, String email, String sexe, int num_tel, String region, String date_naiss) {
	super(nom, prenom, email, sexe, num_tel, region, date_naiss);
	// TODO Auto-generated constructor stub
}
public admin(String email) {
	super(email);
	// TODO Auto-generated constructor stub
}
public admin(String nom, String prenom, String email, String sexe, int num_tel, String region, String date_naiss,int id_admin,String password,int num_hopital) {
	super(nom, prenom, email, sexe, num_tel, region, date_naiss);
	this.id_admin=id_admin;
	this.password=password;
	this.num_hopital=num_hopital;
}
public admin(String nom, String prenom, String email, String sexe, int num_tel, String region, String date_naiss,String password,int num_hopital) {
	super(nom, prenom, email, sexe, num_tel, region, date_naiss);
	
	this.password=password;
	this.num_hopital=num_hopital;
}
public int getId_admin() {
	return id_admin;
}
public void setId_admin(int id_admin) {
	this.id_admin = id_admin;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public int getNum_hopital() {
	return num_hopital;
}
public void setNum_hopital(int num_hopital) {
	this.num_hopital = num_hopital;
}

public String toString() {
	
	return super.toString()+"[Id: "+this.id_admin+", Password: "+this.password+",Num_hopital:"+this.num_hopital+"]";
}


}
