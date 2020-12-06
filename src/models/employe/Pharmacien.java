package models.employe;

public class Pharmacien extends Employe {
	int salaire;
	int nbVente;
	public Pharmacien(String nom, String prenom, String adresse, int salaire) {
		super(nom, prenom, adresse);
		this.salaire = salaire;
		this.nbVente = 0;
	}
	@Override
	public int getSalaire() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
