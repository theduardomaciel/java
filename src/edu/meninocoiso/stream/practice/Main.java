package edu.meninocoiso.stream.practice;

import edu.meninocoiso.stream.practice.challenges.*;

import java.util.Arrays;
import java.util.List;

public class Main {
	private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
	
	private static void separator(int index) {
		System.out.println("--------------------------------------------------");
		System.out.print(index + ". ");
	}
	
	public static boolean isPrime(int number) {
		if (number < 2) {
			//System.out.println(number + " não é primo.");
			return false;
		}
		
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				//System.out.println(number + " não é primo.");
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Challenge1 challenge1 = new Challenge1(numbers);
		challenge1.ascendingSort();
		
		separator(2);
		
		Challenge2 challenge2 = new Challenge2(numbers);
		challenge2.evenNumbersSum();
		
		separator(3);
		
		Challenge3 challenge3 = new Challenge3(numbers);
		challenge3.verifyAllPositive();
		
		separator(4);
		
		Challenge4 challenge4 = new Challenge4(numbers);
		challenge4.removeOddNumbers();
		
		separator(5);
		
		Challenge5 challenge5 = new Challenge5(numbers);
		challenge5.aboveFiveAverage();
		
		separator(6);
		
		Challenge6 challenge6 = new Challenge6(numbers);
		challenge6.anyNumberAboveTen();
		
		separator(7);
		
		Challenge7 challenge7 = new Challenge7(numbers);
		challenge7.secondBiggestNumber();
		
		separator(8);
		
		Challenge8 challenge8 = new Challenge8(numbers);
		challenge8.sumAllNumbersDigits();
		
		separator(9);
		
		Challenge9 challenge9 = new Challenge9(numbers);
		challenge9.allNumbersDistinct();
		
		separator(10);
		
		Challenge10 challenge10 = new Challenge10(numbers);
		challenge10.threeOrFiveGrouped();
		
		separator(11);
		
		Challenge11 challenge11 = new Challenge11(numbers);
		challenge11.sumOfSquares();
		
		separator(12);
		
		Challenge12 challenge12 = new Challenge12(numbers);
		challenge12.allNumbersProduct();
		
		separator(13);
		
		Challenge13 challenge13 = new Challenge13(numbers);
		challenge13.numberInInterval();
		
		separator(14);
		
		Challenge14 challenge14 = new Challenge14(numbers);
		challenge14.findBiggestPrime();
		
		separator(15);
		
		Challenge15 challenge15 = new Challenge15(numbers);
		challenge15.hasAtLeastOneNegative();
		
		separator(16);
		
		Challenge16 challenge16 = new Challenge16(numbers);
		challenge16.aggregateOddsAndEvens();
		
		separator(17);
		
		Challenge17 challenge17 = new Challenge17(numbers);
		challenge17.filterPrimeNumbers();
		
		separator(18);
		
		Challenge18 challenge18 = new Challenge18(numbers);
		challenge18.areAllEqual();
		
		separator(19);
		
		Challenge19 challenge19 = new Challenge19(numbers);
		challenge19.divisibleByThreeAndFiveSum();
	}
}
