package models.carteBancaire;

public class Pays {
	String nom;
	double PIB;
	long population;
	double pourcentage;
	public Pays(String nom, double pIB, long population, double pourcentage) {
		super();
		this.nom = nom;
		PIB = pIB;
		this.population = population;
		this.pourcentage = pourcentage;
	}
	
}
