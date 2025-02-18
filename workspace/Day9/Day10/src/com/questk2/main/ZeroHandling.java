package com.questk2.main;
import java.util.Scanner;
public class ZeroHandling {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first number : ");
		double number1 = scanner.nextDouble();
		System.out.println("Enter the seccond number : ");
		double number2 = scanner.nextDouble();
		try
		{
			double result = number1/number2;
			System.out.println("Result :" + result);
		}
		catch(ArithmeticException e)//directly handling the error by showing the message
		{
			System.out.println(e + "Error");
		}
				
	}

}
