package Main;
import controllers.PharmacieController;
import views.Menu;

public class Main {

	public static void main(String[] args) {
		PharmacieController pharmacieController = PharmacieController.getPharmacieController();
		pharmacieController.pharmacieMenuPrincipale();
	}

}
