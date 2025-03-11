package com.questk2.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Character {
	// Method to count occurrences of a character in a file
	public static int countCharacterOccurrences(String filePath, char character) {
		int count = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			int c;
			while ((c = br.read()) != -1) {
				if (c == character) {
					count++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}

	public static void main(String[] args) {
		// Call the method and print the count
		int count = countCharacterOccurrences("path/to/your/file.txt", 'a');
		System.out.println("Character 'a' occurs " + count + " times.");
	}
}
