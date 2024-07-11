package edu.meninocoiso.oop.projects.project3;

import edu.meninocoiso.oop.projects.project3.domain.Bootcamp;
import edu.meninocoiso.oop.projects.project3.domain.Course;
import edu.meninocoiso.oop.projects.project3.domain.Developer;
import edu.meninocoiso.oop.projects.project3.domain.Mentoring;

import java.time.LocalDate;

public class Main {
	private static void separator() {
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Course javaCourse = new Course("Java", "Curso de Java", 40);
		
		Course pythonCourse = new Course("Python", "Curso de Python", 30);
		
		Mentoring javaScriptMentoring = new Mentoring(
				"JavaScript",
				"Mentoria de JavaScript",
				LocalDate.of(2024, 5, 12)
		);
		
		System.out.println(javaCourse);
		separator();
		System.out.println(pythonCourse);
		separator();
		System.out.println(javaScriptMentoring);
		separator();
		
		Bootcamp bootcamp = new Bootcamp(
				"Backend com Java",
				"Aprenda desde os primeiros passos com Java partindo da sintaxe básica até a implementação de uma API utilizando Spring para se tornar um profissional atrativo no mercado."
		);
		
		bootcamp.addContent(javaCourse);
		bootcamp.addContent(pythonCourse);
		bootcamp.addContent(javaScriptMentoring);
		
		Developer devEduardo = new Developer("Eduardo", "123456");
		devEduardo.joinBootcamp(bootcamp);
		
		System.out.println("XP total de Eduardo: " + devEduardo.calculateTotalXp());
		System.out.println();
		
		System.out.println("Conteúdos inscritos de Eduardo: ");
		devEduardo.getContentSubscribed().forEach(System.out::println);
		separator();
		
		devEduardo.progress();
		
		System.out.println("XP total de Eduardo: " + devEduardo.calculateTotalXp());
		System.out.println();
		
		devEduardo.progress();
		System.out.println();
		
		System.out.println("Conteúdos inscritos de Eduardo: ");
		devEduardo.getContentSubscribed().forEach(System.out::println);
		
		separator();
		
		System.out.println("Conteúdos concluídos de Eduardo: ");
		devEduardo.getContentConcluded().forEach(System.out::println);
		
		separator();
		
		System.out.println("XP total de Eduardo: " + devEduardo.calculateTotalXp());
	}
}
