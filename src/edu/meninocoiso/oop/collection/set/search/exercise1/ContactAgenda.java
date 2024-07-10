package edu.meninocoiso.oop.collection.set.search.exercise1;

import java.util.HashSet;
import java.util.Set;

public class ContactAgenda {
	Set<Contact> contacts;
	
	public ContactAgenda() {
		this.contacts = new HashSet<>();
	}
	
	public void addContact(String name, String phone) {
		contacts.add(new Contact(name, phone));
	}
	
	public void showContacts() {
		System.out.println("Lista de contatos:");
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
	
	public Set<Contact> searchContactByName(String name) {
		Set<Contact> foundContacts = new HashSet<>();
		
		for (Contact contact : contacts) {
			if (contact.getName().contains(name)) {
				foundContacts.add(contact);
			}
		}
		
		if (foundContacts.isEmpty()) {
			System.out.println("Nenhum contato encontrado com o nome '" + name + "'.");
			return null;
		}
		
		return foundContacts;
	}
	
	public void updateContactPhone(String name, String newPhone) {
		for (Contact contact : contacts) {
			if (contact.getName().contains(name)) {
				contact.setPhone(newPhone);
				System.out.println("Telefone do contato '" + name + "' atualizado com sucesso.");
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		ContactAgenda agenda = getContactAgenda();
		
		Set<Contact> foundContacts = agenda.searchContactByName("Braga");
		if (foundContacts != null) {
			System.out.println("Contatos encontrados com o nome 'Braga':");
			for (Contact contact : foundContacts) {
				System.out.println(contact);
			}
		}
		
		foundContacts = agenda.searchContactByName("Felipe");
		if (foundContacts != null) {
			System.out.println("Contatos encontrados com o nome 'Felipe':");
			for (Contact contact : foundContacts) {
				System.out.println(contact);
			}
		}
	}
	
	private static ContactAgenda getContactAgenda() {
		ContactAgenda agenda = new ContactAgenda();
		
		agenda.addContact("Alice Braga", "1234-5678");
		agenda.addContact("Bianca Bragança", "8765-4321");
		agenda.addContact("Carlos Braga", "4321-5678");
		agenda.addContact("Marcos Aurélio", "4321-5678"); // Número repetido
		
		agenda.showContacts();
		
		agenda.addContact("Marcos Felipe", "9876-5432");
		agenda.addContact("Felipe Santos", "5432-8765");
		
		agenda.showContacts();
		
		agenda.updateContactPhone("Carlos Braga", "9999-9999");
		agenda.updateContactPhone("Felipe Santos", "1111-1111");
		return agenda;
	}
}
