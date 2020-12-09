package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuController {

    @FXML
    public Button stock;
    @FXML
    public Button ventes;
    @FXML
    public Button exit;
    @FXML
    public Button commandes;
    @FXML
    public Button clients;
    @FXML
    public Button stockParapharm;

    // aller a l'interface de stock
    @FXML
    public void stockButtonClicked (ActionEvent event) throws IOException {

        Stage stage = (Stage) stock.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/StockSelection.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }

 // aller a l'interface de gestion client
    @FXML
    public void clientButtonClicked (ActionEvent event) throws  IOException{

        Stage stage = (Stage) stock.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/CLient.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }

 // aller a l'interface de gestion des ventes
    @FXML
    public void ventesButtonClicked (ActionEvent event) throws  IOException{

        Stage stage = (Stage) stock.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Vente.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

 // aller a l'interface de gestion des commandes
    @FXML
    public void commandesButtonClicked (ActionEvent event) throws  IOException{

        Stage stage = (Stage) stock.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Commande.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    // quitter le gestionnaire de la pharmacie
    @FXML
    public void exitButtonClicked (ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    // aller a l'interface de gestion des stock des produit parapharmaceutique
    @FXML
    public void StockProduitParapharmButtonClicked (ActionEvent event) throws IOException{

        Stage stage = (Stage) stockParapharm.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/StockParapharm.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    // aller a l'interface de gestion des medicaments
    @FXML
    public void StockMedicamentButtonClicked (ActionEvent event) throws IOException{

        Stage stage = (Stage) stockParapharm.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/StockMedicament.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    // retouner au menu principal
    @FXML
    public void retourButtonClicked (ActionEvent event) throws IOException{

        Stage stage = (Stage) stockParapharm.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
