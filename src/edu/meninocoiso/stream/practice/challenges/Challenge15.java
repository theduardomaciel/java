package edu.meninocoiso.stream.practice.challenges;

import java.util.List;

public class Challenge15 {
	private final List<Integer> numbers;
	
	public Challenge15(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void hasAtLeastOneNegative() {
		System.out.print("A lista contém pelo menos um número negativo? ");
		
		System.out.println(numbers.stream().anyMatch(number -> number < 0));
		;
	}
}
