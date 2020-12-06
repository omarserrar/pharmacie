package models.pharmacie;

import java.util.ArrayList;

import models.employe.Pharmacien;

public class PharmacieFranchisee extends Pharmacie {
	ArrayList<PharmacieFranchisee> franchises = new ArrayList();
	PharmacieFranchisee pharmacieMere;
	
	public PharmacieFranchisee(String nom, int nombreEmployees, int surfaceCommerciel, String siret, Pharmacien pharmacien) {
		super(nom, nombreEmployees, surfaceCommerciel, siret, pharmacien);
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
	
	
}
