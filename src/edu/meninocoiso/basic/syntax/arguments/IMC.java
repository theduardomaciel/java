package edu.meninocoiso.basic.syntax.arguments;

import edu.meninocoiso.basic.syntax.Localization;

import java.util.Map;
import java.util.Scanner;

import java.util.Hashtable;

public class IMC {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in).useLocale(Localization.BR);
		
		System.out.println("Digite o seu peso (em kg): ");
		double peso = scanner.nextDouble();
		
		System.out.println("Digite a sua altura (em metros): ");
		double altura = scanner.nextDouble();
		
		double imc = peso / (altura * altura);
		
		System.out.println("Seu IMC é: " + imc);
		
		Map<Double, String> imcMap = new Hashtable<>();
		imcMap.put(18.5, "Abaixo do peso");
		imcMap.put(24.9, "Peso normal");
		imcMap.put(29.9, "Sobrepeso");
		imcMap.put(34.9, "Obesidade grau 1");
		imcMap.put(39.9, "Obesidade grau 2");
		imcMap.put(Double.MAX_VALUE, "Obesidade grau 3");
		
		String classificacao = "Não classificado";
		for (Map.Entry<Double, String> entry : imcMap.entrySet()) {
			if (imc <= entry.getKey()) {
				classificacao = entry.getValue();
				break;
			}
		}
		
		System.out.println("Classificação: " + classificacao);
		System.out.println("Peso saudável para a sua altura entre: " + 18.5 * (altura * altura) + " e " + 24.9 * (altura * altura));
		
		scanner.close();
	}
}
