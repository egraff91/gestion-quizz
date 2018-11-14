package fr.diginamic.console;

import java.util.ArrayList;
import java.util.Scanner;
import fr.diginamic.model.*;

public class QuizzAdminConsoleApp {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Question> questions = new ArrayList();
		
		
		Question question1 = new Question("Quelle est la capitale de la France ?", "Paris");
		question1.addProposition("Madrid");
		question1.addProposition("Versailles");
		question1.addProposition("Paris");
		question1.addProposition("Londres");
		
		Question question2 = new Question("En quelle année l'Homme a t-il posé le pied sur la Lune ?", "1969");
		question2.addProposition("1968");
		question2.addProposition("1969");
		question2.addProposition("1970");
		question2.addProposition("1971");
		
		questions.add(question1);
		questions.add(question2);
		
		Scanner questionUser = new Scanner(System.in);
		boolean sortir = false;
		while (!sortir) {
			afficheMenu();
			int a = questionUser.nextInt();
		
			switch(a) {
				case 1: System.out.println("Liste des questions");
					afficheQuestions(questions);
					
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
	
	public static void afficheQuestions(ArrayList<Question> questions) {
		for(int i=0; i<questions.size();i++) {
			System.out.println(i+1+") "+questions.get(i).getIntitule());
			for(int j=0; j<questions.get(i).getPropositions().size();j++) {
				System.out.println("     - "+questions.get(i).getPropositions().get(j));
			}
			
		}
		
	}

}
