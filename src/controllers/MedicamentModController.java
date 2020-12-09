package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.PharmacieInfos;
import models.MedicamentExterne;
import models.MedicamentInterne;
import models.ProduitStocke;

public class MedicamentModController implements Initializable{
	
    @FXML
    private TextField nomField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField modeField;

    @FXML
    private TextField prixField;

    @FXML
    private TextField ordonnanceField;

    @FXML
    private TextField numField;

    @FXML
    private TextField qteField;

    @FXML
    private TextField prodField;

    @FXML
    private TextField tauxField;

    @FXML
    private DatePicker dateField;
    
    @FXML
    private Label categorielbl;

    @FXML
    private TextArea infoField;
    
    // recevoir et afficher les informations le medicament selectionnes 
    public void initMedicament(ProduitStocke med) {
    	nomField.setText(med.getNom());
    	prixField.setText(med.getPrix());
    	dateField.setValue(med.getDateExp());;
    	ordonnanceField.setText(med.getOrdonnance());
    	numField.setText(med.getNumerolot());
    	qteField.setText(med.getQuantite());
    	prodField.setText(med.getProduction());
    	tauxField.setText(med.getTauxRembourcement());
    	typeField.setText(med.getType());
    	modeField.setText(med.getMode_prise());
    	
    	if(med.getProduction().equals("Externe")) {
    		categorielbl.setText("Nom Firme :");
    		infoField.setText(((MedicamentExterne) med).getNomFirme());
    	}
    	else if(med.getProduction().equals("Interne")) {
    		categorielbl.setText("Composants :");
    		infoField.setText(((MedicamentInterne) med).getComposants());
    	}
    }

    // enregistrer les modification effectuer
    @FXML
    void EnregistrerModification(ActionEvent event) throws IOException {
    	
    	int i = 0;
    	for(i=0;i<PharmacieInfos.listProduitStocke.size();i++) {
    		if(PharmacieInfos.listProduitStocke.get(i).getNom().equals(nomField.getText())) {
    			PharmacieInfos.listProduitStocke.get(i).setNumerolot(numField.getText());
    			PharmacieInfos.listProduitStocke.get(i).setPrix(prixField.getText());
    			PharmacieInfos.listProduitStocke.get(i).setDateExp(dateField.getValue());
    			PharmacieInfos.listProduitStocke.get(i).setOrdonnance(ordonnanceField.getText());
    			PharmacieInfos.listProduitStocke.get(i).setQuantite(qteField.getText());
    			PharmacieInfos.listProduitStocke.get(i).setProduction(prodField.getText());
    			PharmacieInfos.listProduitStocke.get(i).setTauxRembourcement(tauxField.getText());
    			PharmacieInfos.listProduitStocke.get(i).setType(typeField.getText());
    			PharmacieInfos.listProduitStocke.get(i).setMode_prise(modeField.getText());
    			break;
    		}
    	}
    	
    	Parent root = FXMLLoader.load(getClass().getResource("../views/StockMedicament.fxml"));
    	Scene scene = new Scene(root);
    	
    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    // retourner au menu principal
    @FXML
    void retour(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("../views/StockMedicament.fxml"));
    	Scene scene = new Scene(root);
    	
    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// le nom du medicament ne peut pas etre modifier
		nomField.setEditable(false);
	}

}
