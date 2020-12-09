package models.pharmacie;

import models.compteBancaire.CompteBancaireClassique;
import models.employe.Pharmacien;

public class PharmacieIndependente extends Pharmacie {
	private CompteBancaireClassique compteBancaireClassique;
	public PharmacieIndependente(String nom, int nombreEmployees, int surfaceCommerciel, String siret, Pharmacien pharmacien) {
		super(nom, nombreEmployees, surfaceCommerciel, siret, pharmacien);
		// TODO Auto-generated constructor stub
	}

	public CompteBancaireClassique getCompteBancaireClassique() {
		return compteBancaireClassique;
	}

	public void setCompteBancaireClassique(CompteBancaireClassique compteBancaireClassique) {
		this.compteBancaireClassique = compteBancaireClassique;
	}

	public PharmacieIndependente() {
	}
	public String toString() {
		String info = super.toString();
		info += "Compte Bancaire Classique:\t"+((compteBancaireClassique!=null)?compteBancaireClassique.getSolde():"Aucun")+"\n";
		return info;
	}
}
