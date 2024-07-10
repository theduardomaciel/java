package edu.meninocoiso.oop.collection.map.search.exercise1;

import java.util.HashMap;
import java.util.Map;

public class ProductStock {
	Map<String, Product> products;
	
	public ProductStock() {
		this.products = new HashMap<>();
	}
	
	public void addProduct(Product product) {
		products.put(product.getName(), product);
	}
	
	private boolean isEmpty() {
		if (products.isEmpty()) {
			System.out.println("Não há produtos no estoque.");
			return true;
		} else {
			return false;
		}
	}
	
	public void showProducts() {
		System.out.println("Produtos disponíveis no estoque:");
		for (Product product : products.values()) {
			System.out.println(product.toString());
		}
	}
	
	public void calculateTotalStockValue() {
		if (isEmpty()) return;
		
		double totalValue = 0d;
		
		for (Product product : products.values()) {
			totalValue += product.getPrice() * product.getQuantity();
		}
		
		System.out.println("Valor total do estoque: R$" + totalValue);
	}
	
	public Product getMoreExpensiveProduct() {
		if (isEmpty()) return null;
		
		Product mostExpensiveProduct = null;
		double mostExpensivePrice = Integer.MIN_VALUE;
		
		for (Product product : products.values()) {
			if (product.getPrice() > mostExpensivePrice) {
				mostExpensiveProduct = product;
				mostExpensivePrice = product.getPrice();
			}
		}
		
		return mostExpensiveProduct;
	}
	
	public Product getCheapestProduct() {
		if (isEmpty()) return null;
		
		Product cheapestProduct = null;
		double cheapestPrice = Integer.MAX_VALUE;
		
		for (Product product : products.values()) {
			if (product.getPrice() < cheapestPrice) {
				cheapestProduct = product;
				cheapestPrice = product.getPrice();
			}
		}
		
		return cheapestProduct;
	}
	
	public Product getMoreExpensiveProductByQuantity() {
		if (isEmpty()) return null;
		
		Product mostExpensiveProduct = null;
		double mostExpensivePrice = Integer.MIN_VALUE;
		
		for (Product product : products.values()) {
			double totalValue = product.getPrice() * product.getQuantity();
			if (totalValue > mostExpensivePrice) {
				mostExpensiveProduct = product;
				mostExpensivePrice = totalValue;
			}
		}
		
		return mostExpensiveProduct;
	}
	
	public static void main(String[] args) {
		ProductStock stock = new ProductStock();
		
		stock.addProduct(new Product("Arroz", 10.0, 15));
		stock.addProduct(new Product("Feijão", 5.0, 50));
		stock.addProduct(new Product("Macarrão", 3.0, 200));
		stock.addProduct(new Product("Óleo", 7.0, 30));
		stock.addProduct(new Product("Sal", 2.0, 20));
		
		stock.showProducts();
		stock.calculateTotalStockValue();
		
		Product mostExpensiveProduct = stock.getMoreExpensiveProduct();
		System.out.println("Produto mais caro: " + mostExpensiveProduct);
		
		Product cheapestProduct = stock.getCheapestProduct();
		System.out.println("Produto mais barato: " + cheapestProduct);
		
		Product mostExpensiveProductByQuantity = stock.getMoreExpensiveProductByQuantity();
		System.out.println("Produto mais caro por quantidade: " + mostExpensiveProductByQuantity);
	}
}
