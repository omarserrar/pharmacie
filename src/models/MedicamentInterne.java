package models;

import java.time.LocalDate;

public class MedicamentInterne extends ProduitStocke{

	private String composants;

	public MedicamentInterne(String nom, String type, String mode_prise, String tauxRembourcement, String numerolot,
			String quantite, String prix, LocalDate dateExp, String ordonnance, String production, String composants) {
		super(nom, type, mode_prise, tauxRembourcement, numerolot, quantite, prix, dateExp, ordonnance, production);
		
		this.composants = composants;
	}

	public String getComposants() {
		return composants;
	}

	public void setComposants(String composants) {
		this.composants = composants;
	}


}
