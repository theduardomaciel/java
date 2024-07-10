package edu.meninocoiso.oop.projects.project2;

public class SavingsAccount extends Account {
	public SavingsAccount(Client client) {
		super(client);
	}
	
	@Override
	public void printExtract() {
		System.out.println("Extrato da Conta Poupança:");
		super.printExtract();
	}
	
	@Override
	public void printBalance() {
		System.out.printf("Saldo da Conta Poupança: R$ %.2f%n", balance);
	}
	
	@Override
	public void printTransactions() {
		System.out.println("Transações da Conta Poupança (" + this.getAccountInfo() + "):");
		super.printTransactions();
	}
}
