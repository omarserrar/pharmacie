package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.MedicamentExterne;
import models.MedicamentInterne;
import models.ProduitStocke;

public class MedicamentDetailController {
	
	 @FXML
	    private Label nomlbl;

	    @FXML
	    private Label prixlbl;

	    @FXML
	    private Label datelbl;

	    @FXML
	    private Label ordonnancelbl;

	    @FXML
	    private Label numlbl;

	    @FXML
	    private Label qtelbl;

	    @FXML
	    private Label prodlbl;

	    @FXML
	    private Label tauxlbl;

	    @FXML
	    private Label typelbl;

	    @FXML
	    private Label modelbl;
	    
	    @FXML
	    private Label categorielbl;

	    @FXML
	    private Label infolbl;
	    
	    // recevoir et afficher les informations du medicament selectionnes
	    public void initMedicament(ProduitStocke med) {
	    	nomlbl.setText(med.getNom());
	    	prixlbl.setText(med.getPrix());
	    	datelbl.setText(med.getDateExp().toString());
	    	ordonnancelbl.setText(med.getOrdonnance());
	    	numlbl.setText(med.getNumerolot());
	    	qtelbl.setText(med.getQuantite());
	    	prodlbl.setText(med.getProduction());
	    	tauxlbl.setText(med.getTauxRembourcement());
	    	typelbl.setText(med.getType());
	    	modelbl.setText(med.getMode_prise());
	    	
	    	// l'affichage depend de la categorie du medicament interne ou externe
	    	if(med.getProduction().equals("Externe")) {
	    		categorielbl.setText("Nom Firme :");
	    		infolbl.setText(((MedicamentExterne) med).getNomFirme());
	    	}
	    	else if(med.getProduction().equals("Interne")) {
	    		categorielbl.setText("Composants :");
	    		infolbl.setText(((MedicamentInterne) med).getComposants());
	    	}
	    }
	    
	    //retourner a l'interface de gestion des medicament 
	    @FXML
	    void retour(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("../views/StockMedicament.fxml"));
	    	Scene scene = new Scene(root);
	    	
	    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    }

}
