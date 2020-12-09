package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.PharmacieInfos;
import models.Client;
import models.ProduitParapharmaceutique;
import models.ProduitStocke;
import models.Vente;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

import static models.PharmacieInfos.listProduitStocke;
import static models.PharmacieInfos.listVente;

public class VenteController implements Initializable {


    @FXML
    private TextField nomClientField;

    @FXML
    private TextField nomProduitField;

    @FXML
    private TextField quantiteField;

    @FXML
    private TextField dureeField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TableView<Vente> venteTable;

    @FXML
    private TableColumn<Vente,String> nomClient,nomProduit,quantite,duree,ordonnance;
    @FXML
    private TableColumn<Vente, LocalDate> date;
    
    @FXML
    private RadioButton ouiOrdonnance;

    @FXML
    private ToggleGroup Ordonnance;

    @FXML
    private RadioButton nonOrdonnance;

    @FXML
    private RadioButton ouiAssurance;

    @FXML
    private ToggleGroup Assurance;

    @FXML
    private RadioButton nonAssurance;
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nomClient.setCellValueFactory(new PropertyValueFactory<Vente,String>("nomClient"));
        nomProduit.setCellValueFactory(new PropertyValueFactory<Vente,String>("nomProduit"));
        quantite.setCellValueFactory(new PropertyValueFactory<Vente,String>("quantite"));
        ordonnance.setCellValueFactory(new PropertyValueFactory<Vente,String>("ordonnance"));
        date.setCellValueFactory(new PropertyValueFactory<Vente,LocalDate>("date"));

        venteTable.setItems(listVente);
        venteTable.setEditable(true);

    }

    // vendre un produit
    public void vendreButtonClicked (ActionEvent event) {
    	ProduitStocke med = null;
    	ProduitParapharmaceutique prod = null;
    	// verifier si le produit est un medicament qui existe dans le stock des medicaments
    	for(int i=0;i<PharmacieInfos.listProduitStocke.size();i++) {
    		if(PharmacieInfos.listProduitStocke.get(i).getNom().equals(nomProduitField.getText())) {
    			med = PharmacieInfos.listProduitStocke.get(i);
    			break;
    		}
    	}
    	if(med == null) {
    		// verifier si le produit est un produit parapharmaceutique qui existe dans le stock des produits parapharmaceutique
    		for(int i=0;i<PharmacieInfos.listProduitParapharm.size();i++) {
        		if(PharmacieInfos.listProduitParapharm.get(i).getNom().equals(nomProduitField.getText())) {
        			prod = PharmacieInfos.listProduitParapharm.get(i);
        			break;
        		}
        	}
    	}
    	
    	if(med != null) {
    		// verifier si la quantite est disponible dans le stock
    		if (Integer.parseInt(quantiteField.getText()) <= Integer.parseInt(med.getQuantite()) ) {
    			Period duree = Period.between(LocalDate.now(),med.getDateExp())  ;
    			// verifier si la duree du medicament couvre la duree du traitement  
    			if(duree.getDays() >= Integer.parseInt(dureeField.getText())) {
    				// verifier si l'ordonnance est obligatoire
    				if(med.getOrdonnance().equalsIgnoreCase("oui") & nonOrdonnance.isSelected()) {
    					Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("ERROR");
                        alert.setHeaderText(null);
                        alert.setContentText("Impossible de vendre ce Medicament sans Ordonnance !");
                        alert.showAndWait();
    				}
    				else {
    					// calculer le prix du medicament
    					double prix = Double.parseDouble(med.getPrix()) * Double.parseDouble(quantiteField.getText()) ;
    					
    					// verifier si le client est assure pour beneficier d'un rembourcement
    					if(ouiAssurance.isSelected()) {
    						prix = prix - ( Double.parseDouble(med.getTauxRembourcement()) * Double.parseDouble(quantiteField.getText()) );
    					}
    					
    					// demande de confirmation de la vente
    					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Prix Final");
                        alert.setHeaderText(null);
                        alert.setContentText("Le prix final du Medicament = "+prix+" D.A \n Confirmer la vente ? ");
                        alert.showAndWait();
                        
                        // si la vente a ete confirmer
                        if(alert.getResult() == ButtonType.OK) {                         	
                        	Vente vente = new Vente(nomProduitField.getText(),
                        			nomClientField.getText(),
                        			quantiteField.getText(),
                        			dateField.getValue(),
                        			dureeField.getText(),
                        			((RadioButton) Ordonnance.getSelectedToggle()).getText(),
                        			((RadioButton) Assurance.getSelectedToggle()).getText());
                        	
                        	med.setQuantite(Integer.toString(Integer.parseInt(med.getQuantite())-Integer.parseInt(quantiteField.getText())));
                        	listVente.add(vente);
                        	venteTable.setItems(listVente);
                        }
                        
    				}
    			}
    			else {
    				Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ERROR");
                    alert.setHeaderText(null);
                    alert.setContentText("La Date d'Expiration du Medicament ne couvre par toute la duree du traitement !");
                    alert.showAndWait();
    			}
    		}
    		else {
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Quantite insufisante dans le Stock");
                alert.showAndWait();
                
                
    		}
    	}
    	else if (prod != null) {
    		// verifier si la quantite est disponible
    		if (Integer.parseInt(quantiteField.getText()) <= Integer.parseInt(prod.getQuantite()) ) {
    			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Prix Final");
                alert.setHeaderText(null);
                alert.setContentText("Le prix du Produit = "+Double.parseDouble(prod.getPrix())+" D.A \\n Confirmer la vente ? ");
                alert.showAndWait();
                // verifier si la vente est confirmer
                if(alert.getResult() == ButtonType.OK) {                	
                	Vente vente = new Vente(nomProduitField.getText(),
                			nomClientField.getText(),
                			quantiteField.getText(),
                			dateField.getValue(),
                			dureeField.getText(),
                			((RadioButton) Ordonnance.getSelectedToggle()).getText(),
                			((RadioButton) Assurance.getSelectedToggle()).getText());
                	
                	prod.setQuantite(Integer.toString(Integer.parseInt(prod.getQuantite())-Integer.parseInt(quantiteField.getText())));
                	listVente.add(vente);
                	venteTable.setItems(listVente);
                }else {
                	System.out.println("Vente non effectuer");
                }
    		}
    		else {
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Quantite insufisante dans le Stock");
                alert.showAndWait();
    		}
    	}
    	else{
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Ce produit n'existe pas !");
            alert.showAndWait();
    	}


        nomProduitField.clear();
        nomClientField.clear();
        quantiteField.clear();
        dureeField.clear();

    }

    // aller directement a l'interface de gestion des commandes pour commander un produit
    public void commandeButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) nomClientField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Commande.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    // retourner au menu principal
    public void retourButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) nomClientField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
