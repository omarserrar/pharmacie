package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Client;
import models.compteBancaire.CompteBancaireClassique;
import models.compteBancaire.CompteBancaireFranchise;
import models.employe.Pharmacien;
import models.pharmacie.Pharmacie;
import models.pharmacie.PharmacieFranchisee;


public class ControllerPharmacie {

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
    private TableView listePha, childrenList;

    @FXML
    private TextField nom;

    @FXML
    private TextField nomPha;
    @FXML 
    private ComboBox<ComboBoxItemWrap> cb;
    @FXML
    private TableColumn<PharmacieFranchisee, String> pharmacienCol;
    
    @FXML
    private TableColumn<PharmacieFranchisee, String> pharmacieChildren;

    @FXML
    private TextField prenomPha;

    @FXML
    private TableColumn<PharmacieFranchisee, String> siretCol, pharmacieMereCol;
    private ArrayList<PharmacieFranchisee> children = new ArrayList<PharmacieFranchisee>();
    @FXML
    private TextField soldeCla;

    @FXML
    private TextField soldeFra;

    @FXML
    private ComboBox<PharmacieFranchisee>pharmacieMere;
    @FXML
    private TableColumn<PharmacieFranchisee, String> typeCol;

    private static ObservableList<PharmacieFranchisee> PharmacieFranchisees = FXCollections.observableArrayList();
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
        assert typeCol != null : "fx:id=\"typeCol\" was not injected: check your FXML file 'ListePharmacie.fxml'.";

       listePha.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    	    if (newSelection != null) {
    	    	System.out.println();
    	    	afficherEnfant(PharmacieFranchisees.get(listePha.getSelectionModel().getSelectedIndex()));
    	    }
    	});
       
        afficherPharmacies();
    }
    void afficherEnfant(PharmacieFranchisee pharmacieFranchisee) {
    	System.out.println(pharmacieFranchisee.getFranchises());
    	pharmacieChildren.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("nom"));
    	childrenList.setItems(FXCollections.observableArrayList(pharmacieFranchisee.getFranchises()));
    	
    }
    void getPharmacie() {
    	ArrayList<ComboBoxItemWrap> optionss=new ArrayList<ComboBoxItemWrap>();
    	for(PharmacieFranchisee pharmacieFranchisee: PharmacieFranchisees) {
    		optionss.add(new ComboBoxItemWrap(pharmacieFranchisee));
    	}
    	 
    	 
         ObservableList<ComboBoxItemWrap> options = FXCollections.observableArrayList(optionss);;

         cb.setCellFactory( c -> {
             ListCell<ComboBoxItemWrap> cell = new ListCell<ComboBoxItemWrap>(){
                 @Override
                 protected void updateItem(ComboBoxItemWrap item, boolean empty) {
                     super.updateItem(item, empty);
                     if (!empty) {
                         final CheckBox cb = new CheckBox(item.toString());
                         cb.selectedProperty().bind(item.checkProperty());
                         setGraphic(cb);
                     }
                 }
             };

             cell.addEventFilter(MouseEvent.MOUSE_RELEASED, event -> {
            	 children.clear();
                 cell.getItem().checkProperty().set(!cell.getItem().checkProperty().get());
                 cb.getItems().filtered( f-> f!=null).filtered( f-> f.getCheck()).forEach( p -> {
                	 children.add((PharmacieFranchisee) p.getItem());
                 });

             });

             return cell;
         });

         cb.setItems(options);
    }
    @FXML
    void ajouterPharmacie(ActionEvent actionEvent) {
    	String nom = this.nom.getText();
    	String siret = this.SIRET.getText();
    	String type = this.colNom.getText();
    	String nomPha = this.nomPha.getText();
    	String prenomPha = this.prenomPha.getText();

    	Pharmacien pharmacien = new Pharmacien(nomPha, prenomPha, "", 2000);
    	PharmacieFranchisee pharmacieFranchisee = new PharmacieFranchisee(nom, 1, 1, siret, pharmacien);
    	
    	try {
    		int cbCla = Integer.parseInt(this.soldeCla.getText());
    		pharmacieFranchisee.setCompteBancaireClassique(new CompteBancaireClassique(cbCla));
    	}
    	catch (Exception e) {
		}
    	try {
    		int cbFra = Integer.parseInt(this.soldeFra.getText());
    		pharmacieFranchisee.setCompteBancaireFranchise(new CompteBancaireFranchise(cbFra));
    	}
    	catch(Exception e) {
    		
    	}
    	pharmacieFranchisee.setFranchises((ArrayList<PharmacieFranchisee>) children.clone());
    	if(pharmacieMere.getSelectionModel().getSelectedItem()!=null) {
    		pharmacieFranchisee.setPharmacieMere(pharmacieMere.getSelectionModel().getSelectedItem());
    	}
    	PharmacieFranchisees.add(pharmacieFranchisee);
    	
    	children.clear();
    	getPharmacie();
    }
    
    
    void afficherPharmacies() {
    	pharmacieMere.setItems(PharmacieFranchisees);
    	getPharmacie();
    	pharmacieMereCol.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("pharmacieMere"));
    	colNom.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("nom"));
        siretCol.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("siret"));
        
        pharmacienCol.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("pharmacien"));
        
        cbfraCol.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("compteBancaireFranchise"));
        cbclaCol.setCellValueFactory(new PropertyValueFactory<PharmacieFranchisee,String>("compteBancaireClassique"));
    	listePha.setItems(PharmacieFranchisees);
    	listePha.setEditable(true);
    	
    }

}


class ComboBoxItemWrap {

    private BooleanProperty check = new SimpleBooleanProperty(false);
    private ObjectProperty<Pharmacie> item = new SimpleObjectProperty<>();

    ComboBoxItemWrap() {
    }

    ComboBoxItemWrap(Pharmacie item) {
        this.item.set(item);
    }

    ComboBoxItemWrap(Pharmacie item, Boolean check) {
        this.item.set(item);
        this.check.set(check);
    }

    public BooleanProperty checkProperty() {
        return check;
    }

    public Boolean getCheck() {
        return check.getValue();
    }

    public void setCheck(Boolean value) {
        check.set(value);
    }

    public ObjectProperty<Pharmacie> itemProperty() {
        return item;
    }

    public Pharmacie getItem() {
        return item.getValue();
    }

    public void setItem(Pharmacie value) {
        item.setValue(value);
    }

    @Override
    public String toString() {
        return item.getValue().getNom();
    }
}
