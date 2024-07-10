package edu.meninocoiso.oop.collection.list.sort.exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNumbers {
	List<Integer> numbers;
	
	public SortNumbers() {
		this.numbers = new ArrayList<>();
	}
	
	public void addNumber(int number) {
		this.numbers.add(number);
	}
	
	public void sortAscending() {
		Collections.sort(this.numbers);
		// ou, utilizando o método sort da própria lista:
		// this.numbers.sort(null);
	}
	
	public void sortDescending() {
		this.numbers.sort(Collections.reverseOrder());
		// ou: Collections.sort(this.numbers, Collections.reverseOrder());
	}
	
	public static void main(String[] args) {
		SortNumbers sortNumbers = new SortNumbers();
		sortNumbers.addNumber(10);
		sortNumbers.addNumber(5);
		sortNumbers.addNumber(7);
		sortNumbers.addNumber(3);
		sortNumbers.addNumber(1);
		sortNumbers.addNumber(8);
		sortNumbers.addNumber(2);
		sortNumbers.addNumber(4);
		sortNumbers.addNumber(6);
		sortNumbers.addNumber(9);
		
		System.out.println("Lista de números:");
		System.out.println(sortNumbers.numbers);
		
		sortNumbers.sortAscending();
		System.out.println("Lista de números ordenada de forma crescente:");
		System.out.println(sortNumbers.numbers);
		
		sortNumbers.sortDescending();
		System.out.println("Lista de números ordenada de forma decrescente:");
		System.out.println(sortNumbers.numbers);
	}
}
