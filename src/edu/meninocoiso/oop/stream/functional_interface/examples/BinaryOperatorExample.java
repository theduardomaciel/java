package edu.meninocoiso.oop.stream.functional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
	// Criamos uma lista de números inteiros
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
	
	void method1() {
		// Criamos o 'BinaryOperator' com uma expressão Lambda para somar dois números inteiros
		BinaryOperator<Integer> sum = (num1, num2) -> num1 + num2;
		// ou: BinaryOperator<Integer> sum = Integer::sum;
		
		// Usamos o BinaryOperator para somar todos os números no Stream
		int resultado = numbers.stream()
				.reduce(0, sum);
		
		// Imprimimos o resultado da soma
		System.out.println("A soma dos números é: " + resultado);
	}
	
	void method2() {
		// Criamos o 'BinaryOperator' com uma classe anônima para somar dois números inteiros
		BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer num1, Integer num2) {
				return num1 + num2;
			}
		};
		
		// Usamos o BinaryOperator para somar todos os números no Stream
		int resultado = numbers.stream()
				.reduce(0, sum);
		
		// Imprimimos o resultado da soma
		System.out.println("A soma dos números é: " + resultado);
	}
	
	public static void main(String[] args) {
		BinaryOperatorExample example = new BinaryOperatorExample();
		example.method1();
		System.out.println();
		example.method2();
	}
}
