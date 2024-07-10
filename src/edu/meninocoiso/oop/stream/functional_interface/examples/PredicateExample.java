package edu.meninocoiso.oop.stream.functional_interface.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
	// Criamos uma lista de strings
	List<String> languages = Arrays.asList("JavaScript", "Java", "Python", "C#", "C++", "Ruby", "Go", "Kotlin", "Swift", "Rust", "TypeScript", "PHP", "Haskell", "Elixir");
	
	private void method1() {
		// Usamos o Predicate com expressão Lambda para filtrar linguagens compostas de letras maiúsculas
		Predicate<String> isUpperCase = language -> language.equals(language.toUpperCase());
		
		// Usamos o predicado no Stream para filtrar e armazenamos o resultado do filtro em outra lista
		List<String> evenNumbers = languages.stream()
				.filter(isUpperCase)
				.toList();
		// ou: .collect(Collectors.toList());
		
		// Imprimimos a lista de linguagens compostas de letras maiúsculas
		evenNumbers.forEach(System.out::println);
	}
	
	private void method2() {
		// Usamos o Predicate com uma classe anônima para filtrar números pares
		Predicate<String> isUpperCase = new Predicate<String>() {
			@Override
			public boolean test(String language) {
				return language.equals(language.toUpperCase());
			}
		};
		
		// Usamos o predicado para filtrar e armazenamos o resultado do filtro em outra lista
		List<String> upperCaseLanguages = new ArrayList<>();
		for (String number : languages) {
			if (isUpperCase.test(number)) {
				upperCaseLanguages.add(number);
			}
		}
		
		// Imprimimos a lista de linguagens compostas de letras maiúsculas
		for (String language : upperCaseLanguages) {
			System.out.println(language);
		}
	}
	
	public static void main(String[] args) {
		PredicateExample example = new PredicateExample();
		example.method1();
		System.out.println();
		example.method2();
	}
}
