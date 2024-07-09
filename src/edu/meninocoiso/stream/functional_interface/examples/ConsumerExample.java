package edu.meninocoiso.stream.functional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	// Criamos uma lista de números inteiros
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
	
	private void method1() {
		// Criamos o 'Consumer' com uma expressão Lambda para imprimir números pares
		Consumer<Integer> printEvenNumber = number -> {
			if (number % 2 == 0) {
				System.out.printf("%d ", number);
			}
		};
		
		// Usamos o Consumer no Stream
		// Obs: O uso do `stream()` pode ser omitido nesse caso
		numbers.forEach(printEvenNumber);
	}
	
	private void method2() {
		// Criamos o 'Consumer' com uma classe anônima para imprimir números pares
		Consumer<Integer> printEvenNumber = new Consumer<Integer>() {
			@Override
			public void accept(Integer number) {
				if (number % 2 == 0) {
					System.out.printf("%d ", number);
				}
			}
		};
		
		// Usamos o Consumer por meio da classe anônima
		for (Integer number : numbers) {
			printEvenNumber.accept(number);
		}
		
		// ou: numbers.forEach(printEvenNumber);
	}
	
	public static void main(String[] args) {
		ConsumerExample example = new ConsumerExample();
		example.method1();
		System.out.println();
		example.method2();
	}
}