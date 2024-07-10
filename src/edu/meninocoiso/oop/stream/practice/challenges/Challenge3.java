package edu.meninocoiso.oop.stream.practice.challenges;

import java.util.List;

public class Challenge3 {
	private final List<Integer> numbers;
	
	public Challenge3(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void verifyAllPositive() {
		System.out.print("Todos os números da lista são positivos? ");
		System.out.println(numbers.stream().allMatch(number -> number > 0));
	}
}
