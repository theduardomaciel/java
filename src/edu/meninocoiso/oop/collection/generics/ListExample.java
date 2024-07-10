package edu.meninocoiso.oop.collection.generics;

import java.util.ArrayList;
import java.util.List;


public class ListExample {
	public static void main(String[] args) {
		// Uso sem generics
		List listWithoutGenerics = new ArrayList();
		listWithoutGenerics.add("String");
		listWithoutGenerics.add(1);
		listWithoutGenerics.add(1.0);
		listWithoutGenerics.add(true);
		
		// Percebemos que o código acima não é seguro, pois não sabemos o tipo de dado que está sendo armazenado na lista
		
		// Uso com generics
		List<String> listWithGenerics = new ArrayList<>();
		listWithGenerics.add("String");
		// listWithGenerics.add(1); // Erro de compilação
		// listWithGenerics.add(1.0); // Erro de compilação
		// listWithGenerics.add(true); // Erro de compilação
		
		// Percebemos que o código acima é seguro, pois sabemos o tipo de dado que está sendo armazenado na lista
		
		System.out.println("Iterando sobre a lista com o uso de Generics:");
		for (String element : listWithGenerics) {
			System.out.println(element);
		}
		
		System.out.println("Iterando sobre a lista sem o uso de Generics");
		for (Object element : listWithoutGenerics) {
			System.out.println(element);
			// System.out.println((String) element); // Erro em tempo de execução
			// O código acima lança uma exceção em tempo de execução, pois estamos tentando fazer um cast de um Integer para um String
		}
	}
}
