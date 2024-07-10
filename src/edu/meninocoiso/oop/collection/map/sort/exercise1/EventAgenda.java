package edu.meninocoiso.oop.collection.map.sort.exercise1;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class EventAgenda {
	Map<LocalDate, Event> events;
	
	public EventAgenda() {
		this.events = new HashMap<>();
	}
	
	private boolean isEmpty() {
		if (events.isEmpty()) {
			System.out.println("Não há eventos agendados.");
			return true;
		} else {
			return false;
		}
	}
	
	public void addEvent(LocalDate date, String name, String attraction) {
		events.put(date, new Event(name, attraction));
	}
	
	public void showAgenda() {
		Map<LocalDate, Event> sortedEvents = new TreeMap<>(events);
		
		Event currentEvent = null;
		
		System.out.println("Eventos agendados:");
		for (Map.Entry<LocalDate, Event> entry : sortedEvents.entrySet()) {
			currentEvent = entry.getValue();
			System.out.println("Evento '" + currentEvent.getName() + "' com atração '" + currentEvent.getAttraction() + " - " + entry.getKey());
		}
	}
	
	public Map.Entry<LocalDate, Event> getNextEvent() {
		if (isEmpty()) return null;
		
		LocalDate todayDate = LocalDate.now();
		
		LocalDate currentEventDate = null;
		
		Map<LocalDate, Event> sortedEvents = new TreeMap<>(events);
		for (Map.Entry<LocalDate, Event> entry : sortedEvents.entrySet()) {
			currentEventDate = entry.getKey();
			if (currentEventDate.equals(todayDate) || currentEventDate.isAfter(todayDate)) {
				return new AbstractMap.SimpleEntry<>(entry);
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		EventAgenda agenda = new EventAgenda();
		
		agenda.addEvent(LocalDate.of(2021, Month.AUGUST, 5), "Evento 1", "Atração 1");
		agenda.addEvent(LocalDate.of(2021, 10, 9), "Evento 2", "Atração 2");
		agenda.addEvent(LocalDate.of(2024, 8, 25), "Evento 3", "Atração 3");
		agenda.addEvent(LocalDate.of(2024, 9, 18), "Evento 4", "Atração 4");
		
		agenda.showAgenda();
		
		Map.Entry<LocalDate, Event> nextEvent = agenda.getNextEvent();
		if (nextEvent != null) {
			System.out.println("Próximo evento: " + nextEvent.getValue().getName() + " - " + nextEvent.getKey());
		} else {
			System.out.println("Não há eventos futuros.");
		}
	}
}
