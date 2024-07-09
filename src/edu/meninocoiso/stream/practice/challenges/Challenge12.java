package edu.meninocoiso.stream.practice.challenges;

import java.util.List;

public class Challenge12 {
	private final List<Integer> numbers;
	
	public Challenge12(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void allNumbersProduct() {
		System.out.print("Produto de todos os números: ");
		
		numbers.stream()
				.reduce((num1, num2) -> num1 * num2).ifPresent(System.out::println);
	}
}
