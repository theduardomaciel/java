package edu.meninocoiso.stream.practice.challenges;

import java.util.List;

public class Challenge1 {
	private final List<Integer> numbers;
	
	public Challenge1(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void ascendingSort() {
		System.out.println("Números em ordem crescente: ");
		System.out.println(numbers.stream().sorted().toList());
	}
}
