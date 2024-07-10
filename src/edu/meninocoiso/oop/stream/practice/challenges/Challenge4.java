package edu.meninocoiso.oop.stream.practice.challenges;

import java.util.List;

public class Challenge4 {
	private final List<Integer> numbers;
	
	public Challenge4(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void removeOddNumbers() {
		System.out.print("Números após remoção dos ímpares: ");
		numbers.stream().filter(number -> number % 2 == 0).forEach(number -> System.out.print(number + " "));
		System.out.println();
	}
}
