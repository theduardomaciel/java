package edu.meninocoiso.oop.projects.project3;

import edu.meninocoiso.oop.projects.project3.domain.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	private static void separator() {
		System.out.println("------------------------------------------------");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Platform platform = new Platform();
		
		Bootcamp javaBootcamp = getJavaBootcamp();
		Bootcamp webBootcamp = getWebBootcamp();
		
		platform.addBootcamp(javaBootcamp);
		platform.addBootcamp(webBootcamp);
		
		Developer devJoao = new Developer("João", "1231231");
		platform.addDeveloper(devJoao); // Uma conta é criada para João na plataforma
		devJoao.joinBootcamp(javaBootcamp); // João se inscreve no Bootcamp da plataforma
		
		System.out.println("XP total de João: " + devJoao.calculateTotalXp());
		
		Developer devMaria = new Developer("Maria", "1231231");
		// platform.addDeveloper(devMaria); // Deve retornar um erro, visto que o ID é o mesmo de João
		// devMaria.joinBootcamp(javaBootcamp); // Deve retornar um erro, visto que Maria não está cadastrada na plataforma
		
		Developer devEduardo = new Developer("Eduardo", "123456");
		platform.addDeveloper(devEduardo);
		devEduardo.joinBootcamp(webBootcamp);
		// devEduardo.joinBootcamp(javaBootcamp); // Deve retornar um erro, visto que Eduardo já está inscrito no Bootcamp
		
		System.out.println("XP total de Eduardo: " + devEduardo.calculateTotalXp());
		System.out.println();
		
		System.out.println("Conteúdos inscritos de João: ");
		devJoao.getContentSubscribed().forEach(System.out::println);
		separator();
		
		System.out.println("Conteúdos inscritos de Eduardo: ");
		devEduardo.getContentSubscribed().forEach(System.out::println);
		separator();
		
		devEduardo.progress();
		
		System.out.println("XP total de Eduardo: " + devEduardo.calculateTotalXp());
		System.out.println();
		
		devEduardo.progress(); // Será necessário responder ao questionário do Curso de Java
		System.out.println();
		
		System.out.println("Conteúdos inscritos de Eduardo: ");
		devEduardo.getContentSubscribed().forEach(System.out::println);
		
		separator();
		
		System.out.println("Conteúdos concluídos de Eduardo: ");
		devEduardo.getContentConcluded().forEach(System.out::println);
		
		separator();
		
		// devMaria.progress(); // Deve retornar um erro, visto que João não está matriculado em nenhum conteúdo
		
		// João conclui o primeiro conteúdo
		devJoao.progress();
		System.out.println();
		
		System.out.println("XP total de Eduardo: " + devEduardo.calculateTotalXp());
		System.out.println("XP total de João: " + devJoao.calculateTotalXp());
	}
	
	private static Bootcamp getWebBootcamp() {
		Course htmlCourse = new Course(
				"HTML",
				"Curso de HTML",
				10,
				new LinkedHashSet<>(
						Set.of(
								new Question(
										"O que é HTML?",
										Map.of(
												"Linguagem de marcação", true,
												"Linguagem de programação", false,
												"Linguagem de estilização", false,
												"Linguagem de consulta", false
										)
								),
								new Question(
										"Qual a atual versão do HTML?",
										Map.of(
												"4", false,
												"5", true,
												"6", false,
												"7", false
										)
								)
						)
				)
		);
		Course cssCourse = new Course("CSS", "Curso de CSS", 10);
		Course jsCourse = new Course(
				"JavaScript",
				"Curso de JavaScript",
				20,
				new LinkedHashSet<>(
						Set.of(
								new Question(
										"Qual é a saída do código a seguir?\n\nlet x = 10;\nconsole.log(x++);",
										Map.of(
												"10", true,
												"11", false,
												"12", false,
												"13", false
										)
								),
								new Question(
										"O que são variáveis em JavaScript?",
										Map.of(
												"Locais de armazenamento", true,
												"Funções", false,
												"Objetos", false,
												"Classes", false
										)
								),
								new Question(
										"Qual é a saída do código a seguir?\n\nlet x = 10;\nconsole.log(x + 1);",
										Map.of(
												"10", false,
												"11", true,
												"12", false,
												"13", false
										)
								)
						)
				)
		);
		
		Bootcamp bootcamp = new Bootcamp(
				"Web Development",
				"Aprenda desde os primeiros passos com HTML, CSS e JavaScript para se tornar um desenvolvedor web completo."
		);
		
		bootcamp.addContent(htmlCourse);
		bootcamp.addContent(cssCourse);
		bootcamp.addContent(jsCourse);
		return bootcamp;
	}
	
	private static Bootcamp getJavaBootcamp() {
		Course javaCourse = new Course(
				"Java",
				"Curso de Java",
				40,
				new LinkedHashSet<>(
						Set.of(
								new Question(
										"Qual é a saída do código a seguir?\n\npublic class Main {\n\tpublic static void main(String[] args) {\n\t\tint x = 10;\n\t\tSystem.out.println(x++);\n\t}\n}",
										Map.of(
												"10", true,
												"11", false,
												"12", false,
												"13", false
										)
								),
								new Question(
										"O que são classes abstratas?",
										Map.of(
												"Classes que não podem ser instanciadas", true,
												"Classes que não podem ser herdadas", false,
												"Classes que não podem ser modificadas", false,
												"Classes que não podem ser declaradas", false
										)
								),
								// Pergunta com múltiplas respostas corretas
								new Question(
										"Quais das opções a seguir são tipos primitivos em Java?",
										Map.of(
												"int", true,
												"Integer", false,
												"String", false,
												"double", true
										)
								)
						)
				)
		);
		
		Course springCourse = new Course("Spring Boot ", "Curso do framework Spring Boot para Java", 30);
		
		Mentoring testingMentoring = new Mentoring(
				"Testes",
				"Mentoria para aprendizado de testes unitários.",
				LocalDate.of(2024, 5, 12)
		);
		
		/*System.out.println(javaCourse);
		separator();
		System.out.println(springCourse);
		separator();
		System.out.println(testingMentoring);
		separator();*/
		
		Bootcamp bootcamp = new Bootcamp(
				"Backend com Java",
				"Aprenda desde os primeiros passos com Java partindo da sintaxe básica até a implementação de uma API utilizando Spring para se tornar um profissional atrativo no mercado."
		);
		
		bootcamp.addContent(javaCourse);
		bootcamp.addContent(springCourse);
		bootcamp.addContent(testingMentoring);
		return bootcamp;
	}
}
