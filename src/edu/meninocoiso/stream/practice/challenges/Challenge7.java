package edu.meninocoiso.stream.practice.challenges;

import java.util.Comparator;
import java.util.List;

public class Challenge7 {
	private final List<Integer> numbers;
	
	public Challenge7(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void secondBiggestNumber() {
		System.out.print("Segundo maior número da lista: ");
		System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).toArray()[1]);
	}
}
