
//to find the factorial of the given number by the user using recursion form

import java.util.Scanner;
public class FactorialRecursion {
	public static int factorialNumber(int number)   //considering the given number 
	{
		if (number==0)    //if given number equals 0
		{
			return 1;     //it gives return value as 1
		}
		else   //otherwise
		{
			return number*factorialNumber(number-1);      //execute the given  condition
		}
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);         //creating a new scanner object
		int number = scanner.nextInt();        //read the scanner input
		System.out.print("enter a number ");      //asks user to enter a number
		factorialNumber(number);          //concludes the  output 
		
		System.out.println(factorialNumber(number));     //prints the output
		
	}

}
