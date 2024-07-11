package edu.meninocoiso.oop.projects.project3.domain;

public abstract class Content {
	protected static final double DEFAULT_XP = 10d;
	
	private String title;
	private String description;
	
	public Content(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public abstract double calculateXp();
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return "| Nome: " + getTitle() + "\n| Descrição: " + getDescription() + "\n| XP: " + calculateXp() + " pontos";
	}
}
