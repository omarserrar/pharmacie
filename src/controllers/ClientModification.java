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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.PharmacieInfos;
import models.Client;

public class ClientModification implements Initializable {

	@FXML
	private TextField nomfield;

	@FXML
	private TextField prenomfield;

	@FXML
	private TextField agefield;

	@FXML
	private TextField numfield;

	@FXML
	private TextField maladiefield;

	@FXML
	private TextField traitementfield;

	// recevoir les information du client selectionne et les affichees
	public void initClient(Client cl) {
		nomfield.setText(cl.getNom());
		prenomfield.setText(cl.getPrenom());
		agefield.setText(cl.getAge());
		numfield.setText(cl.getNum_ss());
		maladiefield.setText(cl.getMaladie());
		traitementfield.setText(cl.getTraitement());
	}

	// annuler l'operation de modification
	@FXML
	void Annuler(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../views/Client.fxml"));
		Scene scene = new Scene(root);

		Stage window = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	// enregistrer les modification qui ont ete faite
	@FXML
	void EnregistrerModification(ActionEvent event) throws IOException {

		int i = 0;
		for (i = 0; i < PharmacieInfos.listClient.size(); i++) {
			if (PharmacieInfos.listClient.get(i).getNom().equals(nomfield.getText())
					&& PharmacieInfos.listClient.get(i).getPrenom().equals(prenomfield.getText())) {
				PharmacieInfos.listClient.get(i).setNum_ss(numfield.getText());
				PharmacieInfos.listClient.get(i).setMaladie(maladiefield.getText());
				PharmacieInfos.listClient.get(i).setTraitement(traitementfield.getText());
				break;
			}
		}
		Parent root = FXMLLoader.load(getClass().getResource("../views/Client.fxml"));
		Scene scene = new Scene(root);

		Stage window = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		 le nom et prenom ne peuvent pas etre modifierj
		nomfield.setEditable(false);
		prenomfield.setEditable(false);
	}

}
