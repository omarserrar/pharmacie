package models.employe;

public abstract class Employe {
	String nom;
	String prenom;
	String adresse;
	public Employe(String nom, String prenom, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	public abstract int getSalaire();
	public String toString() {
		return nom+" "+prenom;
	}
}
