package edu.meninocoiso.oop.stream.practice.challenges;

import java.util.List;

public class Challenge9 {
	private final List<Integer> numbers;
	
	public Challenge9(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void allNumbersDistinct() {
		System.out.print("Todos os números são distintos? ");
		System.out.println(numbers.stream().distinct().count() == numbers.size());
	}
}
