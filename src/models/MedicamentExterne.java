package models;

import java.time.LocalDate;

public class MedicamentExterne extends ProduitStocke {

	private String nomFirme;
	public MedicamentExterne(String nom, String type, String mode_prise, String tauxRembourcement, String numerolot,
			String quantite, String prix, LocalDate dateExp, String ordonnance, String production, String nomFirme) {
		super(nom, type, mode_prise, tauxRembourcement, numerolot, quantite, prix, dateExp, ordonnance, production);

		this.nomFirme = nomFirme ; 
	}

	
	

	public String getNomFirme() {
		return nomFirme;
	}

	public void setNomFirme(String nomFirme) {
		this.nomFirme = nomFirme;
	}

	
}
