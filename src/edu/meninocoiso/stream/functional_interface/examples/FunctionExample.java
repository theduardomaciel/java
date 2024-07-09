package edu.meninocoiso.stream.functional_interface.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {
	// Criamos uma lista de números inteiros
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
	
	private void method1() {
		// Criamos a 'Function' com uma expressão Lambda para dobrar todos os números
		Function<Integer, Integer> doubleNums = number -> number * 2;
		
		// Usamos a função para dobrar todos os números no Stream e armazená-los em outra lista
		List<Integer> doubledNumbers = numbers.stream()
				.map(doubleNums)
				.toList();
		// ou: collect(Collectors.toList());
		
		// Imprimimos a lista de números dobrados
		doubledNumbers.forEach(System.out::println);
	}
	
	private void method2() {
		// Criamos a 'Function' com uma classe anônima para dobrar todos os números
		Function<Integer, Integer> doubleNums = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer number) {
				return number * 2;
			}
		};
		
		// Usamos a função para dobrar todos os números e armazená-los em outra lista
		List<Integer> doubledNumbers = new ArrayList<>();
		for (Integer number : numbers) {
			doubledNumbers.add(doubleNums.apply(number));
		}
		
		// Imprimimos a lista de números dobrados
		for (Integer doubledNumber : doubledNumbers) {
			System.out.println(doubledNumber);
		}
	}
	
	public static void main(String[] args) {
		FunctionExample example = new FunctionExample();
		example.method1();
		System.out.println();
		example.method2();
	}
}
