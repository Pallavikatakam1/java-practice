package com.questk2.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderFile {
	// Method to search for a keyword in a file
	public static void searchKeywordInFile(String filePath, String keyword) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(keyword)) {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Call the method with the file path and keyword
		searchKeywordInFile("path/to/your/file.txt", "keyword");
	}
}
