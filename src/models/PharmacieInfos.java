
package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.time.LocalDate;

public class PharmacieInfos {

    public static ObservableList<ProduitStocke> listProduitStocke = FXCollections.observableArrayList(
    		new MedicamentExterne("Amodex 1g", "Comprim�", "Orale", "150", "546", "30", "1500", LocalDate.of(2022, 11, 20), "oui", "Externe", "fabriquant 1"),
            new MedicamentInterne("Paracetamol 500mg", "Antibiotique", "Orale", "60", "959", "60", "300", LocalDate.of(2021, 10, 21), "non", "Interne", "sodium 409 mg/cp "),
            new MedicamentInterne("Baclofene 10mg", "genetique", "Injectable", "600", "912", "15", "3000", LocalDate.of(2020, 12, 31), "oui", "Interne", "amidon de mais pregelatinise, cellulose microcristalline, silice dioxyde "),            
            new MedicamentExterne("Omeprazole", "Antisecretoire", "Orale", "150", "566", "50", "500", LocalDate.of(2021, 01, 19), "non", "Externe", "fabriquant 2"),
            new MedicamentExterne("Benzodiazepine", "Antihistaminique", "Orale", "85", "513", "42", "850", LocalDate.of(2022, 8, 4), "non", "Externe", "fabriquant 3")
    		);

    public static ObservableList<ProduitParapharmaceutique> listProduitParapharm = FXCollections.observableArrayList(
            new ProduitParapharmaceutique("Gel Vichy","Gel Hydroalcoolique","350","55"),
            new ProduitParapharmaceutique("Masque protection","FFP2","200","60"),
            new ProduitParapharmaceutique("Lingette waterwipe","Coton Absorbante","440","30"),
            new ProduitParapharmaceutique("Gants","Medicale","220","40"),
            new ProduitParapharmaceutique("Brosse a dent OraleB","Electrique","690","24")
    );

    public static ObservableList<Client> listClient = FXCollections.observableArrayList(
            new Client ("Kendjouh","Soheib","20","181831049402","Aucune","Rien"),
            new Client ("Bekdouche","Ali","20","181831049412","Aucune","Rien"),
            new Client ("Karoun","Yacine","20","181831049452","Aucune","Paracetamol et Amodex")
    );

    public static ObservableList<Commande> listCommande = FXCollections.observableArrayList(
            new Commande("Efferalgan","40","Pharmacie","Fournisseur 1"),
            new Commande("Toplexil","50","Pharmacie","Fournisseur 2"),
            new Commande("Visine Secheresse","5","S.Kendjouh","Optic Fourniture")
    );

    public static  ObservableList<Vente> listVente = FXCollections.observableArrayList(
            new Vente("Amodex 1g","Y.Karoun","2",LocalDate.of(2020,10,22),"7","oui","oui")
    );

}
