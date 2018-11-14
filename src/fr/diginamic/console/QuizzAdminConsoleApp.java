package fr.diginamic.console;

import java.util.Scanner;

public class QuizzAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner questionUser = new Scanner(System.in);
		boolean sortir = false;
		while (!sortir) {
			afficheMenu();
			int a = questionUser.nextInt();
		
			switch(a) {
				case 1: System.out.println("Liste des question");
					
					break;
					case 2: System.out.println("Ajout d'une nouvelle question");
					
					break;
					case 3: System.out.println("Suppression d'une question");
					
					break;
					case 4: System.out.println("Exécution du quizz");
					
					break;
					case 99: System.out.println("Au revoir");
					questionUser.close();
					sortir = true;
					break;
					default: break;
		}
		}
	}
	
	public static void afficheMenu() {
		System.out.println("***** Quizz Administration *****");
		System.out.println("Faites votre choix");
		System.out.println("1. Lister les questions\n2. Ajouter une nouvelle question\n3. Supprimer une question\n4. Exécuter le quizz\n99. Sortir");
		
	}

}
