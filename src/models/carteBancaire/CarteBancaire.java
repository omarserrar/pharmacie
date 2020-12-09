package models.carteBancaire;

public class CarteBancaire {
	protected ReseauBancaire reseauBancaire;
	int solde = 0;
	public CarteBancaire(ReseauBancaire reseauBancaire, int solde) {
		super();
		this.reseauBancaire = reseauBancaire;
		this.solde = solde;
	}
	public boolean payer(int somme) {
		if(solde<somme) return false;
		solde = solde - somme;
		return true;
	}
	public int getRemboursement(int somme) {
		solde += somme;
		return somme;
	}
}
