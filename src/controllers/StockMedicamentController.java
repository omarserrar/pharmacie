package controllers;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import models.MedicamentExterne;
import models.MedicamentInterne;
import models.ProduitStocke;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static models.PharmacieInfos.listProduitStocke;

public class StockMedicamentController implements Initializable {

    @FXML
    private TextField nomField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField prixField;

    @FXML
    private TextField modepriseField;

    @FXML
    private TextField quantiteField;

    @FXML
    private TextField numeroField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField rechercheField;

    @FXML
    private RadioButton ProdExtern;

    @FXML
    private ToggleGroup Production;

    @FXML
    private RadioButton ProdInterne;

    @FXML
    private RadioButton ouiOrdonnance;

    @FXML
    private ToggleGroup Ordonnance;

    @FXML
    private RadioButton nonOrdonnance;

    @FXML
    private TableView<ProduitStocke> produitTable;

    @FXML
    private TableColumn<ProduitStocke,String> nom,type,modeprise,quantite,numero,prix,rembourcement;

    @FXML
    private TableColumn<ProduitStocke, LocalDate> date;

    @FXML
    private TextField firmeField;

    @FXML
    private TextArea ComposantText;
    
    // afficher le champ nom firme apres avoir cocher la case "externe"
    @FXML
    void DeverouilleExterne(ActionEvent event) {
    	firmeField.setVisible(true);
    	ComposantText.setVisible(false);
    }

 // afficher le champ composant apres avoir cocher la case "interne"
    @FXML
    void DeverouilleInterne(ActionEvent event) {
    	ComposantText.setVisible(true);
    	firmeField.setVisible(false);
    }

