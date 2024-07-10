package edu.meninocoiso.oop.collection.comparable_and_comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	private static final String separator = "---------------------------------------";
	
	private static void printBooks(ArrayList<Book> books) {
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}
	
	public static void main(String[] args) {
		System.out.println("---------------------------------------");
		ArrayList<Book> books = new ArrayList<>() {
			{
				add(
						new Book(
								"Java - Guia do Programador: Atualizado Para Java 16",
								"Peter Jandl Junior",
								2021
						)
				);
				add(
						new Book(
								"Desenvolvimento Real de Software: Um guia de projetos para fundamentos em Java",
								"Raoul-Gabriel Urma e  Richard Warburton",
								2021
						)
				);
				add(
						new Book(
								"Microsserviços Prontos Para a Produção: Construindo Sistemas Padronizados em uma Organização de Engenharia de Software",
								"Susan J. Fowler",
								2017
						)
				);
				add(
						new Book(
								"Entendendo Algoritmos: Um Guia Ilustrado Para Programadores e Outros Curiosos",
								"Aditya Y. Bhargava",
								2017
						)
				);
				add(
						new Book(
								"Kotlin em Ação",
								"Dmitry Jemerov e Svetlana Isakova",
								2017
						)
				);
			}
		};
		
		System.out.println("Livros após a ordenação natural, por ano (utilizando Comparable): ");
		Collections.sort(books);
		
		printBooks(books);
		
		System.out.println();
		System.out.println("Livros após a ordenação por autor: ");
		
		books.sort(new CompareAuthor());
		// ou: Collections.sort(books, new CompareAuthor());
		
		printBooks(books);
		
		System.out.println(separator);
		System.out.println("Livros após a ordenação por título: ");
		
		books.sort(new CompareTitle());
		// ou: Collections.sort(books, new CompareTitle());
		
		printBooks(books);
		
		System.out.println(separator);
		System.out.println("Livros após a ordenação por ano, autor e título: ");
		
		books.sort(new CompareYearAuthorTitle());
		// ou: Collections.sort(books, new CompareYearAuthorTitle());
		
		printBooks(books);
	}
}
