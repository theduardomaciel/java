package edu.meninocoiso.oop.collection.list.search.exercise1;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog {
	private List<Book> books;
	
	public BookCatalog() {
		this.books = new ArrayList<>();
	}
	
	public void addBook(String title, String author, int year) {
		books.add(new Book(title, author, year));
	}
	
	public List<Book> searchByAuthor(String author) {
		if (books.isEmpty()) {
			System.out.println("Nenhum livro presente no catálogo.");
			return null;
		} else {
			List<Book> authorBooks = new ArrayList<>();
			
			for (Book book : books) {
				if (book.getAuthor().equalsIgnoreCase(author)) {
					authorBooks.add(book);
				}
			}
			
			if (authorBooks.isEmpty()) {
				System.out.println("Nenhum livro encontrado para o autor " + author + ".");
				return null;
			} else {
				return authorBooks;
			}
		}
	}
	
	public List<Book> searchByYearsInterval(int initialYear, int finalYear) {
		if (books.isEmpty()) {
			System.out.println("Nenhum livro presente no catálogo.");
			return null;
		} else {
			List<Book> intervalBooks = new ArrayList<>();
			
			for (Book book : books) {
				if (book.getYear() >= initialYear && book.getYear() <= finalYear) {
					intervalBooks.add(book);
				}
			}
			
			if (intervalBooks.isEmpty()) {
				System.out.println("Nenhum livro encontrado para o intervalo de anos " + initialYear + " a " + finalYear + ".");
				return null;
			} else {
				return intervalBooks;
			}
		}
	}
	
	public Book searchByTitle(String title) {
		if (books.isEmpty()) {
			System.out.println("Nenhum livro presente no catálogo.");
		} else {
			for (Book book : books) {
				if (book.getTitle().equalsIgnoreCase(title)) {
					return book;
				}
			}
			
			System.out.println("Nenhum livro encontrado para o título " + title + ".");
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		BookCatalog catalog = getBooksCatalog();
		
		System.out.println("Livros de J.R.R. Tolkien:");
		List<Book> tolkienBooks = catalog.searchByAuthor("J.R.R. Tolkien");
		if (tolkienBooks != null) {
			for (Book book : tolkienBooks) {
				System.out.println(book);
			}
		}
		
		System.out.println("\nLivros entre 1900 e 1950:");
		List<Book> intervalBooks = catalog.searchByYearsInterval(1900, 1950);
		if (intervalBooks != null) {
			for (Book book : intervalBooks) {
				System.out.println(book);
			}
		}
		
		System.out.println("\nBuscando por 'O Pequeno Príncipe':");
		Book littlePrince = catalog.searchByTitle("O Pequeno Príncipe");
		if (littlePrince != null) {
			System.out.println(littlePrince);
		}
		
		System.out.println("\nBuscando por 'Coraline':");
		Book coraline = catalog.searchByTitle("Coraline");
		if (coraline != null) {
			System.out.println(coraline);
		}
	}
	
	private static BookCatalog getBooksCatalog() {
		BookCatalog catalog = new BookCatalog();
		
		catalog.addBook("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
		catalog.addBook("O Hobbit", "J.R.R. Tolkien", 1937);
		catalog.addBook("O Silmarillion", "J.R.R. Tolkien", 1977);
		catalog.addBook("Dom Quixote", "Miguel de Cervantes", 1605);
		catalog.addBook("Cem Anos de Solidão", "Gabriel García Márquez", 1967);
		catalog.addBook("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943);
		catalog.addBook("A Metamorfose", "Franz Kafka", 1915);
		catalog.addBook("O Processo", "Franz Kafka", 1925);
		catalog.addBook("A Revolução dos Bichos", "George Orwell", 1945);
		catalog.addBook("1984", "George Orwell", 1949);
		return catalog;
	}
}
