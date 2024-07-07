package edu.meninocoiso.collection.set.sort.exercise2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StudentManager {
	Set<Student> students;

	public StudentManager() {
		this.students = new HashSet<>();
	}

	public void addStudent(String name, long registrations, double average) {
		students.add(new Student(name, registrations, average));
	}

	public void removeStudent(long registration) throws RuntimeException {
		if (students.isEmpty()) {
			throw new RuntimeException("Não há estudantes para remover.");
		}

		for (Student student : students) {
			if (student.getRegistration() == registration) {
				students.remove(student);
				System.out.println("Estudante com matrícula " + registration + " removido.");
				return;
			}
		}

		System.out.println("Estudante com matrícula " + registration + " não encontrado.");
	}

	public void showStudentsByName() {
		if (students.isEmpty()) {
			System.out.println("Nenhum estudante presente.");
			return;
		}

		System.out.println("Lista de estudantes ordenada por nome:");
		Set<Student> sortedStudents = new TreeSet<>(students);
		// ou: students.stream().sorted().forEach(System.out::println);

		sortedStudents.forEach(System.out::println);
	}

	public void showStudentsByAverage() {
		if (students.isEmpty()) {
			System.out.println("Nenhum estudante presente.");
			return;
		}

		System.out.println("Lista de estudantes ordenada por média:");
		Set<Student> sortedStudents = new TreeSet<>(new ComparatorByAverage());
		sortedStudents.addAll(students);
		sortedStudents.forEach(System.out::println);
	}

	public static void main(String[] args) {
		StudentManager studentManager = new StudentManager();

		studentManager.addStudent("Alice", 1, 8.5);
		studentManager.addStudent("Bianca", 2, 7.5);
		studentManager.addStudent("Carlos", 3, 9.0);
		studentManager.addStudent("Marcos", 4, 6.5);
		studentManager.addStudent("Eva", 5, 7.0);
		studentManager.addStudent("Andreia", 6, 8.0);
		studentManager.addStudent("Fernando", 7, 9.5);
		studentManager.addStudent("Davi", 8, 6.0);
		studentManager.addStudent("Lucas", 9, 7.5);
		studentManager.addStudent("Tereza", 10, 8.5);

		studentManager.showStudentsByName();
		studentManager.showStudentsByAverage();

		studentManager.removeStudent(3);
		studentManager.removeStudent(2012);
		studentManager.removeStudent(5);
		studentManager.removeStudent(7);

		studentManager.showStudentsByName();
	}
}
