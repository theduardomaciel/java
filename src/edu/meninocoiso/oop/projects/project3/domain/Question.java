package edu.meninocoiso.oop.projects.project3.domain;

import java.util.List;
import java.util.Map;

public class Question {
	private final String question;
	private final Map<String, Boolean> options;
	private final QuestionType type;
	
	public Question(String question, Map<String, Boolean> options) {
		this.question = question;
		this.options = options;
		this.type = options.values().stream().filter(Boolean::booleanValue).count() > 1 ? QuestionType.TRUE_OR_FALSE : QuestionType.MULTIPLE_CHOICE;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public Map<String, Boolean> getOptions() {
		return options;
	}
	
	public QuestionType getType() {
		return type;
	}
	
	public List<String> getCorrectOptions() {
		return options.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).toList();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pergunta: ").append(question).append("\n");
		options.forEach((option, correct) -> sb.append(option).append(" - ").append(correct ? "correta" : "errada").append("\n"));
		return sb.toString();
	}
}
