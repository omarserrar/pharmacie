package models.employe;

import java.util.Date;

public class PreparateurCommande extends Employe {
	int nbHeureSemaine;
	int salaireHeure;
	Date dateEmbauche;
	public PreparateurCommande(String nom, String prenom, String adresse, int nbHeureSemaine, int salaireHeure,
			Date dateEmbauche) {
		super(nom, prenom, adresse);
		this.nbHeureSemaine = nbHeureSemaine;
		this.salaireHeure = salaireHeure;
		this.dateEmbauche = dateEmbauche;
	}
	@Override
	public int getSalaire() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
