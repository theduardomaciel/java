package edu.meninocoiso.oop.projects.project3.domain;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Course extends Content {
	private final int workload;
	private Questionary questionary;
	
	public Course(String title, String description, int workload, LinkedHashSet<Question> questions) {
		super(title, description);
		this.workload = workload;
		this.questionary = new Questionary(questions);
	}
	
	public Course(String title, String description, int workload) {
		super(title, description);
		this.workload = workload;
	}
	
	@Override
	public double calculateXp() {
		return DEFAULT_XP * workload;
	}
	
	private int getWorkload() {
		return workload;
	}
	
	public boolean runTest() {
		// Para progredir, caso o conteúdo seja um Curso, é necessário responder a 60% das perguntas do questionário corretamente.
		// Para isso, utilizamos o Terminal para simular a interação do usuário com o sistema
		
		if (questionary == null) {
			return true;
		} else {
			System.out.println("Questionário de conclusão do Curso '" + getTitle() + "':");
			return questionary.runTest();
		}
	}
	
	@Override
	public String toString() {
		return "Curso:\n".concat(super.toString()).concat("\n| Carga horária: " + getWorkload() + " horas");
	}
}

class Questionary {
	private final LinkedHashSet<Question> questionary;
	private final int minPercentage;
	
	// Obs.: As perguntas precisam ser obrigatoriamente armazenadas em um LinkedHashSet para garantir a ordem de inserção
	
	public Questionary(LinkedHashSet<Question> questions, int minPercentage) {
		this.questionary = questions;
		this.minPercentage = minPercentage;
	}
	
	public Questionary(LinkedHashSet<Question> questions) {
		this(questions, 60);
	}
	
	private boolean isAnswerValid(String answer, Question question) {
		if (question.getType() == QuestionType.TRUE_OR_FALSE) {
			// Precisamos garantir que:
			// 1. A resposta tenha o mesmo tamanho que o número de opções
			// 2. Todos os caracteres sejam 'V' ou 'F'
			return answer.length() == question.getOptions().size() && answer.chars().allMatch(c -> c == 'V' || c == 'F');
		} else {
			// Precisamos garantir que:
			// 1. A resposta tenha apenas um caractere
			// 2. O caractere esteja entre 'A' e 'A' + número de opções - 1
			return answer.length() == 1 && answer.charAt(0) >= 'A' && answer.charAt(0) <= 'A' + question.getOptions().size() - 1;
		}
	}
	
	private String getCorrectAnswer(Question question) {
		if (question.getType() == QuestionType.TRUE_OR_FALSE) {
			// Para questões do tipo Verdadeiro x Falso, a resposta correta é a sequência de letras correspondentes às respostas corretas
			// Assim, verificamos se a resposta do usuário é igual à sequência de letras correspondentes às respostas corretas
			// Explicação detalhada:
			// 1. Obtemos os valores (boolean) de cada opção
			// 2. Transformamos cada valor booleano em um caractere (true = 'V', false = 'F')
			// 3. Concatenamos todos os caracteres em uma única String
			// Exemplo: Se a primeira e a terceira opções forem corretas, a sequência de letras será "V-F-V-F"
			
			return question.getOptions().values().stream()
					.map(aBoolean -> aBoolean ? 'V' : 'F')
					.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
					.toString();
		} else {
			// Para questões do tipo Múltipla Escolha, a resposta correta é a letra correspondente à resposta correta
			// Assim, verificamos se a resposta do usuário é igual à letra correspondente à resposta correta
			// Explicação detalhada:
			// 1. Obtemos as opções (Map<String, Boolean>) da questão
			// 2. Filtramos as opções corretas (value = true)
			// 3. Obtemos a primeira opção correta (visto que só há uma opção correta)
			// 4. Obtemos a letra correspondente à opção correta
			// Exemplo: Se a opção correta for a terceira, a letra correspondente será 'C'
			
			String correctAnswer = null;
			int index = 0;
			for (Map.Entry<String, Boolean> option : question.getOptions().entrySet()) {
				if (option.getValue()) {
					correctAnswer = String.valueOf((char) ('A' + index));
					break;
				}
				index++;
			}
			
			return correctAnswer;
			
			// Alternativamente, poderíamos utilizar alguns outros métodos para obter a letra correspondente à opção correta
			// Portanto, seguem alguns exemplos:
			
			// 1. Utilizando um 'for' tradicional com 'forEachRemaining'
			// AtomicReference<String> correctAnswer = new AtomicReference<>("");
			// AtomicInteger index = new AtomicInteger();
			// question.getOptions().entrySet().iterator().forEachRemaining(option -> {
			//     if (option.getValue()) {
			//         correctAnswer = String.valueOf((char) ('A' + index.get());
			//     }
			//     index.getAndIncrement();
			// });
			
			// 2. Utilizando uma segunda stream para obter a letra correspondente à opção correta
			// AtomicInteger index = new AtomicInteger();
			// return question.getOptions().entrySet().stream()
			//      .filter(Map.Entry::getValue)
			//  	.map(entry -> String.valueOf((char) ('A' + question.getOptions().keySet().stream()
			//  			.toList()
			//  			.indexOf(entry.getKey())))
			//  	)
			//  	.findFirst()
			//  	.orElse("");
			//	}
			
			// 3. Caso saibamos a resposta do usuário (answer), podemos utilizar um método mais simples
			//  question.getOptions().keySet().stream()
			//		.skip(answer.charAt(0) - 'A')
			//		.findFirst()
			//		.map(question.getOptions()::get)
			//		.orElse(false);
			// TODO: testar simplificação da IA: String.valueOf((char) ('A' + question.getOptions().keySet().stream().toList().indexOf(userAnswer)));
		}
	}
	
