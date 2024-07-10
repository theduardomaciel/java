package edu.meninocoiso.oop.projects.project2.data;

public enum TransactionType {
	DEPOSIT("Depósito"),
	WITHDRAW("Saque");
	
	private String description;
	
	private TransactionType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
