package models.pharmacie;

import java.util.ArrayList;

import models.compteBancaire.CompteBancaireClassique;
import models.compteBancaire.CompteBancaireFranchise;
import models.employe.Pharmacien;

public class PharmacieFranchisee extends Pharmacie {
	public void setFranchises(ArrayList<PharmacieFranchisee> franchises) {
		this.franchises = franchises;
	}

	ArrayList<PharmacieFranchisee> franchises = new ArrayList();
	PharmacieFranchisee pharmacieMere;
	private CompteBancaireFranchise compteBancaireFranchise;
	private CompteBancaireClassique compteBancaireClassique;
	public PharmacieFranchisee(String nom, int nombreEmployees, int surfaceCommerciel, String siret, Pharmacien pharmacien) {
		super(nom, nombreEmployees, surfaceCommerciel, siret, pharmacien);
	}
	
	public PharmacieFranchisee() {
	}

	public PharmacieFranchisee getPharmacieMere() {
		return pharmacieMere;
	}
	public void setPharmacieMere(PharmacieFranchisee pharmacieMere) {
		this.pharmacieMere = pharmacieMere;
	}
	public ArrayList<PharmacieFranchisee> getFranchises() {
		return franchises;
	}
	public boolean addFranchise(PharmacieFranchisee pharmacieFranchisee) {
		if(pharmacieFranchisee==null) return false;
		return franchises.add(pharmacieFranchisee);
	}
	public CompteBancaireFranchise getCompteBancaireFranchise() {
		return compteBancaireFranchise;
	}

	public void setCompteBancaireFranchise(CompteBancaireFranchise compteBancaireFranchise) {
		this.compteBancaireFranchise = compteBancaireFranchise;
	}

	public CompteBancaireClassique getCompteBancaireClassique() {
		return compteBancaireClassique;
	}

	public void setCompteBancaireClassique(CompteBancaireClassique compteBancaireClassique) {
		this.compteBancaireClassique = compteBancaireClassique;
	}

	public String toString() {
		return nom;
	}
	
}
