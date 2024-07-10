package edu.meninocoiso.oop.stream.practice.challenges;

import java.util.List;

public class Challenge19 {
	private final List<Integer> numbers;
	
	public Challenge19(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void divisibleByThreeAndFiveSum() {
		System.out.print("Soma dos números divisíveis por 3 e 5: ");
		
		numbers.stream().filter(number -> number % 3 == 0 && number % 5 == 0).reduce(Integer::sum).ifPresent(number -> System.out.print(number + " "));
		System.out.println();
	}
}
