package models.pharmacie;

import models.employe.Pharmacien;

public abstract class PharmacieFactory {
	public abstract Pharmacie createPharmacie(String nom, int nombreEmployees, int surfaceCommerciel, String siret, Pharmacien pharmacien);
}
