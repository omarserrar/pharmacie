package controllers;

import java.util.ArrayList;

import models.produit.Produit;
import views.Menu;

public class ProduitController {
	private static ProduitController produitController;
	private ArrayList<Produit> produits = new ArrayList();
	private ProduitController() {
		
	}
	public static ProduitController getProduitController() {
		return (produitController==null)?new ProduitController():produitController;
	}
	public void menuPrincipal() {
		Menu menu = new Menu();
		menu.ajouterElementMenu("Retour");
		menu.ajouterElementMenu("Ajouter un produit");
		menu.ajouterElementMenu("Lister les produits");
		int choix;
		while((choix = menu.openMenu())!=1) {
			switch(choix) {
			case 2:{
				ajouterProduitMenu();
				break;
			}
			case 3:{
				break;
			}
			}
		}
	}
	public void ajouterProduitMenu() {
		Menu menu = new Menu();
		String nom = menu.getString("Entrez le nom du produit");
		String type = menu.getString("Entrez le type du produit");
		int prixAchat = menu.getInt("Entrez le prix d'achat");
		Produit produit = new Produit(nom, type, prixAchat);
		if(produits.add(produit))
			System.out.println("Le produit a ete ajoute");
	}
	public void listerProduit() {
		
	}
}
