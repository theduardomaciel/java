package edu.meninocoiso.oop.projects.project2.domain;

import edu.meninocoiso.oop.projects.project2.data.IAccount;
import edu.meninocoiso.oop.projects.project2.data.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
	private static final int DEFAULT_AGENCY = 1;
	private static int CURRENT_INDEX = 1;
	
	private final int agency;
	private final int number;
	protected double balance;
	private final Client client;
	private final List<Transaction> transactions;
	
	public Account(Client client) {
		this.agency = DEFAULT_AGENCY;
		this.number = CURRENT_INDEX++;
		this.balance = 0;
		this.client = client;
		this.transactions = new ArrayList<>();
	}
	
	@Override
	public boolean withdraw(double amount, Account other) {
		if (amount > balance) {
			System.out.println("Fundos insuficientes.");
			return false;
		}
		
		balance -= amount;
		
		transactions.add(new Transaction(amount, TransactionType.WITHDRAW, other));
		
		return true;
	}
	
	@Override
	public void deposit(double amount, Account other) {
		// Ao realizar um depósito, o saldo da conta de destino é atualizado
		// e uma transação é registrada na conta de origem e na conta de destino.
		this.balance += amount;
		this.transactions.add(new Transaction(amount, TransactionType.DEPOSIT, other));
	}
	
	@Override
	public void transfer(double amount, Account other) {
		boolean withdrawSuccess = this.withdraw(amount, other);
		
		if (withdrawSuccess) {
			other.deposit(amount, this);
		} else {
			System.out.println("Transferência não realizada.");
		}
	}
	
	@Override
	public void printExtract() {
		System.out.print("| Titular: " + client.getName());
		System.out.printf(", CPF: %s\n", client.getCpf());
		System.out.print("| Agência: " + agency);
		System.out.println(", nº " + number);
		System.out.printf("| Saldo atual: R$ %.2f%n", balance);
		System.out.println();
	}
	
	public String getAccountInfo() {
		return agency + "-" + number;
	}
	
	public void printBalance() {
		System.out.printf("Saldo atual: R$ %.2f%n", balance);
	}
	
	public void printTransactions() {
		for (Transaction transaction : transactions) {
			System.out.println("| " + transaction.toString());
		}
		System.out.println();
	}
}
