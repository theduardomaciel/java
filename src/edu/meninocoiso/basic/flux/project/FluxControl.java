package edu.meninocoiso.basic.flux.project;

import java.util.Locale;
import java.util.Scanner;

public class FluxControl {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
		
		System.out.print("Digite o primeiro parâmetro: ");
		int firstParameter = scanner.nextInt();
		
		System.out.print("Digite o segundo parâmetro: ");
		int secondParameter = scanner.nextInt();
		
		try {
			// Chamando o método contendo a lógica de contagem
			count(firstParameter, secondParameter);
		} catch (InvalidParametersException error) {
			// Imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
			System.out.println("O segundo parâmetro deve ser maior que o primeiro.");
		}
	}
	
	static void count(int firstParameter, int secondParameter) throws InvalidParametersException {
		// Validar se firstParameter é MAIOR que secondParameter e lançar a exceção
		if (firstParameter > secondParameter) {
			throw new InvalidParametersException();
		}
		
		int counting = secondParameter - firstParameter;
		
		// Realizar o for para imprimir os números com base na variável "counting"
		for (int i = 0; i <= counting; i++) {
			System.out.println("Imprimindo o número " + i);
		}
	}
}
