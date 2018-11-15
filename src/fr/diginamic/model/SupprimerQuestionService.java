package fr.diginamic.model;

import java.util.Scanner;

import fr.diginamic.exception.SupprimerQuestionException;

public class SupprimerQuestionService extends MenuService{
	
	@Override
	public void executeUC(Scanner scanner, QuestionDao dao) throws SupprimerQuestionException{
		
		System.out.println("Veuillez indiquer le numéro de la question à supprimer (entre 1 et "+dao.findAll().size()+")");
		int indexSuppr = Integer.parseInt(scanner.nextLine());
		if(indexSuppr>dao.findAll().size()) {
			throw new SupprimerQuestionException("Le nombre doit être inférieur à "+dao.findAll().size());
			
		}
		dao.delete(dao.findAll().get(indexSuppr-1));
		
	}

}
