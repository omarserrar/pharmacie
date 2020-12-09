package models;

import models.carteBancaire.CarteBancaire;
import models.carteBancaire.CarteBancaireClassique;
import models.carteBancaire.CarteBancairePharmacie;

public class Client {

    private String nom;
    private String prenom;
    private CarteBancaireClassique carteBancaireClassique;
    private CarteBancairePharmacie carteBancairePharmacie;
    

    public Client(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

	public Client(String nom, String prenom, CarteBancaireClassique carteBancaireClassique,
			CarteBancairePharmacie carteBancairePharmacie) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.carteBancaireClassique = carteBancaireClassique;
		this.carteBancairePharmacie = carteBancairePharmacie;
	}

	public CarteBancaireClassique getCarteBancaireClassique() {
		return carteBancaireClassique;
	}

	public void setCarteBancaireClassique(CarteBancaireClassique carteBancaireClassique) {
		this.carteBancaireClassique = carteBancaireClassique;
	}

	public CarteBancairePharmacie getCarteBancairePharmacie() {
		return carteBancairePharmacie;
	}

	public void setCarteBancairePharmacie(CarteBancairePharmacie carteBancairePharmacie) {
		this.carteBancairePharmacie = carteBancairePharmacie;
	}
    

}
