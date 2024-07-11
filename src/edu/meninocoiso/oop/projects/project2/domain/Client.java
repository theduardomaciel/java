package edu.meninocoiso.oop.projects.project2.domain;

public class Client {
	private final String name;
	private final String cpf;
	private final String address;
	private final String phoneNumber;
	
	private CheckingAccount checkingAccount;
	private SavingsAccount savingsAccount;
	
	public Client(String name, String cpf, String address, String phoneNumber) {
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.checkingAccount = new CheckingAccount(this);
		this.savingsAccount = new SavingsAccount(this);
	}
	
	public String getName() {
		return name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public CheckingAccount getCheckingAccount() {
		return checkingAccount;
	}
	
	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}
	
	@Override
	public String toString() {
		return name + " (" + cpf + ")";
	}
}
