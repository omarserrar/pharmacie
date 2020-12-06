package Main;
import views.Menu;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.ajouterElementMenu("Dit Bonjour");
		menu.ajouterElementMenu("Dit Zebi");
		
		int resultat = menu.openMenu();
		System.out.println(resultat);
	}

}
