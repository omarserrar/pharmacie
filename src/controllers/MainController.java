package controllers;

import views.Menu;

public class MainController extends Controller {
	public void mainMenu() {
		Menu menu = new Menu();
		menu.ajouterElementMenu("Quitter");
		menu.ajouterElementMenu("Menu Pharmacies");
		menu.ajouterElementMenu("Menu Produits");
		
		int choix;
		while((choix = menu.openMenu())!=1) {
			switch(choix) {
			case 2:{
				PharmacieController.getPharmacieController().pharmacieMenuPrincipale();
				break;
			}
			case 3:{
				ProduitController.getProduitController().menuPrincipal();
				break;
			}
			}
		}
	}
}
