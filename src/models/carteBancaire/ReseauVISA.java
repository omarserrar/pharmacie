package models.carteBancaire;

public class ReseauVISA extends ReseauBancaire {
	Pays pays;

	public ReseauVISA(Pays pays) {
		super();
		this.pays = pays;
	}
	public int getRemboursement(int somme) {
		return (int) ((int)somme * pays.pourcentage);
	}
}
