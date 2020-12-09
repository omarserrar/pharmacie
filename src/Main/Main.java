package Main;
import controllers.PharmacieController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	PharmacieController pharmacieController = PharmacieController.getPharmacieController();
	
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../views/Menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Gestion de Pharmacie");
            primaryStage.setScene(scene);
            scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //launch(args);
    }
}