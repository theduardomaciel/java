package edu.meninocoiso.stream.practice.challenges;

import java.util.List;

public class Challenge5 {
	private final List<Integer> numbers;
	
	public Challenge5(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void aboveFiveAverage() {
		System.out.print("Média dos números maiores que 5: ");
		
		List<Integer> aboveFiveNumbers = numbers.stream().filter(number -> number > 5).toList();
		
		System.out.print("(" + aboveFiveNumbers.getFirst());
		
		aboveFiveNumbers.stream().skip(1).forEach(number -> {
			System.out.print(" + " + number);
		});
		
		System.out.print(") / " + aboveFiveNumbers.size() + " = ");
		
		aboveFiveNumbers.stream().reduce(Integer::sum).ifPresent(sum -> {
			System.out.println(sum / aboveFiveNumbers.size());
		});
	}
}
