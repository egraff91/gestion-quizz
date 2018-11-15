package fr.diginamic.model;

import java.util.ArrayList;
import java.util.Scanner;

public class ExecuterQuizzService extends MenuService{
	
	public void executeUC(Scanner scanner, QuestionDao dao) {
		ArrayList<Question> questions = (ArrayList<Question>) dao.findAll();
		int score = 0;
		for(int i= 0; i<questions.size();i++) {
			ListerQuestionsService.afficheQuestion(i+1, questions.get(i));
			System.out.println("Veuillez choisir une réponse");
			String reponse = scanner.nextLine();
			if(questions.get(i).verifierReponse(reponse)) {
				System.out.println("Bonne réponse");
				if(questions.get(i).getType().equals(TypeQuestion.BONUS)) {
					score = score+2;
				}else {
					score++;
				}
				
			}else {
				System.out.println("Mauvaise réponse");
			}
		}
		System.out.println("Votre score: "+score);
	}
	
	/*public static void afficheQuestion(int numero, Question question) {
		System.out.println(numero+") "+question.getIntitule());
		for(int j=0; j<question.getPropositions().size();j++) {
			System.out.println("     - "+question.getPropositions().get(j));
		}
	}*/

}
