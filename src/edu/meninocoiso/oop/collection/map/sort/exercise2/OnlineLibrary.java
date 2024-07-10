package edu.meninocoiso.oop.collection.map.sort.exercise2;

import java.util.*;

public class OnlineLibrary {
	Map<String, Book> books;
	
	public OnlineLibrary() {
		this.books = new HashMap<>();
	}
	
	private boolean isEmpty() {
		if (books.isEmpty()) {
			System.out.println("A biblioteca está vazia.");
			return true;
		}
		
		return false;
	}
	
	public void addBook(String link, Book book) {
		books.put(link, book);
	}
	
	public void removeBook(String title) {
		if (isEmpty()) return;
		
		// As chaves dos livros a serem removidos são armazenadas em uma lista
		List<String> keysToRemove = new ArrayList<>();
		
		// Navegamos por cada livro da biblioteca, representado por um Map.Entry<String, Book>
		// Um Map.Entry<String, Book> é composto por:
		// - Uma chave (String) que é o link do livro
		// - Um valor (Book) que é o livro em si
		// Ou seja, entry.getKey() retorna o link do livro e entry.getValue() retorna o livro
		for (Map.Entry<String, Book> entry : books.entrySet()) {
			if (entry.getValue().getTitle().equals(title)) {
				keysToRemove.add(entry.getKey());
			}
		}
		
		if (keysToRemove.isEmpty()) {
			System.out.println("Livro não encontrado.");
		} else {
			for (String key : keysToRemove) {
				books.remove(key);
			}
		}
	}
	
	public void showBooksSortedByPrice() {
		if (isEmpty()) return;
		
		// Convertendo o Map de livros para uma lista de Map.Entry<String, Book>
		// Fazemos isso para poder ordenar os livros utilizando um Comparator
		List<Map.Entry<String, Book>> sortedBooks = new ArrayList<>(books.entrySet());
		sortedBooks.sort(new BookPriceComparator());
		
		for (Map.Entry<String, Book> entry : sortedBooks) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getTitle() + " - R$" + entry.getValue().getPrice());
		}
	}
	
	public void showBooksSortedByAuthor() {
		if (isEmpty()) return;
		
		// Convertendo o Map de livros para uma lista de Map.Entry<String, Book>
		// Fazemos isso para poder ordenar os livros utilizando um Comparator
		List<Map.Entry<String, Book>> sortedBooks = new ArrayList<>(books.entrySet());
		sortedBooks.sort(new BookAuthorComparator());
		
		for (Map.Entry<String, Book> entry : sortedBooks) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getTitle() + " (" + entry.getValue().getAuthor() + ")");
		}
	}
	
	public List<Map.Entry<String, Book>> searchBooksByAuthor(String author) {
		if (isEmpty()) return null;
		
		// Lista que armazenará os livros do autor (Map.Entry<String, Book>)
		List<Map.Entry<String, Book>> booksByAuthor = new ArrayList<>();
		
		// Navegamos por cada livro da biblioteca, representado por um Map.Entry<String, Book>
		for (Map.Entry<String, Book> entry : books.entrySet()) {
			if (entry.getValue().getAuthor().equals(author)) {
				booksByAuthor.add(entry);
			}
		}
		
		if (booksByAuthor.isEmpty()) {
			System.out.println("Nenhum livro encontrado para o autor " + author + ".");
			return null;
		}
		
		return booksByAuthor;
	}
	
	public Book getMostExpensiveBook() {
		if (isEmpty()) return null;
		
		Book mostExpensiveBook = null;
		double highestPrice = Integer.MIN_VALUE;
		
		for (Map.Entry<String, Book> entry : books.entrySet()) {
			if (entry.getValue().getPrice() > highestPrice) {
				highestPrice = entry.getValue().getPrice();
				mostExpensiveBook = entry.getValue();
			}
		}
		
		return mostExpensiveBook;

		/*
		// Convertendo o Map de livros para uma lista de Map.Entry<String, Book>
		// Fazemos isso para poder ordenar os livros utilizando um Comparator
		List<Map.Entry<String, Book>> sortedBooks = new ArrayList<>(books.entrySet());
		sortedBooks.sort(new BookPriceComparator());

		return sortedBooks.getLast().getValue();
		*/
	}
	
	public Book getCheapestBook() {
		if (isEmpty()) return null;
		
		Book cheapestBook = null;
		double lowestPrice = Integer.MAX_VALUE;
		
		for (Map.Entry<String, Book> entry : books.entrySet()) {
			if (entry.getValue().getPrice() < lowestPrice) {
				lowestPrice = entry.getValue().getPrice();
				cheapestBook = entry.getValue();
			}
		}
		
		return cheapestBook;
		/*
		// Convertendo o Map de livros para uma lista de Map.Entry<String, Book>
		// Fazemos isso para poder ordenar os livros utilizando um Comparator
		List<Map.Entry<String, Book>> sortedBooks = new ArrayList<>(books.entrySet());
		sortedBooks.sort(new BookPriceComparator());

		return sortedBooks.getFirst().getValue();
		*/
	}
	
	public static void main(String[] args) {
		OnlineLibrary library = new OnlineLibrary();
		
		library.addBook("https://amzn.to/3EclT8Z", new Book("1984", "George Orwell", 50d));
		library.addBook("https://amzn.to/47Umiun", new Book("A Revolução dos Bichos", "George Orwell", 7.05d));
		library.addBook("https://amzn.to/3L1FFI6", new Book("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
		library.addBook("https://amzn.to/3OYb9jk", new Book("Malorie", "Josh Malerman", 5d));
		library.addBook("https://amzn.to/45HQE1L", new Book("E Não Sobrou Nenhum", "Agatha Christie", 50d));
		library.addBook("https://amzn.to/45u86q4", new Book("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));
		
		System.out.println("Livros ordenados por preço:");
		library.showBooksSortedByPrice();
		
		List<Map.Entry<String, Book>> georgeOrwellBooks = library.searchBooksByAuthor("George Orwell");
		
		System.out.println("\nLivros de George Orwell:");
		for (Map.Entry<String, Book> entry : georgeOrwellBooks) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getTitle());
		}
		
		library.removeBook("1984");
		
		System.out.println("\nLivros ordenados por autor:");
		library.showBooksSortedByAuthor();
		
		System.out.println("\nLivro mais caro:");
		System.out.println(library.getMostExpensiveBook().getTitle());
		
		System.out.println("\nLivro mais barato:");
		System.out.println(library.getCheapestBook().getTitle());
	}
}
