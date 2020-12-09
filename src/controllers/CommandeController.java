package controllers;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import models.Commande;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static models.PharmacieInfos.listCommande;

public class CommandeController implements Initializable {

    @FXML
    private TextField nomClientField;

    @FXML
    private TextField nomFournisseurField;

    @FXML
    private TextField nomProduitField;

    @FXML
    private TextField quantiteField;

    @FXML
    private TextField rechercheField;

    @FXML
    private TableView<Commande> commandeTable;

    @FXML
    private TableColumn<Commande , String> nomClient,produit,fournisseur,quantite;

    // initialiser le tableau des commandes avec la liste des commandes
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nomClient.setCellValueFactory(new PropertyValueFactory<Commande,String>("nom_client"));
        produit.setCellValueFactory(new PropertyValueFactory<Commande,String>("prod_commande"));
        fournisseur.setCellValueFactory(new PropertyValueFactory<Commande,String>("nom_fournisseur"));
        quantite.setCellValueFactory(new PropertyValueFactory<Commande,String>("quantite"));

        commandeTable.setItems(listCommande);
        commandeTable.setEditable(true);

        nomClient.setCellFactory(TextFieldTableCell.forTableColumn());
        produit.setCellFactory(TextFieldTableCell.forTableColumn());
        fournisseur.setCellFactory(TextFieldTableCell.forTableColumn());
        quantite.setCellFactory(TextFieldTableCell.forTableColumn());

        // rechercher une commande dans le tableau des commandes en tapant le nom du produit
        FilteredList<Commande> filteredData = new FilteredList<>(listCommande, p -> true);
        rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(commande -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (commande.getProd_commande().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }

                return false; // Does not match.
            });
        });
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Commande> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(commandeTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        commandeTable.setItems(sortedData);

    }

    //ajouter une commande a la liste des commandes
    public void ajouterButtonClicked (ActionEvent event) {
        Commande commande = new Commande (nomProduitField.getText(),quantiteField.getText(),nomClientField.getText(),nomFournisseurField.getText());
        listCommande.add(commande);

        nomClientField.clear();
        nomFournisseurField.clear();
        nomProduitField.clear();
        quantiteField.clear();
    }

    //supprimer une commande du tableau ( de la liste )
    public void supprimerButtonClicked (ActionEvent event) {
        Commande commande = commandeTable.getSelectionModel().getSelectedItem();
        listCommande.remove(commande);

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
    
 // modifier le nom du client selectionne 
    public void changeNomClientCellEvent (TableColumn.CellEditEvent edditedCell) {

        Commande commande = commandeTable.getSelectionModel().getSelectedItem();
        commande.setNom_client(( edditedCell.getNewValue().toString()));
    }

 // modifier le nom du produit selectionne 
    public void changeNomProduitCellEvent (TableColumn.CellEditEvent edditedCell) {

        Commande commande = commandeTable.getSelectionModel().getSelectedItem();
        commande.setProd_commande(( edditedCell.getNewValue().toString()));
    }

 // modifier le nom du fournisseur selectionne 
    public void changeNomFournisseurCellEvent (TableColumn.CellEditEvent edditedCell) {

        Commande commande = commandeTable.getSelectionModel().getSelectedItem();
        commande.setNom_fournisseur(( edditedCell.getNewValue().toString()));
    }

 // modifier la quantite selectionne 
    public void changeQuantiteCellEvent (TableColumn.CellEditEvent edditedCell) {

        Commande commande = commandeTable.getSelectionModel().getSelectedItem();
        commande.setQuantite(( edditedCell.getNewValue().toString()));
    }

}
