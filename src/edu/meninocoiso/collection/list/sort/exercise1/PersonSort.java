package edu.meninocoiso.collection.list.sort.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonSort {
	List<Person> people;

	public PersonSort() {
		this.people = new ArrayList<>();
	}

	public List<Person> getSortedByAge() {
		List<Person> sortedByAge = new ArrayList<>(people);
		Collections.sort(sortedByAge);
		return sortedByAge;
	}

	public List<Person> getSortedByHeight() {
		List<Person> sortedByHeight = new ArrayList<>(people);
		sortedByHeight.sort(new PersonHeightComparator());
		// ou: Collections.sort(sortedByHeight, new PersonHeightComparator());
		return sortedByHeight;
	}

	public static void main(String[] args) {
		PersonSort personSort = new PersonSort();

		personSort.people.add(new Person("Guilherme", 25, 1.70));
		personSort.people.add(new Person("Pedro", 30, 1.80));
		personSort.people.add(new Person("Alan", 20, 1.60));

		System.out.println("Ordenado por idade:");
		for (Person person : personSort.getSortedByAge()) {
			System.out.println(person.getName() + " - " + person.getAge() + " anos");
		}

		System.out.println("\nOrdenado por altura:");
		for (Person person : personSort.getSortedByHeight()) {
			System.out.println(person.getName() + " - " + person.getHeight() + "m");
		}
	}
}