	private void printOptions(Question question) {
		int currentOption = 0;
		
		if (question.getType() == QuestionType.TRUE_OR_FALSE) {
			// Exibimos cada afirmativa com seu número correspondente
			for (String option : question.getOptions().keySet()) {
				System.out.println(++currentOption + ". " + option);
			}
		} else {
			// Exibimos cada opção com sua letra correspondente
			for (Map.Entry<String, Boolean> option : question.getOptions().entrySet()) {
				System.out.println((char) ('A' + currentOption) + ") " + option.getKey());
				// Iniciamos com o caractere ASCII 'A' e incrementamos a cada iteração (A + 1 = B, B + 1 = C, ...)
				// TODO: Caso haja mais de 26 opções, é necessário tratar esse caso
				currentOption++;
			}
		}
	}
	
	// Questões com apenas uma alternativa correta são consideradas do tipo Múltipla Escolha
	// Exemplo: A) 10 B) 11 C) 12 D) 13
	// Nesse caso, o usuário deve informar a letra correspondente à resposta correta
	// Exemplo: A
	
	// Questões com mais de uma alternativa correta são consideradas do tipo Verdadeiro x Falso
	// Exemplo: 1. Primeira afirmativa 2. Segunda afirmativa
	// Nesses casos, o usuário deve informar a sequência de letras correspondentes (V ou F) às respostas corretas
	// Exemplo: VF
	
	public boolean runTest() {
		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
		
		int currentQuestion = 0;
		int correctAnswers = 0;
		String answer;
		
		for (Question question : questionary) {
			System.out.println(++currentQuestion + ") " + question.getQuestion());
			
			if (question.getType() == QuestionType.TRUE_OR_FALSE) {
				// Exibimos cada afirmativa com seu número correspondente
				printOptions(question);
				
				System.out.print("Informe a sequência de letras correspondentes às respostas corretas (V ou F), sem espaços: ");
				
				answer = scanner.nextLine().toUpperCase();
				
				while (!isAnswerValid(answer, question)) {
					System.out.print("Opção inválida. Informe a sequência de letras correspondentes às respostas corretas (V ou F), sem espaços: ");
					answer = scanner.nextLine().toUpperCase();
				}
			} else {
				// Exibimos cada opção com sua letra correspondente
				printOptions(question);
				
				System.out.print("Informe a letra correspondente à resposta correta: ");
				
				answer = scanner.nextLine().toUpperCase();
				
				while (!isAnswerValid(answer, question)) {
					System.out.print("Opção inválida. Informe a letra correspondente à resposta correta: ");
					answer = scanner.nextLine().toUpperCase();
				}
			}
			
			System.out.println("Você escolheu a opção: " + answer.toUpperCase());
			
			if (getCorrectAnswer(question).equals(answer)) {
				System.out.println("Resposta correta!");
				correctAnswers++;
			} else {
				System.out.println("Resposta incorreta! A resposta correta era: " + getCorrectAnswer(question));
			}
			
			System.out.println();
		}
		
		System.out.println("Respostas corretas: " + correctAnswers + "/" + questionary.size());
		
		return correctAnswers >= questionary.size() * (minPercentage / 100);
	}
}