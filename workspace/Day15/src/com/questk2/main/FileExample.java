package com.questk2.main;

import java.io.FileInputStream;
import java.io.IOException;

public class FileExample {

	// Method to read file content using FileInputStream
	public static void readFileUsingFileInputStream(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			int content;
			while ((content = fis.read()) != -1) {
				System.out.print((char) content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// Call the method with the file path
		readFileUsingFileInputStream("path/to/your/file.txt");
	}
}
