package views;

import controllers.PharmacieController;
import models.pharmacie.Pharmacie;

public class PharmacieView extends View {

	public int showMenuPrincipale() {
		Menu menuPrincipale = new Menu();
		menuPrincipale.ajouterElementMenu("Ajouter Pharmacie");
		menuPrincipale.ajouterElementMenu("Lister Les Pharmacies");
		return menuPrincipale.openMenu();
	}
	public int showMenuCreationTypePharmacie() {
		Menu menuPrincipale = new Menu();
		menuPrincipale.ajouterElementMenu("Pharmacie Independente");
		menuPrincipale.ajouterElementMenu("Pharmacie Franchise");
		return menuPrincipale.openMenu();
	}
	public int selectPharmacieFranchisee() {
		PharmacieController pharmacieController = PharmacieController.getPharmacieController();
		Menu menu = new Menu();
		menu.ajouterElementMenu("Aucune");
		for(Pharmacie pharmacie: pharmacieController.getPharmacies()) {
			menu.ajouterElementMenu(pharmacie.getNom());
		}
		return menu.openMenu();
	}
	
}
