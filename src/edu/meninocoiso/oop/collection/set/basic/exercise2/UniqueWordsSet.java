package edu.meninocoiso.oop.collection.set.basic.exercise2;

import java.util.HashSet;
import java.util.Set;

public class UniqueWordsSet {
	Set<String> uniqueWords;
	
	public UniqueWordsSet() {
		this.uniqueWords = new HashSet<>();
	}
	
	public void addWord(String word) {
		boolean success = uniqueWords.add(word);
		
		if (!success) {
			System.out.println("A palavra " + word + " já foi adicionada.");
		}
	}
	
	public void removeWord(String word) {
		boolean success = uniqueWords.remove(word);
		
		if (!success) {
			System.out.println("Não foi possível remover a palavra '" + word + "', pois ela não foi encontrada.");
		}
	}
	
	public void verifyWord(String word) {
		boolean success = uniqueWords.contains(word);
		
		if (success) {
			System.out.println("A palavra " + word + " foi encontrada no conjunto.");
		} else {
			System.out.println("A palavra " + word + " não foi encontrada no conjunto.");
		}
	}
	
	public void showUniqueWords() {
		System.out.println("Lista de palavras:");
		for (String word : uniqueWords) {
			System.out.println(word);
		}
	}
	
	public static void main(String[] args) {
		UniqueWordsSet uniqueWordsSet = new UniqueWordsSet();
		
		uniqueWordsSet.addWord("casa");
		uniqueWordsSet.addWord("carro");
		uniqueWordsSet.addWord("casa"); // Palavra repetida
		uniqueWordsSet.addWord("moto");
		uniqueWordsSet.addWord("bicicleta");
		uniqueWordsSet.addWord("carro"); // Palavra repetida
		uniqueWordsSet.addWord("avião");
		uniqueWordsSet.addWord("barco");
		uniqueWordsSet.addWord("moto"); // Palavra repetida
		uniqueWordsSet.addWord("trem");
		
		uniqueWordsSet.showUniqueWords();
		
		uniqueWordsSet.removeWord("casa");
		uniqueWordsSet.removeWord("moto");
		uniqueWordsSet.removeWord("caminhão");
		
		uniqueWordsSet.showUniqueWords();
		
		uniqueWordsSet.verifyWord("carro");
		uniqueWordsSet.verifyWord("bicicleta");
		uniqueWordsSet.verifyWord("caminhão");
	}
}
