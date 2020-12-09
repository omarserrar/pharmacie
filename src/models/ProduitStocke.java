package models;

import java.time.LocalDate;


public class ProduitStocke extends Medicament{

    public String numerolot;
    public String prix;
    public String quantite;
    public LocalDate dateExp;
    public String ordonnance;
    public String production;

    public ProduitStocke(String nom, String type, String mode_prise,String tauxRembourcement,String numerolot,String quantite,String prix,LocalDate dateExp,String ordonnance, String production) {
        super(nom, type, mode_prise,tauxRembourcement);
        this.quantite = quantite;
        this.numerolot = numerolot;
        this.dateExp = dateExp;
        this.prix = prix;
        this.ordonnance = ordonnance;
        this.production = production;
    }

    public String getNumerolot() {
        return numerolot;
    }

    public void setNumerolot(String numerolot) {
        this.numerolot = numerolot;
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

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDateExp() {
        return dateExp;
    }

    public void setDateExp(LocalDate dateExp) {
        this.dateExp = dateExp;
    }

    public String getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(String ordonnance) {
        this.ordonnance = ordonnance;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
