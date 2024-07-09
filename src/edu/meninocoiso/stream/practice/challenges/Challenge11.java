package edu.meninocoiso.stream.practice.challenges;

import java.util.List;

public class Challenge11 {
	private final List<Integer> numbers;
	
	public Challenge11(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void sumOfSquares() {
		System.out.print("Soma dos quadrados de todos os números: ");
		
		numbers.stream()
				.map(number -> number * number)
				.forEach(number -> System.out.print(number + " + "));
		
		System.out.print("\b\b= ");
		
		numbers.stream()
				.map(number -> number * number)
				.reduce(Integer::sum).ifPresent(System.out::println);
	}
}
