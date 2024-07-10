package edu.meninocoiso.oop.collection.set.sort.exercise1;

import java.util.Comparator;
import java.util.Objects;

public class Product implements Comparable<Product> {
	private long code;
	private String name;
	private double price;
	private int quantity;
	
	public Product(int quantity, double price, String name, long code) {
		this.quantity = quantity;
		this.price = price;
		this.name = name;
		this.code = code;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product product)) return false;
		return this.getCode() == product.getCode();
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getCode());
	}
	
	@Override
	public int compareTo(Product product) {
		return this.getName().compareToIgnoreCase(product.getName());
	}
	
	public long getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
}

class ComparatorByPrice implements Comparator<Product> {
	@Override
	public int compare(Product product1, Product product2) {
		return Double.compare(product1.getPrice(), product2.getPrice());
	}
}