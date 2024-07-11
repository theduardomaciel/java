package edu.meninocoiso.oop.projects.project2.domain;

import edu.meninocoiso.oop.projects.project2.data.TransactionType;

public class Transaction {
	private final double value;
	private final TransactionType type;
	
	private Account otherAccount;
	
	public Transaction(double value, TransactionType type, Account otherAccount) {
		this.value = value;
		this.type = type;
		this.otherAccount = otherAccount;
	}
	
	@Override
	public String toString() {
		String formattedValue = String.format("%.2f", value);
		
		if (otherAccount != null) {
			return "Transação de " + type + " no valor de R$ " + formattedValue + " -> Conta: " + otherAccount.getAccountInfo();
		}
		
		return "Transação de " + type + " no valor de R$ " + formattedValue;
	}
}
