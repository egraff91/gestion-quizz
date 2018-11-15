package fr.diginamic.model;

import java.util.Scanner;

public class ListerQuestionsService extends MenuService{
	
	public void executeUC(Scanner scanner, QuestionDao dao) {
		for(int i=0; i<dao.findAll().size();i++) {
			afficheQuestion(i+1,dao.findAll().get(i));
		}
	}

	public static void afficheQuestion(int numero, Question question) {
		System.out.println(numero+") "+question.getIntitule());
		for(int j=0; j<question.getPropositions().size();j++) {
			System.out.println("     - "+question.getPropositions().get(j));
		}
	}
}
