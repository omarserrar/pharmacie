package models.pharmacie;

import models.employe.Pharmacien;

public class PharmacieFranchiseFactory extends PharmacieFactory {
	public Pharmacie createPharmacie(String nom, int nombreEmployees, int surfaceCommerciel, String siret, Pharmacien pharmacien) {
		return new PharmacieFranchisee(nom, nombreEmployees, surfaceCommerciel, siret, pharmacien);
	}
}
