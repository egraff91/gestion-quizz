package fr.diginamic.model;

import java.util.ArrayList;
import java.util.Scanner;

public class AjouterQuestionService extends MenuService{
	
	public void executeUC(Scanner scanner, QuestionDao dao) {
		ArrayList<String> propositions = new ArrayList<String>();
		System.out.println("Veuillez saisir l'intitulé de la question: ");
		String intitule = scanner.nextLine();
		System.out.println("Veuillez saisir le nombre de réponses: ");
		int nombreReponses = Integer.parseInt(scanner.nextLine());
		for (int i= 0; i<nombreReponses; i++) {
			System.out.println("Veuillez saisir la proposition de réponse "+(i+1)+":");
			propositions.add(scanner.nextLine());
		}
		System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et "+nombreReponses+"):");
		int indexReponse = Integer.parseInt(scanner.nextLine());
		//System.out.println(indexReponse+" "+propositions);
		String bonneReponse = propositions.get(indexReponse-1);
		
		Question nouvelleQuestion = new Question(intitule,bonneReponse);
		//System.out.println("test");
		nouvelleQuestion.setPropositions(propositions);
		dao.save(nouvelleQuestion);
	}

}
