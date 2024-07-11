package edu.meninocoiso.oop.projects.project2.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private final String name;
	private final List<Client> clients;
	
	public Bank(String name) {
		this.name = name;
		this.clients = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void printClients() {
		System.out.println("Clientes do banco " + name + ":");
		
		for (Client client : clients) {
			System.out.println("| " + client);
		}
		
		System.out.println();
	}
	
	public void addClient(Client client) {
		clients.add(client);
	}
	
	public void removeClient(Client client) {
		boolean success = clients.remove(client);
		
		if (!success) {
			System.out.println("O cliente especificado não foi encontrado.");
		}
	}
}
