package edu.meninocoiso.oop.projects.project2;

import edu.meninocoiso.oop.projects.project2.domain.Bank;
import edu.meninocoiso.oop.projects.project2.domain.CheckingAccount;
import edu.meninocoiso.oop.projects.project2.domain.Client;
import edu.meninocoiso.oop.projects.project2.domain.SavingsAccount;

public class Main {
	private static void separator() {
		System.out.println("--------------------------------------------------");
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank("Banco do Brasil");
		
		Client fernando = new Client(
				"Fernando Almeida",
				"123.456.789-00",
				"Rua dos Bosques, 0",
				"(00) 1234-5678"
		);
		
		Client amanda = new Client(
				"Amanda Santos",
				"987.654.321-00",
				"Rua dos Brilhantes, 0",
				"(00) 8765-4321"
		);
		
		bank.addClient(fernando);
		bank.addClient(amanda);
		
		bank.printClients();
		
		// Vamos realizar algumas operações bancárias com as contas de Fernando.
		System.out.println("Operações bancárias com as contas de Fernando Almeida:\n");
		
		CheckingAccount checkingAccount = fernando.getCheckingAccount();
		SavingsAccount savingsAccount = fernando.getSavingsAccount();
		
		checkingAccount.printExtract();
		savingsAccount.printExtract();
		
		System.out.println("Depositando o salário de R$ 1.250,00 na Conta Corrente...");
		checkingAccount.deposit(1250);
		checkingAccount.printBalance();
		
		separator();
		
		System.out.println("Transferindo R$ 425,00 da Conta Corrente para a Conta Poupança...");
		checkingAccount.transfer(425, savingsAccount);
		checkingAccount.printBalance();
		savingsAccount.printBalance();
		
		separator();
		
		System.out.println("Realizando compra de um liquidificador de R$ 229,99 na Conta Poupança...");
		savingsAccount.withdraw(299.99f);
		savingsAccount.printBalance();
		
		separator();
		
		System.out.println("Realizando compra de Hollow Knight no valor de R$ 62,00 na Conta Poupança...");
		savingsAccount.withdraw(62);
		savingsAccount.printBalance();
		
		separator();
		
		System.out.println("Realizando compra de um novo teclado de R$ 187,50 na Conta Poupança...");
		savingsAccount.withdraw(187.50f);
		savingsAccount.printBalance();
		
		separator();
		
		System.out.println("Realizando a feira do mês no valor de R$ 654,23 na Conta Corrente...");
		checkingAccount.withdraw(654.23f);
		checkingAccount.printBalance();
		
		separator();
		
		checkingAccount.printTransactions();
		savingsAccount.printTransactions();
		
		bank.removeClient(fernando);
		
		System.out.println("Clientes do banco após a remoção de Fernando:");
		bank.printClients();
	}
}
