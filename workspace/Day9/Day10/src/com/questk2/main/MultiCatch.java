package com.questk2.main;
import java.util.Scanner;

public class MultiCatch {

	public static void main(String[] args) 
	{
		int[]  numbers = {10, 20,  30, 40, 50};
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Array: [10, 20, 30, 40, 50]");
		System.out.println("Enter an index to retrive a number: ");
		String input = scanner.nextLine();
		
		try
		{
			int index = Integer.parseInt(input);
			System.out.println("Number at index: " + index + "is" +numbers[index]);
		}
		catch(ArrayIndexOutOfBoundsException | NumberFormatException e)
		{
			System.out.println("Error : " + e);
		}
		finally
		{
			scanner.close();
		}
		
	}

}