    // afficher les detail d'un medicament
    @FXML
    void DetaillerMedicament(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("../views/MedicamentDetail.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	
    	MedicamentDetailController controller = loader.getController();
    	controller.initMedicament(produitTable.getSelectionModel().getSelectedItem());
    	
    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    // modifier un medicament
    @FXML
    void ModifierMedicament(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("../views/MedicamentModification.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	
    	MedicamentModController controller = loader.getController();
    	controller.initMedicament(produitTable.getSelectionModel().getSelectedItem());
    	
    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    // initialiser le tableau des medicaments
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    	firmeField.setVisible(false);
    	ComposantText.setVisible(false);

        nom.setCellValueFactory(new PropertyValueFactory<ProduitStocke,String>("nom"));
        type.setCellValueFactory(new PropertyValueFactory<ProduitStocke,String>("type"));
        modeprise.setCellValueFactory(new PropertyValueFactory<ProduitStocke,String>("mode_prise"));
        quantite.setCellValueFactory(new PropertyValueFactory<ProduitStocke,String>("quantite"));
        numero.setCellValueFactory(new PropertyValueFactory<ProduitStocke,String>("numerolot"));
        prix.setCellValueFactory(new PropertyValueFactory<ProduitStocke,String>("prix"));
        rembourcement.setCellValueFactory(new PropertyValueFactory<ProduitStocke,String>("tauxRembourcement"));
        date.setCellValueFactory(new PropertyValueFactory<ProduitStocke,LocalDate>("dateExp"));
        
        produitTable.setItems(listProduitStocke);
        produitTable.setEditable(true);

        nom.setCellFactory(TextFieldTableCell.forTableColumn());
        type.setCellFactory(TextFieldTableCell.forTableColumn());
        modeprise.setCellFactory(TextFieldTableCell.forTableColumn());
        quantite.setCellFactory(TextFieldTableCell.forTableColumn());
        numero.setCellFactory(TextFieldTableCell.forTableColumn());
        prix.setCellFactory(TextFieldTableCell.forTableColumn());


        // rechercher un medicament
        FilteredList<ProduitStocke> filteredData = new FilteredList<>(listProduitStocke, p -> true);
        rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(medicament -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (medicament.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }

                return false; // Does not match.
            });
        });
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<ProduitStocke> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(produitTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        produitTable.setItems(sortedData);

    }

    // ajouter un medicament
    public void ajouterProduitButtonClicked (ActionEvent event) {
    	double rembourcement = 0;
    	ProduitStocke produit;
    	
    	if(ProdExtern.isSelected()) {
    		// creer un medicament externe
    		rembourcement = Double.parseDouble(prixField.getText()) * 0.10 ;
    		 produit = new MedicamentExterne(nomField.getText(),
                    typeField.getText(),
                    modepriseField.getText(),
                    Double.toString(rembourcement),
                    numeroField.getText(),
                    quantiteField.getText(),
                    prixField.getText(),
                    dateField.getValue(),
                    ((RadioButton) Ordonnance.getSelectedToggle()).getText(),
                    ((RadioButton) Production.getSelectedToggle()).getText(),
                    firmeField.getText());
    	}else {
    		// creer un medicament interne
    		rembourcement = Double.parseDouble(prixField.getText()) * 0.20 ;
    		 produit = new MedicamentInterne(nomField.getText(),
                    typeField.getText(),
                    modepriseField.getText(),
                    Double.toString(rembourcement),
                    numeroField.getText(),
                    quantiteField.getText(),
                    prixField.getText(),
                    dateField.getValue(),
                    ((RadioButton) Ordonnance.getSelectedToggle()).getText(),
                    ((RadioButton) Production.getSelectedToggle()).getText(),
                    ComposantText.getText());
    	}

        ObservableList<ProduitStocke> list = listProduitStocke;
        boolean bool = false;

        // verifie si le medicament existe deja 
        int i=0;
        while(i<list.size() & bool != true) {
            if(list.get(i).getNom().equals(produit.getNom()) ) {
                bool=true;
            }
            i++;
        }

        if (bool == true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Medicament existe deja");
            alert.showAndWait();
        }
        else {
            listProduitStocke.add(produit);
        }

        nomField.clear();
        typeField.clear();
        modepriseField.clear();
        numeroField.clear();
        quantiteField.clear();
        prixField.clear();

    }

    // supprimer un medicament selectionnes
    public void supprimerProduitButtonClicked (ActionEvent event) {
        ProduitStocke produit = produitTable.getSelectionModel().getSelectedItem();
        listProduitStocke.remove(produit);
    }

    // retouner au menu principal
    public void retourButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) numeroField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/StockSelection.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    // modifier le champ d'un medicament selectionne
    public void changeNomCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitStocke produitSelected = produitTable.getSelectionModel().getSelectedItem();
        produitSelected.setNom(( edditedCell.getNewValue().toString()));
    }

    public void changeTypeCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitStocke produitSelected = produitTable.getSelectionModel().getSelectedItem();
        produitSelected.setType(( edditedCell.getNewValue().toString()));
    }

    public void changeModePriseCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitStocke produitSelected = produitTable.getSelectionModel().getSelectedItem();
        produitSelected.setMode_prise(( edditedCell.getNewValue().toString()));
    }

    public void changePrixCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitStocke produitSelected = produitTable.getSelectionModel().getSelectedItem();
        produitSelected.setPrix(( edditedCell.getNewValue().toString()));
    }

    public void changeTauxCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitStocke produitSelected = produitTable.getSelectionModel().getSelectedItem();
        produitSelected.setTauxRembourcement(( edditedCell.getNewValue().toString()));
    }

    public void changeQuantiteCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitStocke produitSelected = produitTable.getSelectionModel().getSelectedItem();
        produitSelected.setQuantite(( edditedCell.getNewValue().toString()));
    }

    public void changeNumeroCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitStocke produitSelected = produitTable.getSelectionModel().getSelectedItem();
        produitSelected.setNumerolot(( edditedCell.getNewValue().toString()));
    }

    public void changeOrdonnanceCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitStocke produitSelected = produitTable.getSelectionModel().getSelectedItem();
        produitSelected.setOrdonnance(( edditedCell.getNewValue().toString()));
    }

    public void changeProductionCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitStocke produitSelected = produitTable.getSelectionModel().getSelectedItem();
        produitSelected.setProduction(( edditedCell.getNewValue().toString()));
    }


}
