package edu.meninocoiso.oop.stream.practice.challenges;

import edu.meninocoiso.oop.stream.practice.Main;

import java.util.List;

public class Challenge18 {
	private final List<Integer> numbers;
	
	public Challenge18(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void areAllEqual() {
		System.out.print("Todos os números da lista são iguais? ");
		
		System.out.println(numbers.stream()
				.distinct().findAny().isEmpty());
	}
}
