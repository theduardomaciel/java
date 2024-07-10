package edu.meninocoiso.oop.projects.project2;

public class CheckingAccount extends Account {
	public CheckingAccount(Client client) {
		super(client);
	}
	
	@Override
	public void printExtract() {
		System.out.println("Extrato da Conta Corrente:");
		super.printExtract();
	}
	
	@Override
	public void printBalance() {
		System.out.printf("Saldo da Conta Corrente: R$ %.2f%n", balance);
	}
	
	@Override
	public void printTransactions() {
		System.out.println("Transações da Conta Corrente (" + this.getAccountInfo() + "):");
		super.printTransactions();
	}
}
