package fr.diginamic.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionMemDao implements QuestionDao {

	private ArrayList<Question> questions = new ArrayList<Question>();
	
	@Override
	public List<Question> findAll() {
	
		return this.questions;
	}

	@Override
	public void save(Question question) {
		// TODO Auto-generated method stub
		questions.add(question);
	}

	@Override
	public void delete(Question question) {
		// TODO Auto-generated method stub
		questions.remove(question);
	}

}
