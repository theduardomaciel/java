package edu.meninocoiso.oop.collection.generics;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		// Uso sem generics
		Map mapWithoutGenerics = new HashMap();
		mapWithoutGenerics.put("key1", "String");
		mapWithoutGenerics.put("key2", 1);
		
		// Percebemos que o código acima não é seguro, pois não sabemos o tipo de dado que está sendo armazenado no mapa
		
		// Uso com generics
		Map<String, Integer> mapWithGenerics = new HashMap<>();
		mapWithGenerics.put("key1", 25);
		// mapWithGenerics.put("key2", "String"); // Erro de compilação
		
		// Percebemos que o código acima é seguro, pois sabemos o tipo de dado que está sendo armazenado no mapa
		
		System.out.println("Iterando sobre o mapa com o uso de Generics:");
		for (Map.Entry<String, Integer> entry : mapWithGenerics.entrySet()) {
			// O método entrySet() retorna um conjunto de pares chave-valor contidos no mapa
			// entry.getKey() retorna a chave do par (um String)
			// entry.getValue() retorna o valor do par (um inteiro)
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		
		System.out.println("Iterando sobre o mapa sem o uso de Generics");
		for (Object obj : mapWithoutGenerics.entrySet()) {
			Map.Entry entry = (Map.Entry) obj; // É necessário fazer um cast para Map.Entry
			String chave = (String) entry.getKey(); // É necessário fazer um cast para String
			Object valor = entry.getValue(); // Não fazemos um cast pois não sabemos o tipo de dado
			System.out.println("Chave: " + chave + ", Valor: " + valor);
		}
	}
}
