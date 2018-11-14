package fr.diginamic.model;

import java.util.ArrayList;

public class Question {
	
	private int id=0;
	private String intitule;
	private ArrayList<String> propositions;
	private String bonneReponse;
	
	public Question(String intitule, String bonneReponse) {
		this.intitule = intitule;
		this.bonneReponse = bonneReponse;
		this.id++;
	}
	
	public boolean verifierReponse(String reponse) {
		
		return this.bonneReponse.equalsIgnoreCase(reponse);
	}
	
	public void addProposition(String proposition) {
		this.propositions.add(proposition);
	}

}
