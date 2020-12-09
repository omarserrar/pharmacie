package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Client;
import models.compteBancaire.CompteBancaireClassique;
import models.compteBancaire.CompteBancaireFranchise;
import models.employe.Pharmacien;
import models.pharmacie.Pharmacie;
import models.pharmacie.PharmacieFranchisee;
import models.pharmacie.PharmacieIndependente;


public class ControllerPharmacieIndep {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SIRET;

    @FXML
    private TextField adrPha;

    @FXML
    private TableColumn<PharmacieFranchisee, String> cbclaCol;

    @FXML
    private TableColumn<PharmacieFranchisee, String> cbfraCol;

    @FXML
    private TableColumn<PharmacieFranchisee, String> colNom;

    @FXML
    private TableView listePha;

    @FXML
    private TextField nom;

    @FXML
    private TextField nomPha;

    @FXML
    private TableColumn<PharmacieFranchisee, String> pharmacienCol;

    @FXML
    private TextField prenomPha;

    @FXML
    private TableColumn<PharmacieFranchisee, String> siretCol;

    @FXML
    private TextField soldeCla;

    @FXML
    private TextField soldeFra;

    @FXML
    private ComboBox<?> type;

    @FXML
    private TableColumn<PharmacieFranchisee, String> typeCol;

    private static ObservableList<PharmacieIndependente> PharmacieFranchisees = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        assert SIRET != null : "fx:id=\"SIRET\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert adrPha != null : "fx:id=\"adrPha\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert cbclaCol != null : "fx:id=\"cbclaCol\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert cbfraCol != null : "fx:id=\"cbfraCol\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert colNom != null : "fx:id=\"colNom\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert listePha != null : "fx:id=\"listePha\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert nom != null : "fx:id=\"nom\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert nomPha != null : "fx:id=\"nomPha\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert pharmacienCol != null : "fx:id=\"pharmacienCol\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert prenomPha != null : "fx:id=\"prenomPha\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert siretCol != null : "fx:id=\"siretCol\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert soldeCla != null : "fx:id=\"soldeCla\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert soldeFra != null : "fx:id=\"soldeFra\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert type != null : "fx:id=\"type\" was not injected: check your FXML file 'ListePharmacie.fxml'.";
        assert typeCol != null : "fx:id=\"typeCol\" was not injected: check your FXML file 'ListePharmacie.fxml'.";

        afficherPharmacies();
    }
    @FXML
    void ajouterPharmacie(ActionEvent actionEvent) {
    	String nom = this.nom.getText();
    	String siret = this.SIRET.getText();
    	String type = this.colNom.getText();
    	String nomPha = this.nomPha.getText();
    	String prenomPha = this.prenomPha.getText();

    	Pharmacien pharmacien = new Pharmacien(nomPha, prenomPha, "", 2000);
    	PharmacieIndependente pharmacieIndependente = new PharmacieIndependente(nom, 1, 1, siret, pharmacien);
    	
    	try {
    		int cbCla = Integer.parseInt(this.soldeCla.getText());
    		pharmacieIndependente.setCompteBancaireClassique(new CompteBancaireClassique(cbCla));
    	}
    	catch (Exception e) {
		}
    	
    	System.out.println(pharmacieIndependente);
    	PharmacieFranchisees.add(pharmacieIndependente);
    }
    
    void afficherPharmacies() {
    	colNom.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("nom"));
        siretCol.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("siret"));
        
        pharmacienCol.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("pharmacien"));
        
        cbclaCol.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("compteBancaireClassique"));
    	listePha.setItems(PharmacieFranchisees);
    	listePha.setEditable(true);
    }


}
