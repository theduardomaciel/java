package edu.meninocoiso.collection.map.basic;

import java.util.HashMap;
import java.util.Map;

public class ContactsAgenda {
	private Map<String, Integer> agenda;

	public ContactsAgenda() {
		this.agenda = new HashMap<>();
	}

	public void addContact(String name, Integer phoneNumber) {
		agenda.put(name, phoneNumber);
	}

	public void removeContact(String name) {
		if (agenda.isEmpty()) {
			System.out.println("O contato '" + name + "' não existe na agenda.");
		} else {
			Object success = agenda.remove(name);
			if (success == null) {
				System.out.println("O contato '" + name + "' não existe na agenda.");
			} else {
				System.out.println("Contato '" + name + "' removido com sucesso.");
			}
		}
	}

	public void showContacts() {
		for (String name : agenda.keySet()) {
			System.out.println(name + " - " + agenda.get(name));
		}
	}

	public Integer searchByName(String name) {
		if (agenda.isEmpty()) {
			System.out.println("O contato '" + name + "' não existe na agenda.");
			return null;
		} else {
			Integer phoneNumber = agenda.get(name);
			if (phoneNumber == null) {
				System.out.println("O contato '" + name + "' não existe na agenda.");
				return null;
			} else {
				return phoneNumber;
			}
		}
	}

	public static void main(String[] args) {
		ContactsAgenda agenda = new ContactsAgenda();

		agenda.addContact("João", 123456789);
		agenda.addContact("Maria", 987654321);
		agenda.addContact("José", 456789123);

		System.out.println("Contatos:");
		agenda.showContacts();

		agenda.removeContact("Maria");

		System.out.println("Contatos após remoção de 'Maria':");
		agenda.showContacts();

		agenda.removeContact("Maria"); // Deve exibir mensagem de que o contato não existe

		Integer number1 = agenda.searchByName("José");
		if (number1 != null) {
			System.out.println("Telefone de José: " + number1);
		}

		agenda.searchByName("Maria"); // Deve exibir mensagem de que o contato não existe
	}
}
