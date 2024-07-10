package edu.meninocoiso.oop.collection.comparable_and_comparator;


import java.util.Comparator;

public class Book implements Comparable<Book> {
	private final String title;
	private final String author;
	private final int year;
	
	// Constructor
	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	// Métodos Getters (para acessar os dados privados da classe externamente)
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getYear() {
		return year;
	}
	
	// Usado para comparar os livros por ano (em ordem crescente)
	@Override
	public int compareTo(Book other) {
		return Integer.compare(this.year, other.year);
		// equivalente a: Integer.valueOf(x).compareTo(Integer.valueOf(y)) e this.year - other.year
	}
	
	@Override
	public String toString() {
		return "Book{" +
				"title='" + title + '\'' +
				", author='" + author + '\'' +
				", year=" + year +
				'}';
	}
}

/**
 * Implementação de um Comparator para comparar os livros por autor
 */
class CompareAuthor implements Comparator<Book> {
	@Override
	public int compare(Book book1, Book book2) {
		return book1.getAuthor().compareTo(book2.getAuthor());
	}
}

/**
 * Implementação de um Comparator para comparar os livros por título
 */
class CompareTitle implements Comparator<Book> {
	@Override
	public int compare(Book book1, Book book2) {
		return book1.getTitle().compareTo(book2.getTitle());
	}
}

/**
 * Implementação de um Comparator para comparar os livros por ano, autor e título
 */
class CompareYearAuthorTitle implements Comparator<Book> {
	@Override
	public int compare(Book book1, Book book2) {
		int compareYear = book1.compareTo(book2);
		
		// Caso não haja diferença no ano, compara-se os autores
		if (compareYear == 0) {
			int compareAuthor = book1.getAuthor().compareTo(book2.getAuthor());
			
			// Caso não haja diferença nos autores, compara-se os títulos
			if (compareAuthor == 0) {
				return book1.getTitle().compareTo(book2.getTitle());
			}
			
			return compareAuthor;
		}
		
		return compareYear;
	}
}