package com.ticklethepanda.euler.problem22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("names.txt");
		Scanner fileScanner = new Scanner(file);
		
		String s = fileScanner.next();
		s = s.replaceAll(",", "\n");
		Scanner strScanner = new Scanner(s);
		
		SortedStringArray ssa = new SortedStringArray();
		
		while(strScanner.hasNextLine()){
			String gotStr = strScanner.nextLine();
			gotStr = gotStr.substring(1, gotStr.length() - 1);
			ssa.add(gotStr);
		}
		
		long totalSum = 0;
		
		for(int i = 0; i < ssa.sortedArray.size(); i++)
		{
			String string = ssa.sortedArray.get(i);
			int sum = 0;
			for(int j = 0; j < string.length(); j++){
				sum += (int) string.charAt(j) - 64;
			}
			sum *= i + 1;
			totalSum += sum;
		}
		System.out.println(totalSum);
	}
}

class SortedStringArray {
	final static int FOUND = -1;

	ArrayList<String> sortedArray;

	public SortedStringArray() {
		this.sortedArray = new ArrayList<String>();
	}

	public void add(String word) {
		int insertLocation = insertPosition(word);

		// if the word wasn't found
		//if (insertLocation != FOUND) {
			// insert in correct position
			sortedArray.add(insertLocation, word);
		//}
	}

	// binary search modified to also find the position to put new element
	private int insertPosition(String word) {
		int imin, imax;
		imin = 0;
		imax = sortedArray.size() - 1;
		int mid = 0;
		// basic iterative binary search (using lexicographical string
		// comparison)
		while (imax >= imin) {
			mid = (imin + imax) / 2;
			String checkWord = sortedArray.get(mid);
			if (word.compareTo(checkWord) == 0)
				return FOUND;
			else if (word.compareTo(checkWord) > 0)
				imin = mid + 1;
			else
				imax = mid - 1;
		}
		// check whether the new value should be stored before or after the
		// final mid value
		if (sortedArray.size() > 0)
			if (sortedArray.get(mid).compareTo(word) < 0)
				mid++;
		return mid;
	}

	public int size() {
		return sortedArray.size();
	}
}
