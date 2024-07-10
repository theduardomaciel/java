package edu.meninocoiso.oop.stream.functional_interface.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierExample {
	private void method1() {
		// Criamos o 'Supplier' com uma expressão Lambda para fornecer uma saudação personalizada
		Supplier<String> greeting = () -> "Olá, seja bem-vindo(a)!";
		
		// Usamos o Supplier para obter uma lista com 5 saudações
		List<String> greetingsList = Stream.generate(greeting)
				.limit(5)
				.toList();
		// ou: collect(Collectors.toList());
		
		// Imprimimos as saudações geradas
		greetingsList.forEach(System.out::println);
		// ou: greetingsList.forEach(greeting -> System.out.println(greeting));
	}
	
	private void method2() {
		// Usamos o Supplier com uma classe anônima para fornecer uma saudação personalizada
		Supplier<String> greeting = new Supplier<String>() {
			@Override
			public String get() {
				return "Olá, seja bem-vindo(a)!";
			}
		};
		
		// Usamos o Supplier para obter uma lista com 5 saudações
		List<String> greetingsList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			greetingsList.add(greeting.get());
		}
		
		// Imprimimos as saudações geradas
		for (String generatedGreeting : greetingsList) {
			System.out.println(generatedGreeting);
		}
	}
	
	public static void main(String[] args) {
		SupplierExample example = new SupplierExample();
		example.method1();
		System.out.println();
		example.method2();
	}
}
