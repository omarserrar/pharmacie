package models.pharmacie;

import models.employe.Pharmacien;

public class PharmacieIndependenteFactory extends PharmacieFactory {
	public Pharmacie createPharmacie(String nom, int nombreEmployees, int surfaceCommerciel, String siret, Pharmacien pharmacien) {
		return new PharmacieIndependente(nom, nombreEmployees, surfaceCommerciel, siret, pharmacien);
	}
}
