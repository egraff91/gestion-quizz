package fr.diginamic.model;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.exception.AjouterQuestionException;

public class AjouterQuestionService extends MenuService{
	
	public void executeUC(Scanner scanner, QuestionDao dao) throws AjouterQuestionException{
		
		ArrayList<String> propositions = new ArrayList<String>();
		System.out.println("Souhaitez-vous créer uen question SIMPLE ou BONUS ?: ");
		String type = scanner.nextLine();
		System.out.println("Veuillez saisir l'intitulé de la question: ");
		String intitule = scanner.nextLine();
		System.out.println("Veuillez saisir le nombre de réponses: ");
		int nombreReponses = Integer.parseInt(scanner.nextLine());
		
		if(nombreReponses <2) {
			throw new AjouterQuestionException("Le nombre de réponses doit être supérieur ou égal à 2");
		}
		
		for (int i= 0; i<nombreReponses; i++) {
			System.out.println("Veuillez saisir la proposition de réponse "+(i+1)+":");
			propositions.add(scanner.nextLine());
		}
		
		System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et "+nombreReponses+"):");
		int indexReponse = Integer.parseInt(scanner.nextLine());
		String bonneReponse = propositions.get(indexReponse-1);
		
		Question nouvelleQuestion = new Question(intitule,bonneReponse);
		nouvelleQuestion.setType(type);
		nouvelleQuestion.setPropositions(propositions);
		
		dao.save(nouvelleQuestion);
	}

}
