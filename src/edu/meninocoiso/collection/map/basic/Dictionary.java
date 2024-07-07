package edu.meninocoiso.collection.map.basic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	Map<String, String> dict;

	public Dictionary() {
		this.dict = new HashMap<>();
	}

	public void addWord(String word, String meaning) {
		this.dict.put(word, meaning);
	}

	public void removeWord(String word) {
		if (dict.isEmpty()) {
			System.out.println("O dicionário está vazio.");
			return;
		}

		Object removed = dict.remove(word);
		if (removed == null) {
			System.out.println("A palavra '" + word + "' não foi encontrada.");
		}

		System.out.println("Palavra removida: " + word);
	}

	public void listWords() {
		if (dict.isEmpty()) {
			System.out.println("O dicionário está vazio.");
			return;
		}

		System.out.println("Palavras no dicionário:");
		System.out.println(dict);
	}

	public String searchForWord(String word) {
		if (dict.isEmpty()) {
			System.out.println("O dicionário está vazio.");
			return null;
		}

		String meaning = dict.get(word);
		if (meaning == null) {
			System.out.println("A palavra '" + word + "' não foi encontrada.");
			return null;
		}

		return meaning;
	}

	public static void main(String[] args) {
		Dictionary dict = new Dictionary();
		dict.addWord("Maçã", "Fruta comestível de casca fina e polpa branca.");
		dict.addWord("Banana", "Fruta comestível de casca amarela e polpa doce.");
		dict.addWord("Abacaxi", "Fruta comestível de casca grossa e polpa ácida.");

		dict.listWords();

		System.out.println("Maçã significa: " + dict.searchForWord("Maçã"));
		System.out.println("Banana significa: " + dict.searchForWord("Banana"));
		System.out.println("Abacaxi significa: " + dict.searchForWord("Abacaxi"));

		dict.removeWord("Banana");

		dict.listWords();

		System.out.println("Banana significa: " + dict.searchForWord("Banana"));
	}
}
