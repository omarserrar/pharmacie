package models.produit;

public class Produit {
	private String nom;
	private String type;
	private int prixAchat;
	private String date;
	
	public Produit(String nom, String type, int prixAchat, String date) {
		super();
		this.nom = nom;
		this.type = type;
		this.prixAchat = prixAchat;
		this.date = date;
	}
	
	public Produit(String nom, String type, int prixAchat) {
		super();
		this.nom = nom;
		this.type = type;
		this.prixAchat = prixAchat;
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
	public int getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
