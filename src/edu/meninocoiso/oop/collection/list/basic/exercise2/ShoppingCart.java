package edu.meninocoiso.oop.collection.list.basic.exercise2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Item> cart;
	
	public ShoppingCart() {
		cart = new ArrayList<>();
	}
	
	public void addItem(String name, double price, int quantity) {
		cart.add(new Item(name, price, quantity));
	}
	
	private void checkIfIsEmpty() {
		if (cart.isEmpty()) {
			throw new RuntimeException("O carrinho de compras se encontra vazio.");
		}
	}
	
	public void removeItem(String name) throws RuntimeException {
		checkIfIsEmpty();
		
		cart.removeIf(item -> item.getName().equalsIgnoreCase(name));
		/* ou:
		 *
		 * for (Item item : cart) {
		 * 	if (item.getName().equals(name)) {
		 * 		cart.remove(item);
		 * 	}
		 * }
		 * */
	}
	
	public double getTotal() {
		double total = 0;
		for (Item item : cart) {
			total += item.getPrice() * item.getQuantity();
		}
		return total;
	}
	
	public void showItems() {
		if (cart.isEmpty()) {
			System.out.println("Não há nenhum item no carrinho!");
			return;
		}
		
		for (Item item : cart) {
			System.out.println(item.toString());
		}
	}
	
	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		System.out.println(shoppingCart.toString());
		
		shoppingCart.addItem("Notebook", 2350.0, 2);
		shoppingCart.addItem("Fones de Ouvido", 100.0, 1);
		shoppingCart.addItem("Teclado", 70.0, 3);
		
		System.out.println("O carrinho de compras possui um total de R$ " + shoppingCart.getTotal());
		
		System.out.println("Itens do carrinho:");
		shoppingCart.showItems();
	}
}
