package models;

public class ProduitParapharmaceutique {


    private String nom;
    private String type;
    private String prix;
    private String quantite;

    public ProduitParapharmaceutique(String nom,String type, String prix, String qte) {
        this.nom = nom;
        this.type = type;
        this.prix = prix;
        this.quantite = qte ;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String qte) {
        this.quantite = qte;
    }

}
