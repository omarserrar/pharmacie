package models;

import java.time.LocalDate;

public class Ordonnance {
	
	private String nom;
	private String prenom;
	private int age;
	private LocalDate date_consultation;
	private String nom_medecin;
	private String specialite_medecin;
	private String adresse_medecin;
	private MedicamentPrescrit[] medPres;
	
	public Ordonnance(String nom, String prenom, int age, LocalDate date_consultation, String nom_medecin,
			String specialite_medecin, String adresse_medecin, MedicamentPrescrit[] medPres) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.date_consultation = date_consultation;
		this.nom_medecin = nom_medecin;
		this.specialite_medecin = specialite_medecin;
		this.adresse_medecin = adresse_medecin;
		this.medPres = medPres;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDate_consultation() {
		return date_consultation;
	}

	public void setDate_consultation(LocalDate date_consultation) {
		this.date_consultation = date_consultation;
	}

	public String getNom_medecin() {
		return nom_medecin;
	}

	public void setNom_medecin(String nom_medecin) {
		this.nom_medecin = nom_medecin;
	}

	public String getSpecialite_medecin() {
		return specialite_medecin;
	}

	public void setSpecialite_medecin(String specialite_medecin) {
		this.specialite_medecin = specialite_medecin;
	}

	public String getAdresse_medecin() {
		return adresse_medecin;
	}

	public void setAdresse_medecin(String adresse_medecin) {
		this.adresse_medecin = adresse_medecin;
	}

	public MedicamentPrescrit[] getMedPres() {
		return medPres;
	}

	public void setMedPres(MedicamentPrescrit[] medPres) {
		this.medPres = medPres;
	}
	

}
