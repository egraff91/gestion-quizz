package fr.diginamic.model;

import java.util.Scanner;

public class SupprimerQuestionService extends MenuService{
	
	public void executeUC(Scanner scanner, QuestionDao dao) {
		System.out.println("Veuillez indiquer le numéro de la question à supprimer (entre 1 et "+dao.findAll().size()+")");
		int indexSuppr = Integer.parseInt(scanner.nextLine());
		dao.delete(dao.findAll().get(indexSuppr-1));
	}

}
