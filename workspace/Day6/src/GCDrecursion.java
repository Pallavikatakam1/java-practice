
/* In this program we have to find the greatest common divisor for the numbers given by the user.  */


import java.util.Scanner;        
public class GCDrecursion {
	
	public static int gcd(int number1, int number2)     //consider two numbers given by the user
	{
		if (number2 == 0)    // verify the 2nd number if it is divisible by 2 or not
		{
			return number1;    //gives the value to number1
		}
		return gcd(number2, number1 % number2);     //consider along with the  statement
	}
	

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);           //creating new scanner object
		System.out.print("enter the first number : ");    //asks user to enter the first number
		int number1 = scanner.nextInt();    // reads the user input from the scanner 
		System.out.print("Enter second number : ");   //asks the user to enter second number
		int number2 = scanner.nextInt();         //reads the user input from scanner
		int result = gcd(number1,number2);       // calculated result from the loop was given by the scanner
		System.out.println("The GCD for" +  number1 + "and" + number2 + "is :" +result);  //prints the output along with the string given
			
	}

}
