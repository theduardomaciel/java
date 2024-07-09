package edu.meninocoiso.stream.practice.challenges;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Challenge8 {
	private final List<Integer> numbers;
	
	public Challenge8(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void sumAllNumbersDigits() {
		System.out.print("Soma dos dígitos de todos os números da lista: ");
		
		Supplier<Stream<Integer>> streamSupplier = numbers::stream;
		// ou: () -> numbers.stream();
		
		numbers.forEach(number -> {
			int sum = 0;
			int initialNumber = number;
			
			while (number > 0) {
				sum = sum + number % 10;
				number /= 10;
			}
			
			// Exibimos tanto o número quanto a soma dos seus dígitos
			System.out.print(sum + " (");
			
			// Exibimos os dígitos separados por vírgula
			for (int i = 0; i < String.valueOf(initialNumber).length(); i++) {
				System.out.print(Integer.toString(initialNumber).charAt(i) + " + ");
			}
			
			// Removemos a última vírgula e exibimos o parêntese de fechamento
			System.out.print("\b\b\b), ");
		});
		
		// Método mais enxuto, utilizando mapToInt e forEach
		/*numbers.stream().mapToInt(number -> {
			int sum = 0;
			while (number > 0) {
				sum = sum + number % 10;
				number /= 10;
			}
			return sum;
		}).forEach(number -> System.out.print(number + " + "));*/
		
		System.out.println("\b\b = " + streamSupplier.get().mapToInt(number -> {
			int sum = 0;
			while (number > 0) {
				sum = sum + number % 10;
				number /= 10;
			}
			return sum;
		}).sum());
	}
}
