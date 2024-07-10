package edu.meninocoiso.oop.collection.set.sort.exercise1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ProductRegister {
	Set<Product> products;
	
	public ProductRegister() {
		this.products = new HashSet<>();
	}
	
	public void addProduct(long code, String name, double price, int quantity) {
		products.add(new Product(quantity, price, name, code));
	}
	
	public void showProductsAlphabetically() {
		System.out.println("Lista de produtos em ordem alfabética:");
		Set<Product> sortedProducts = new TreeSet<>(products);
		sortedProducts.forEach(System.out::println);
		// ou:
		/*
		products.stream()
				.sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()))
				.forEach(System.out::println);
		*/
		// ou:
		/*
		products.stream()
				.sorted()
				.forEach(System.out::println);
		*/
	}
	
	public void showProductsByPrice() {
		System.out.println("Lista de produtos por preço:");
		
		// Aplicamos o ComparatorByPrice para ordenar os produtos por preço
		Set<Product> sortedProducts = new TreeSet<>(new ComparatorByPrice());
		
		// Adicionamos todos os produtos ao TreeSet ordenado
		sortedProducts.addAll(products);
		
		// Exibimos os produtos ordenados
		sortedProducts.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		ProductRegister productRegister = new ProductRegister();
		
		productRegister.addProduct(1, "Arroz", 10.0, 5);
		productRegister.addProduct(2, "Feijão", 8.0, 3);
		productRegister.addProduct(3, "Macarrão", 5.0, 2);
		productRegister.addProduct(4, "Óleo", 15.0, 1);
		productRegister.addProduct(5, "Sal", 2.0, 4);
		productRegister.addProduct(6, "Açúcar", 3.0, 6);
		productRegister.addProduct(7, "Café", 7.0, 7);
		productRegister.addProduct(8, "Leite", 4.0, 8);
		productRegister.addProduct(9, "Pão", 1.0, 9);
		productRegister.addProduct(10, "Manteiga", 6.0, 10);
		
		productRegister.showProductsAlphabetically();
		productRegister.showProductsByPrice();
	}
}
