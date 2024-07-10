package edu.meninocoiso.oop.stream.practice.challenges;

import java.util.List;

public class Challenge6 {
	private final List<Integer> numbers;
	
	public Challenge6(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void anyNumberAboveTen() {
		System.out.print("A lista possui algum número maior que 10? ");
		System.out.println(numbers.stream().anyMatch(number -> number > 10));
	}
}
