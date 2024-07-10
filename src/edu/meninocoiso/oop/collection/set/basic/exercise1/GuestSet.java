package edu.meninocoiso.oop.collection.set.basic.exercise1;

import java.util.HashSet;
import java.util.Set;

public class GuestSet {
	Set<Guest> guests;
	
	public GuestSet() {
		this.guests = new HashSet<>();
	}
	
	public void addGuest(String name, int inviteCode) {
		guests.add(new Guest(name, inviteCode));
	}
	
	public void removeGuestByInviteCode(int inviteCode) {
		for (Guest guest : guests) {
			if (guest.getInviteCode() == inviteCode) {
				guests.remove(guest);
				return;
			}
		}
	}
	
	public void countGuests() {
		System.out.println("Número de convidados: " + guests.size());
	}
	
	public void showGuests() {
		System.out.println("Lista de convidados:");
		for (Guest guest : guests) {
			System.out.println(guest);
		}
	}
	
	public static void main(String[] args) {
		GuestSet guestSet = new GuestSet();
		
		guestSet.addGuest("Alice", 1);
		guestSet.addGuest("Bianca", 2);
		guestSet.addGuest("Carlos", 3);
		
		guestSet.showGuests();
		guestSet.countGuests();
		
		guestSet.addGuest("Marcos", 4);
		guestSet.addGuest("Eva", 5);
		guestSet.addGuest("Andreia", 1); // Código de convite repetido
		guestSet.addGuest("Fernando", 2); // Código de convite repetido
		guestSet.addGuest("Davi", 8);
		guestSet.addGuest("Lucas", 4); // Código de convite repetido
		guestSet.addGuest("Tereza", 12);
		
		guestSet.showGuests();
		guestSet.countGuests();
		
		guestSet.removeGuestByInviteCode(3);
		guestSet.removeGuestByInviteCode(5);
		
		guestSet.showGuests();
		guestSet.countGuests();
	}
}
