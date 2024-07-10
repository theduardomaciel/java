package edu.meninocoiso.oop.projects.project2.data;

import edu.meninocoiso.oop.projects.project2.Account;

import java.util.Optional;

public interface IAccount {
	/**
	 * @param amount Valor a ser sacado
	 * @param other  Conta para onde o dinheiro será transferido (caso aplicável)
	 * @return true se o saque foi bem sucedido, false caso contrário
	 */
	boolean withdraw(double amount, Account other);
	
	/**
	 * @param amount Valor a ser sacado
	 * @return true se o saque foi bem sucedido, false caso contrário
	 */
	default boolean withdraw(double amount) {
		return withdraw(amount, null);
	}
	
	/**
	 * @param amount Valor a ser sacado
	 * @param other  Conta para onde o dinheiro será transferido (caso aplicável)
	 */
	void deposit(double amount, Account other);
	
	/**
	 * @param amount Valor a ser depositado
	 */
	default void deposit(double amount) {
		deposit(amount, null);
	}
	
	/**
	 * @param amount Valor a ser transferido
	 * @param other  Conta para onde o dinheiro será transferido
	 */
	void transfer(double amount, Account other);
	
	void printExtract();
}
