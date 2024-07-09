package edu.meninocoiso.stream.practice.challenges;

import edu.meninocoiso.stream.practice.Main;

import java.util.List;

public class Challenge14 {
	private final List<Integer> numbers;
	
	public Challenge14(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void findBiggestPrime() {
		System.out.print("Maior número primo na lista: ");
		
		numbers.stream().filter(Main::isPrime).max(Integer::compareTo).ifPresent(System.out::println);
	}
}
