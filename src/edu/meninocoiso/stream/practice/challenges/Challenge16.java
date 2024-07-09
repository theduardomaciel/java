package edu.meninocoiso.stream.practice.challenges;

import java.util.List;

public class Challenge16 {
	private final List<Integer> numbers;
	
	public Challenge16(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void aggregateOddsAndEvens() {
		System.out.println("Na lista temos: ");
		
		numbers.stream().filter(number -> number % 2 == 0).toList().forEach(number -> System.out.print(number + " "));
		System.out.println("como números pares");
		
		System.out.println("e");
		
		numbers.stream().filter(number -> number % 2 != 0).toList().forEach(number -> System.out.print(number + " "));
		System.out.println("como números ímpares");
	}
}
