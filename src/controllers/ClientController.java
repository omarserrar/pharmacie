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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import models.Client;
import models.ProduitParapharmaceutique;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static models.PharmacieInfos.listClient;

public class ClientController implements Initializable {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField numeroField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField traitementField;

    @FXML
    private TextField maladieField;

    @FXML
    private TextField rechercheField;

    @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableColumn<Client,String> nom,prenom,numero,age;
    
    //afficher les details du client selectionnes
    @FXML
    void DetaillerClient(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("../views/ClientDetail.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	
    	ClientDetail controller = loader.getController();
    	controller.initClient(clientTable.getSelectionModel().getSelectedItem());
    	
    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    //afficher l'interface pour modifier un client 
    @FXML
    void ModifierClient(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("views/ClientModification.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	
    	ClientModification controller = loader.getController();
    	controller.initClient(clientTable.getSelectionModel().getSelectedItem());
    	
    	Stage window = (Stage) ((Node) ( event.getSource())).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
        age.setCellValueFactory(new PropertyValueFactory<Client,String>("age"));
        numero.setCellValueFactory(new PropertyValueFactory<Client,String>("num_ss"));

        // initialiser le tableau des clients 
        
        clientTable.setItems(listClient);
        clientTable.setEditable(true);

        nom.setCellFactory(TextFieldTableCell.forTableColumn());
        prenom.setCellFactory(TextFieldTableCell.forTableColumn());
        age.setCellFactory(TextFieldTableCell.forTableColumn());
        numero.setCellFactory(TextFieldTableCell.forTableColumn());


        // pour rechercher un client avec son nom
        
        FilteredList<Client> filteredData = new FilteredList<>(listClient, p -> true);
        rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(client -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (client.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }

                return false; // Does not match.
            });
        });
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Client> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(clientTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        clientTable.setItems(sortedData);


    }

    // ajouter un client dans la liste des clients
    
    public void ajouterButtonClicked (ActionEvent event) {

        Client client = new Client (nomField.getText(),prenomField.getText(),ageField.getText(),numeroField.getText(),maladieField.getText(),traitementField.getText());
        ObservableList<Client> list = listClient;
        boolean bool = false;

        // verifie si le client existe deja
        int i=0;
        while(i<list.size() & bool != true) {
            if(list.get(i).getNom().equals(client.getNom()) && list.get(i).getPrenom().equals(client.getPrenom())) {
                bool=true;
            }
            i++;
        }

        if (bool == true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Client existe deja");
            alert.showAndWait();
        }
        else {
            listClient.add(client);
        }

        nomField.clear();
        prenomField.clear();
        ageField.clear();
        maladieField.clear();
        traitementField.clear();
        numeroField.clear();
    }

    //supprimer un client
    public void supprimerButtonClicked (ActionEvent event) {
        Client client  = clientTable.getSelectionModel().getSelectedItem();
        listClient.remove(client);
    }

    // retourner au menu principal
    public void retourButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) nomField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    // modifier le nom du client selectionne 
    public void changeNomCellEvent (TableColumn.CellEditEvent edditedCell) {

        Client client = clientTable.getSelectionModel().getSelectedItem();
        client.setNom(( edditedCell.getNewValue().toString()));
    }

 // modifier le prenom du client selectionne 
    public void changePrenomCellEvent (TableColumn.CellEditEvent edditedCell) {

        Client client = clientTable.getSelectionModel().getSelectedItem();
        client.setPrenom(( edditedCell.getNewValue().toString()));
    }

 // modifier l'age du client selectionne 
    public void changeAgeCellEvent (TableColumn.CellEditEvent edditedCell) {

        Client client = clientTable.getSelectionModel().getSelectedItem();
        client.setAge(( edditedCell.getNewValue().toString()));
    }

 // modifier le numero du client selectionne 
    public void changeNumeroCellEvent (TableColumn.CellEditEvent edditedCell) {

        Client client = clientTable.getSelectionModel().getSelectedItem();
        client.setNum_ss(( edditedCell.getNewValue().toString()));
    }
}
