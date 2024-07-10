package edu.meninocoiso.oop.collection.map.search.exercise2;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
	Map<String, Integer> words;
	
	public WordCount() {
		this.words = new HashMap<>();
	}
	
	private boolean isEmpty() {
		if (words.isEmpty()) {
			System.out.println("Não há palavras no dicionário.");
			return true;
		} else {
			return false;
		}
	}
	
	public void addWord(String word, int count) {
		words.put(word, count);
	}
	
	public void showWords() {
		System.out.println("Palavras disponíveis no dicionário:");
		for (String word : words.keySet()) {
			System.out.println(word + " -> " + words.get(word));
		}
	}
	
	public void findMostFrequentWord() {
		if (isEmpty()) return;
		
		String mostFrequentWord = null;
		int mostFrequentCount = Integer.MIN_VALUE;
		
		for (String word : words.keySet()) {
			if (words.get(word) > mostFrequentCount) {
				mostFrequentWord = word;
				mostFrequentCount = words.get(word);
			}
		}
		
		System.out.println("Palavra mais frequente: " + mostFrequentWord + " - " + mostFrequentCount + " vezes");
	}
	
	public static void main(String[] args) {
		WordCount wordCount = new WordCount();
		
		wordCount.addWord("Java", 10);
		wordCount.addWord("Python", 5);
		wordCount.addWord("C++", 3);
		wordCount.addWord("Java", 15);
		
		wordCount.showWords();
		wordCount.findMostFrequentWord();
	}
}
