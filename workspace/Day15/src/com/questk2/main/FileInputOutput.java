package com.questk2.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutput {

	// Method to copy content from one file to another
	public static void copyFile(String sourceFilePath, String destFilePath) {
		try (FileInputStream fis = new FileInputStream(sourceFilePath);
				FileOutputStream fos = new FileOutputStream(destFilePath)) {
			byte[] buffer = new byte[1024];
			int length;
			while ((length = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Call the method with source and destination file paths
		copyFile("path/to/source/file.txt", "path/to/destination/file.txt");
	}
}
