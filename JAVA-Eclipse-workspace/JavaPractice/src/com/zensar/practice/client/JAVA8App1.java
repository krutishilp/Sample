package com.zensar.practice.client;

import java.util.Arrays;
import java.util.List;

public class JAVA8App1 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		for (int i = 0; i < numbers.size(); i++) {
			numbers.set(i, numbers.get(i) + 2);
		}
		
		for (Integer i : numbers) {
			System.out.println((i));
		}

	}

}