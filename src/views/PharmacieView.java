package views;

import java.util.ArrayList;

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
	public int selectPharmacie(String titre, ArrayList<Pharmacie> pharmacies, boolean aucune) {
		System.out.println(titre);
		Menu menu = new Menu();
		if(aucune)
			menu.ajouterElementMenu("Aucune / Retour");
		for(Pharmacie pharmacie: pharmacies) {
			menu.ajouterElementMenu(pharmacie.getNom());
		}
		if(aucune)
			return menu.openMenu()-1;
		return menu.openMenu();
	}
	
}
