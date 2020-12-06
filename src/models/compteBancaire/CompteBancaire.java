package models.compteBancaire;

public abstract class CompteBancaire {
	private int solde;

	public int getSolde() {
		return solde;
	}
	public boolean prelever(int somme) {
		if(solde-somme<0)
			return false;
		solde -= somme;
		return true;
	}
	public int virement(int somme) {
		solde += somme;
		return solde;
	}
}
