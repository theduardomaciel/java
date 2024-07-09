package edu.meninocoiso.stream.practice.challenges;

import java.util.ArrayList;
import java.util.List;

public class Challenge2 {
	private final List<Integer> numbers;
	
	public Challenge2(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void evenNumbersSum() {
		List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).toList();
		
		if (evenNumbers.isEmpty()) {
			System.out.println("Não há números pares na lista.");
			return;
		}
		
		System.out.print("Soma dos números pares: " + "(" + evenNumbers.getFirst());
		
		evenNumbers.stream().skip(1).forEach(number -> System.out.print(" + " + number));
		System.out.print(") = ");
		
		System.out.println(evenNumbers.stream().reduce(0, Integer::sum));
	}
}
