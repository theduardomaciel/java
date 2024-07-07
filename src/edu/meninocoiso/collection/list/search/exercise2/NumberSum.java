package edu.meninocoiso.collection.list.search.exercise2;

import java.util.ArrayList;
import java.util.List;

public class NumberSum {
	private List<Integer> numbers;

	public NumberSum() {
		this.numbers = new ArrayList<>();
	}

	public void addNumber(int number) {
		numbers.add(number);
	}

	public int calculateSum() {
		if (numbers.isEmpty()) {
			System.out.println("Nenhum número presente na lista.");
			return 0;
		} else {
			int sum = 0;

			for (int number : numbers) {
				sum += number;
			}

			return sum;
		}
	}

	public Integer findBiggestNumber() {
		if (numbers.isEmpty()) {
			System.out.println("Não é possível encontrar o maior número pois a lista está vazia.");
			return null;
		}

		int currentBiggest = Integer.MIN_VALUE;

		for (Integer number : numbers) {
			if (number > currentBiggest) {
				currentBiggest = number;
			}
		}

		return currentBiggest;
	}

	public Integer findSmallestNumber() {
		if (numbers.isEmpty()) {
			System.out.println("Não é possível encontrar o menor número pois a lista está vazia.");
		}

		int currentSmallest = Integer.MAX_VALUE;

		for (Integer number : numbers) {
			if (number < currentSmallest) {
				currentSmallest = number;
			}
		}

		return currentSmallest;
	}

	public void showNumbers() {
		if (numbers.isEmpty()) {
			System.out.println("Nenhum número presente na lista.");
		} else {
			System.out.println("Números presentes na lista:");
			for (Integer number : numbers) {
				System.out.println(number);
			}
		}
	}

	public static void main(String[] args) {
		NumberSum numberSum = new NumberSum();

		numberSum.addNumber(10);
		numberSum.addNumber(20);
		numberSum.addNumber(30);
		numberSum.addNumber(40);
		numberSum.addNumber(50);

		numberSum.showNumbers();
		System.out.println("Soma dos números: " + numberSum.calculateSum());
		System.out.println("Maior número: " + numberSum.findBiggestNumber());
		System.out.println("Menor número: " + numberSum.findSmallestNumber());
	}
}
