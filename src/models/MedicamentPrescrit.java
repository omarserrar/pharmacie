package models;

public class MedicamentPrescrit {
	
	private String nom; // type Medicament
	private int quantite;
	private String duree;
	
	public MedicamentPrescrit(String nom, int quantite, String duree) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.duree = duree;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}
	
	
	
	

}
