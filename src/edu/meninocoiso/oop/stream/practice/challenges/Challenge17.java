package edu.meninocoiso.oop.stream.practice.challenges;

import edu.meninocoiso.oop.stream.practice.Main;

import java.util.List;

public class Challenge17 {
	private final List<Integer> numbers;
	
	public Challenge17(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void filterPrimeNumbers() {
		System.out.println("Números primos na lista: ");
		
		numbers.stream().filter(Main::isPrime).forEach(number -> System.out.print(number + " "));
		System.out.println();
	}
}
