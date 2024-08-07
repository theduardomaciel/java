package edu.meninocoiso.basic.syntax.project;

import edu.meninocoiso.basic.syntax.Localization;

import java.util.Scanner;

public class BankAccount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in).useLocale(Localization.BR);
		
		System.out.println("Digite o número da sua conta: ");
		int accountNumber = scanner.nextInt(); // Exemplo: 1021
		
		scanner.nextLine(); // Consumir a quebra de linha
		
		System.out.println("Digite a sua agência: ");
		String agency = scanner.nextLine(); // Exemplo: "067-8"
		
		System.out.println("Digite o seu nome: ");
		String clientName = scanner.nextLine(); // Exemplo: "João da Silva"
		
		System.out.println("Digite o saldo da sua conta: ");
		double balance = scanner.nextDouble(); // Exemplo: 1230,55
		
		System.out.println("Olá " + clientName + ", obrigado por criar uma conta em nosso banco, sua agência é " + agency + ", conta " + accountNumber + " e seu saldo " + balance + " já está disponível para saque.");
	}
}
