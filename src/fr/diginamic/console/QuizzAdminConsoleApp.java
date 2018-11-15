package fr.diginamic.console;

import java.util.ArrayList;
import java.util.Scanner;
import fr.diginamic.model.*;

public class QuizzAdminConsoleApp {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Question> questions = new ArrayList<Question>();
		
		
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
			int a = Integer.parseInt(questionUser.nextLine());
		
			switch(a) {
				case 1: System.out.println("Liste des questions");
					afficheQuestions(questions);
					
					break;
					case 2: System.out.println("Ajout d'une nouvelle question");
					questions.add(nouvelleQuestion(questionUser));
					
					break;
					case 3: System.out.println("Suppression d'une question");
					supprimeQuestion(questions, questionUser);
					
					break;
					case 4: System.out.println("Exécution du quizz");
					startQuizz(questions, questionUser);
					
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
			afficheQuestion(i+1,questions.get(i));
		}
		
	}
	
	public static void afficheQuestion(int numero, Question question) {
		System.out.println(numero+") "+question.getIntitule());
		for(int j=0; j<question.getPropositions().size();j++) {
			System.out.println("     - "+question.getPropositions().get(j));
		}
	}
	
	public static Question nouvelleQuestion(Scanner questionUser) {
		ArrayList<String> propositions = new ArrayList<String>();
		System.out.println("Veuillez saisir l'intitulé de la question: ");
		String intitule = questionUser.nextLine();
		System.out.println("Veuillez saisir le nombre de réponses: ");
		int nombreReponses = Integer.parseInt(questionUser.nextLine());
		for (int i= 0; i<nombreReponses; i++) {
			System.out.println("Veuillez saisir la proposition de réponse "+(i+1)+":");
			propositions.add(questionUser.nextLine());
		}
		System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et "+nombreReponses+"):");
		int indexReponse = Integer.parseInt(questionUser.nextLine());
		//System.out.println(indexReponse+" "+propositions);
		String bonneReponse = propositions.get(indexReponse-1);
		
		Question nouvelleQuestion = new Question(intitule,bonneReponse);
		//System.out.println("test");
		nouvelleQuestion.setPropositions(propositions);
		//demandeQuestion.close();
		return nouvelleQuestion;
	}
	
	public static void supprimeQuestion(ArrayList<Question> questions, Scanner questionUser) {
		System.out.println("Veuillez indiquer le numéro de la question à supprimer (entre 1 et "+questions.size()+")");
		int indexSuppr = Integer.parseInt(questionUser.nextLine());
		questions.remove(indexSuppr-1);
		
	}
	
	public static void startQuizz(ArrayList<Question> questions, Scanner questionUser) {
		int score = 0;
		for(int i= 0; i<questions.size();i++) {
			afficheQuestion(i+1, questions.get(i));
			System.out.println("Veuillez choisir une réponse");
			String reponse = questionUser.nextLine();
			if(questions.get(i).verifierReponse(reponse)) {
				System.out.println("Bonne réponse");
				score++;
			}else {
				System.out.println("Mauvaise réponse");
			}
		}
		System.out.println("Votre score: "+score);
	}

}
