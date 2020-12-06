package controllers;

import java.util.ArrayList;

import com.sun.java.util.jar.pack.Instruction.Switch;

import models.employe.Pharmacien;
import models.pharmacie.Pharmacie;
import models.pharmacie.PharmacieFranchisee;
import models.pharmacie.PharmacieIndependente;
import views.Menu;
import views.PharmacieView;

public class PharmacieController extends Controller{
	private static PharmacieController pharmacieController = null;
	private PharmacieView pharmacieView = new PharmacieView();
	private ArrayList<Pharmacie> pharmacies = new ArrayList<>();
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
		}
		case 2:{
			
		}
		}
	}
	public void ajouterPharmacie() {
		switch(pharmacieView.showMenuCreationTypePharmacie()) {
		case 1:{
			ajouterPharmacieIndependente();
		}
		case 2:{
			ajouterPharmacieFranchisee();
		}
		}
	}

	public Pharmacie creerPharmacie() {
		Menu menu = new Menu();
		String nom = menu.getString("Entrez le nom de la pharmacie:");
		int nbEmployes = menu.getInt("Entrez le nombre d'employes de la pharmacie:");
		int surface = menu.getInt("Entrez la surface commercial de la pharmacie:");
		String siret = menu.getString("Entrez SIRET de la pharmacie:");
		String pharmacienNom = menu.getString("Entrez le nom du pharmacien:");
		String pharmacienPrenom = menu.getString("Entrez le prenom du pharmacien:");
		String pharmacienAdresse = menu.getString("Entrez l'adresse du pharmacien:");
		int salaire = menu.getInt("Entrez le salaire du pharmacien:");
		return new Pharmacie(nom, nbEmployes, surface, siret, new Pharmacien(pharmacienNom, pharmacienPrenom, pharmacienAdresse, salaire));
	}
	public PharmacieFranchisee selectPharmacieFranchisee() {
		int pharmacieSelectionee = pharmacieView.selectPharmacieFranchisee();
		if(pharmacieSelectionee==1) return null;
		return (PharmacieFranchisee) pharmacies.get(pharmacieSelectionee-2);
	}
	public void ajouterPharmacieIndependente() {
		PharmacieIndependente pharmacieIndependente = (PharmacieIndependente) creerPharmacie();
		pharmacies.add(pharmacieIndependente);
	}
	public void ajouterPharmacieFranchisee() {
		PharmacieFranchisee pharmacieFranchisee = (PharmacieFranchisee) creerPharmacie();
		
		pharmacies.add(pharmacieFranchisee);
	}
	public ArrayList<Pharmacie> getPharmacies() {
		return pharmacies;
	}
	
}
