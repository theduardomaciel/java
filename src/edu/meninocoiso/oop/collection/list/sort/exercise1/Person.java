package edu.meninocoiso.oop.collection.list.sort.exercise1;

import java.util.Comparator;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private double height;
	
	public Person(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	@Override
	public int compareTo(Person person) {
		return Integer.compare(this.age, person.age);
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getHeight() {
		return height;
	}
}

class PersonHeightComparator implements Comparator<Person> {
	@Override
	public int compare(Person person1, Person person2) {
		return Double.compare(person1.getHeight(), person2.getHeight());
	}
}
