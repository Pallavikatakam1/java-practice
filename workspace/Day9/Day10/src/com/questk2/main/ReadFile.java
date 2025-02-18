package com.questk2.main;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadFile 
{
	  public static void readFile(String fileName) throws IOException 
	  {
		 File file = new File(fileName);
		 Scanner scanner = new Scanner(file);
		 while (scanner.hasNextLine())
		 {
			 String line = scanner.nextLine();
			 System.out.println(line);
		 }
		 scanner.close();
	  }
	  public static void main(String[] args)
	  {
		  String fileName = "example.txt";
		  try
		  {
			  readFile(fileName);
		  }
		  catch (IOException e)
		  {
			  System.out.println("An error occured"  + e);
			  e.printStackTrace();
		  }
	  }
}	  



