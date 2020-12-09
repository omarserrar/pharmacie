package controllers;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import models.ProduitParapharmaceutique;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static models.PharmacieInfos.listProduitParapharm;

public class StockParapharmController implements Initializable {

    @FXML
    private TextField nomField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField prixField;

    @FXML
    private TextField quantiteField;

    @FXML
    private TextField rechercheField;

    @FXML
    private TableView<ProduitParapharmaceutique> produitParapharmTable;

    @FXML
    private TableColumn<ProduitParapharmaceutique,String> nom,type,prix,quantite;


    //initialiser les informations de la table des produits parapharmaceutique
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nom.setCellValueFactory(new PropertyValueFactory<ProduitParapharmaceutique,String>("nom"));
        type.setCellValueFactory(new PropertyValueFactory<ProduitParapharmaceutique,String>("type"));
        prix.setCellValueFactory(new PropertyValueFactory<ProduitParapharmaceutique,String>("prix"));
        quantite.setCellValueFactory(new PropertyValueFactory<ProduitParapharmaceutique,String>("quantite"));

        produitParapharmTable.setItems(listProduitParapharm);
        produitParapharmTable.setEditable(true);

        nom.setCellFactory(TextFieldTableCell.forTableColumn());
        type.setCellFactory(TextFieldTableCell.forTableColumn());
        prix.setCellFactory(TextFieldTableCell.forTableColumn());
        quantite.setCellFactory(TextFieldTableCell.forTableColumn());


        // rechercher un produit parapharmaceutique
        FilteredList<ProduitParapharmaceutique> filteredData = new FilteredList<>(listProduitParapharm, p -> true);
        rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(produit -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (produit.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }

                return false; // Does not match.
            });
        });
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<ProduitParapharmaceutique> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(produitParapharmTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        produitParapharmTable.setItems(sortedData);

    }


    // ajouter un produit
    public void ajouterButtonClicked (ActionEvent event) {

        ProduitParapharmaceutique produit = new ProduitParapharmaceutique(nomField.getText(),typeField.getText(),prixField.getText(),quantiteField.getText());

        ObservableList<ProduitParapharmaceutique> list = listProduitParapharm;
        boolean bool = false;

        // verifie si le produit existe deja 
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
            alert.setContentText("Produit existe deja");
            alert.showAndWait();
        }
        else {
            listProduitParapharm.add(produit);
        }
        nomField.clear();
        typeField.clear();
        quantiteField.clear();
        prixField.clear();
    }

    // supprimer un produit selectionne
    public void supprimerButtonClicked (ActionEvent event) {

        ProduitParapharmaceutique produit = produitParapharmTable.getSelectionModel().getSelectedItem();
        listProduitParapharm.remove(produit);

    }
 
    // retourner au menu principal
    public void retourButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) nomField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views//StockSelection.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    // modifier les champs d'un produit selectionne
    public void changeNomCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitParapharmaceutique produitSelected = produitParapharmTable.getSelectionModel().getSelectedItem();
        produitSelected.setNom(( edditedCell.getNewValue().toString()));
    }

    public void changeTypeCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitParapharmaceutique produitSelected = produitParapharmTable.getSelectionModel().getSelectedItem();
        produitSelected.setType(( edditedCell.getNewValue().toString()));
    }

    public void changePrixCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitParapharmaceutique produitSelected = produitParapharmTable.getSelectionModel().getSelectedItem();
        produitSelected.setPrix(( edditedCell.getNewValue().toString()));
    }

    public void changeQuantiteCellEvent (TableColumn.CellEditEvent edditedCell) {

        ProduitParapharmaceutique produitSelected = produitParapharmTable.getSelectionModel().getSelectedItem();
        produitSelected.setQuantite(( edditedCell.getNewValue().toString()));
    }
}
