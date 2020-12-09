package models;

public class Medicament {

    private String nom;
    private String type;
    private String mode_prise;
    private String tauxRembourcement;

    public Medicament(String nom, String type, String mode_prise,String tauxRembourcement) {

        this.nom = nom;
        this.type = type;
        this.mode_prise = mode_prise;
        this.tauxRembourcement = tauxRembourcement;
    }

    public String getTauxRembourcement() {
        return tauxRembourcement;
    }

    public void setTauxRembourcement(String tauxRembourcement) {
        this.tauxRembourcement = tauxRembourcement;
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

    public String getMode_prise() {
        return mode_prise;
    }

    public void setMode_prise(String mode_prise) {
        this.mode_prise = mode_prise;
    }
}
