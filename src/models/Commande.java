package models;

public class Commande {

    private String prod_commande;
    private String quantite;
    private String nom_client;
    private String nom_fournisseur;


    public Commande(String prod_commande, String quantite, String nom_client, String nom_fournisseur) {
        super();
        this.prod_commande = prod_commande;
        this.quantite = quantite;
        this.nom_client = nom_client;
        this.nom_fournisseur = nom_fournisseur;

    }

    public String getProd_commande() {
        return prod_commande;
    }

    public void setProd_commande(String prod_commande) {
        this.prod_commande = prod_commande;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getNom_fournisseur() {
        return nom_fournisseur;
    }

    public void setNom_fournisseur(String nom_fournisseur) {
        this.nom_fournisseur = nom_fournisseur;
    }
}
