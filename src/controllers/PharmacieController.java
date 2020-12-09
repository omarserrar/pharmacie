package controllers;

import java.util.ArrayList;
import java.util.Date;

import models.compteBancaire.CompteBancaireClassique;
import models.compteBancaire.CompteBancaireFranchise;
import models.employe.Employe;
import models.employe.Pharmacien;
import models.employe.PreparateurCommande;
import models.pharmacie.Pharmacie;
import models.pharmacie.PharmacieFranchisee;
import models.pharmacie.PharmacieIndependente;
import views.Menu;
import views.PharmacieView;

public class PharmacieController extends Controller{
	private static PharmacieController pharmacieController = null;
	private PharmacieView pharmacieView = new PharmacieView();
	private ArrayList<Pharmacie> pharmacies = new ArrayList<>();
	private ArrayList<Pharmacie> pharmaciesFranchisees = new ArrayList<>();
	private PharmacieController() {
		
	}
	public static PharmacieController getPharmacieController() {
		if(pharmacieController!=null) return pharmacieController;
		return new PharmacieController();
	}
	public void pharmacieMenuPrincipale() {
		switch(pharmacieView.showMenuPrincipale()) {
		case 1:{
			ajouterPharmacie();
			break;
		}
		case 2:{
			listerPharmacie();
			break;
		}
		}
		pharmacieMenuPrincipale();
	}
	public void listerPharmacie() {
		int pharmacieSelectionee = pharmacieView.selectPharmacie("Tapez le nombre d'une pharmacie pour plus d'option", pharmacies, true);
		if(pharmacieSelectionee==0) return;
		System.out.println(pharmacies.get(pharmacieSelectionee-1));
		listerPharmacie();
	}
	public void ajouterPharmacie() {
		switch(pharmacieView.showMenuCreationTypePharmacie()) {
		case 1:{
			ajouterPharmacieIndependente();
			break;
		}
		case 2:{
			ajouterPharmacieFranchisee();
			break;
		}
		}
	}

	public Pharmacie creerPharmacie(Pharmacie pharmacie) {
		Menu menu = new Menu();
		String nom = menu.getString("Entrez le nom de la pharmacie:");
		pharmacie.setNom(nom);
		int nbEmployes = menu.getInt("Entrez le nombre d'employes de la pharmacie:");
		pharmacie.setNombreEmployees(nbEmployes);
		int surface = menu.getInt("Entrez la surface commercial de la pharmacie:");
		pharmacie.setSurfaceCommerciel(surface);
		String siret = menu.getString("Entrez SIRET de la pharmacie:");
		pharmacie.setSiret(siret);
		String pharmacienNom = menu.getString("Entrez le nom du pharmacien:");
		String pharmacienPrenom = menu.getString("Entrez le prenom du pharmacien:");
		String pharmacienAdresse = menu.getString("Entrez l'adresse du pharmacien:");
		int salaire = menu.getInt("Entrez le salaire du pharmacien:");
		Pharmacien pharmacien = new Pharmacien(pharmacienNom, pharmacienPrenom, pharmacienAdresse, salaire);
		pharmacie.setPharmacien(pharmacien);
		for(int i=1;i<nbEmployes;i++) {
			System.out.println("Entrez l'employe "+i);
			nom = menu.getString("Entrez le nom de l'employe:");
			String prenom = menu.getString("Entrez le prenom de l'employe:");
			String adresse = menu.getString("Entrez l'adresse de l'employe:");
			int nbHeureSemaine = menu.getInt("Entrez le nombre d'heure de travail par semaine:");
			int salaireHeure = menu.getInt("Entrez le salaire / heure:");
			Date dateEmb = menu.getDate("Entrez la date d'embauche de l'employe:(dd/mm/yyyy):");
			
			pharmacie.addEmploye(new PreparateurCommande(nom, prenom ,adresse,nbHeureSemaine, salaireHeure, dateEmb ));
		}
		return pharmacie;
	}
	public PharmacieFranchisee selectPharmacieFranchisee() {
		int pharmacieSelectionee = pharmacieView.selectPharmacie("Choisissez les pharmacies franchisées", pharmaciesFranchisees, true);
		if(pharmacieSelectionee==0) return null;
		return (PharmacieFranchisee) pharmacies.get(pharmacieSelectionee-1);
	}
	public void ajouterPharmacieIndependente() {
		PharmacieIndependente pharmacieIndependente = (PharmacieIndependente) creerPharmacie(new PharmacieIndependente());
		pharmacieIndependente.setCompteBancaireClassique(createCBCla());
		if(pharmacies.add(pharmacieIndependente))
			System.out.println("Pharmacie Ajoute");
		
	}
	public void ajouterPharmacieFranchisee() {
		PharmacieFranchisee pharmacieFranchisee = (PharmacieFranchisee) creerPharmacie(new PharmacieFranchisee());
		ajouterParent(pharmacieFranchisee);
		ajouterPharmacieFranchiseeEnfant(pharmacieFranchisee);
		ajouterCompteBancairePharmacieFranchise(pharmacieFranchisee);
		pharmaciesFranchisees.add(pharmacieFranchisee);
		pharmacies.add(pharmacieFranchisee);
	}
	public void ajouterParent(PharmacieFranchisee pharmacie) {
		int pharmacieSelectionee = pharmacieView.selectPharmacie("Choisissez la pharmacie mere", pharmaciesFranchisees, true);
		if(pharmacieSelectionee >0) {
			PharmacieFranchisee mere = (PharmacieFranchisee) pharmaciesFranchisees.get(pharmacieSelectionee-1);
			pharmacie.setPharmacieMere(mere);
			mere.addFranchise(pharmacie);
		}
	}
	public void ajouterPharmacieFranchiseeEnfant(PharmacieFranchisee pharmacieFranchisee) {
		PharmacieFranchisee enfant;
		while((enfant = selectPharmacieFranchisee()) != null) {
			pharmacieFranchisee.addFranchise(enfant);
			enfant.setPharmacieMere(pharmacieFranchisee);
		}
	}
	public void ajouterCompteBancairePharmacieFranchise(PharmacieFranchisee pharmacieFranchisee) {
		int choix;
		while((choix = pharmacieView.addCompteBancairePharmacieFranchisee(pharmacieFranchisee))!=0) {
			switch(choix) {
			case 1:{
				pharmacieFranchisee.setCompteBancaireClassique(createCBCla());
				break;
			}
			case 2:{
				pharmacieFranchisee.setCompteBancaireFranchise(createCBFra());
				break;
			}
			}
		}
	}
	public CompteBancaireFranchise createCBFra() {
		Menu menu = new Menu();
		int solde = menu.getInt("Entrez le solde du compte franchise:");
		CompteBancaireFranchise compteBancaireClassique = new CompteBancaireFranchise(solde);
		return compteBancaireClassique;
	}
	public CompteBancaireClassique createCBCla() {
		Menu menu = new Menu();
		int solde = menu.getInt("Entrez le solde du compte classique:");
		CompteBancaireClassique compteBancaireClassique = new CompteBancaireClassique(solde);
		return compteBancaireClassique;
	}
	public ArrayList<Pharmacie> getPharmacies() {
		return pharmacies;
	}
	public ArrayList<Pharmacie> getPharmaciesFranchisees() {
		return pharmaciesFranchisees;
	}
	
}
