package edu.meninocoiso.collection.set.sort.exercise2;

import java.util.Comparator;

public class Student implements Comparable<Student> {
	private String name;
	private long registration;
	private double average;

	public Student(String name, long registration, double average) {
		this.name = name;
		this.registration = registration;
		this.average = average;
	}

	@Override
	public int compareTo(Student student) {
		return this.name.compareToIgnoreCase(student.getName());
	}

	public String getName() {
		return name;
	}

	public long getRegistration() {
		return registration;
	}

	public double getAverage() {
		return average;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", registration=" + registration + ", average=" + average + "]";
	}
}

class ComparatorByAverage implements Comparator<Student> {
	@Override
	public int compare(Student student1, Student student2) {
		return Double.compare(student1.getAverage(), student2.getAverage());
	}
}
