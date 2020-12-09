package models;

import java.time.LocalDate;

public class Vente {

    private String nomProduit;
    private String nomClient;
    private String quantite;
    private LocalDate date;
    private String duree;
    private String ordonnance;
    private String assurence;

    public Vente(String nomProduit,String nomClient,String quantite,LocalDate date, String duree,String ordonnance,String assurance) {
        this.nomProduit = nomProduit;
        this.nomClient = nomClient;
        this.quantite = quantite;
        this.date = date;
        this.duree = duree;
        this.ordonnance = ordonnance;
        this.assurence = assurence;
    }

    public String getAssurence() {
        return assurence;
    }

    public void setAssurence(String assurence) {
        this.assurence = assurence;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(String ordonnance) {
        this.ordonnance = ordonnance;
    }

}
