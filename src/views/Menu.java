package views;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	ArrayList<String> menu = new ArrayList();
	
	public void ajouterElementMenu(String text) {
		menu.add(text);
	}
	private void showMenu() {
		int i=0;
		for(String element : menu) {
			System.out.println((i+1)+" "+menu);
			i++;
		}
	}
	public String getString(String label) {
		System.out.println(label);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	public int getInt(String label) {
		System.out.println(label);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	public int openMenu() {
		showMenu();
		Scanner sc = new Scanner(System.in);
		boolean stop = false;
		while(!stop) {
			try {
				int choix = sc.nextInt();
				if(choix<=menu.size() && choix >0) {
					return choix;
				}
				else {
					System.out.println("Choix Incorrect");
					showMenu();
				}
			}
			catch(Exception e) {
				System.out.println("Choix Incorrect");
				showMenu();
			}
		}
		return -1;
	}
	
};
