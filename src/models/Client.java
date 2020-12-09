package models;

public class Client {

    private String nom;
    private String prenom;
    private String age;
    private String num_ss;
    private String maladie;
    private String traitement;

    public Client(String nom, String prenom,String age, String num_ss, String maladie, String traitement) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.num_ss = num_ss;
        this.maladie = maladie;
        this.traitement = traitement;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNum_ss() {
        return num_ss;
    }

    public void setNum_ss(String num_ss) {
        this.num_ss = num_ss;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }


}
