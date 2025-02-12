import java.util.Scanner;

public class PalindromeRecursion {

	
	public static boolean isPalindrome(String string,int start,int end)  //considering the given numbers as start and end
	{
		if(start >=end)     //if the start number doesn't matches to end number
		{
			return true;   //comes as true
		}
		if (string.charAt(start)!=string.charAt(end))    //if condition verifies
		{
			return false;            //gives false
		} 
		return isPalindrome(string, start + 1, end - 1);    //returns the statement
	}	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);  //creating the new scanner object
		System.out.print("Enter the elements of the string ");    //asks user to enter the elements of the string    
		String string=scanner.nextLine();  //reads the user input from scanner
		string = string.replaceAll(""," ").toLowerCase();  // iterate the statement
		boolean result = isPalindrome(string,0,string.length() - 1);  //verifies the string from 0 to given value to condition
		if (result)  //if result verified
		{
			System.out.println(result + " is a palindrome number"); //prints as palindrome
		}
		else                   //not verified
		{
			System.out.println(result + " is not a palindrome number");   //prints as not a palindrome
		}
		
		
	}

}
