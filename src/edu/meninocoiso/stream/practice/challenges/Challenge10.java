package edu.meninocoiso.stream.practice.challenges;

import java.util.List;

public class Challenge10 {
	private final List<Integer> numbers;
	
	public Challenge10(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void threeOrFiveGrouped() {
		System.out.print("Ímpares múltiplos de 3 ou 5 agrupados: ");
		numbers.stream()
				.filter(number -> number % 2 != 0)
				.filter(number -> number % 3 == 0 || number % 5 == 0)
				.forEach(number -> System.out.print(number + " "));
		System.out.println();
	}
}
