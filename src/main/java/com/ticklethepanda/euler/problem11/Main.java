package com.ticklethepanda.euler.problem11;

public class Main {
	public static void main(String[] args) {
		long maxNumber = 0;
		long bestCount = 0;
		for (int i = 1; i < 1000000; i++) {
			System.out.println(i);
			long count = 0;
			long currentInSequence = i;
			while (currentInSequence != 1) {
				count++;
				if(currentInSequence % 2 == 0){
					currentInSequence /= 2;
				} else {
					currentInSequence = 3 * currentInSequence + 1;
				}
			}
			if(count > bestCount){
				maxNumber = i;
				bestCount = count;
			}
		}
		System.out.println(maxNumber);
	}
}
