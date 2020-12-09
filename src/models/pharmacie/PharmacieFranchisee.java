package models.pharmacie;

import java.util.ArrayList;

import models.compteBancaire.CompteBancaireClassique;
import models.compteBancaire.CompteBancaireFranchise;
import models.employe.Pharmacien;

public class PharmacieFranchisee extends Pharmacie {
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
		String info = super.toString()+"\n";
		info += "Compte Bancaire Classique:\t"+((compteBancaireClassique!=null)?compteBancaireClassique.getSolde():"Aucun")+"\n";
		info += "Compte Bancaire Franchise:\t"+((compteBancaireFranchise!=null)?compteBancaireFranchise.getSolde():"Aucun")+"\n";
		info+= "Pharmacie Mere:\t"+((pharmacieMere!=null)?pharmacieMere.getNom():"Aucune")+"\n";
		info+="Franchises:\t"+franchises.size()+":\n";
		if(franchises.size()>0) {
			for(PharmacieFranchisee pharmacieFranchisee: franchises) {
				info+="\t"+pharmacieFranchisee.getNom()+"\n";
			}
		}
		return info;
	}
	
}
