package edu.meninocoiso.oop.collection.map.sort.exercise2;

import java.util.Comparator;
import java.util.Map;

public class Book implements Comparable<Book> {
	private String title;
	private String author;
	private double price;
	
	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	@Override
	public int compareTo(Book book) {
		return Double.compare(this.price, book.price);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return title + " by " + author + " - $" + price;
	}
}

class BookPriceComparator implements Comparator<Map.Entry<String, Book>> {
	@Override
	public int compare(Map.Entry<String, Book> book1, Map.Entry<String, Book> book2) {
		return Double.compare(book1.getValue().getPrice(), book2.getValue().getPrice());
	}
}

class BookAuthorComparator implements Comparator<Map.Entry<String, Book>> {
	@Override
	public int compare(Map.Entry<String, Book> book1, Map.Entry<String, Book> book2) {
		return book1.getValue().getAuthor().compareTo(book2.getValue().getAuthor());
	}
}