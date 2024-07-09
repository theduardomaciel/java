package edu.meninocoiso.stream.practice.challenges;

import java.util.List;

public class Challenge13 {
	private final List<Integer> numbers;
	
	public Challenge13(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void numberInInterval() {
		int intervalStart = 4;
		int intervalEnd = 8;
		
		System.out.print("Números no intervalo [" + intervalStart + ", " + intervalEnd + "]: ");
		
		numbers.stream().filter(number -> number >= 4 && number <= intervalEnd).forEach(number -> System.out.print(number + " "));
		System.out.println();
	}
}
