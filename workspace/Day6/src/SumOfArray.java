
/* In this program asking user to give an array input 
   add the elements in the array using recursion */

import java.util.Scanner;
public class SumOfArray {
	public static int recursiveSum(int[] myArray,int indexValue) //taking the elements in the aray
	{
		if (indexValue == myArray.length)  //verifying the array length is equal to index value
		{
			return 0;    //array length = index value returns 0
		}
		return myArray[indexValue]+recursiveSum(myArray,indexValue+1); //verifies the condition
	
	
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);  //creating the new scanner object
		System.out.print("Enter the elements of the string ");    //asks user to enter the elements of the string    
		int number=scanner.nextInt();  //reads the user input from scanner

		int[] myArray = new int[number];     //arranging an array
		System.out.println("Enter elements of the array");  //asks the user to enter an array
		for (int arrayNum=0; arrayNum<number;arrayNum++)     //loop iteration starts from 0 and continue to given number
		{
			myArray[arrayNum] = scanner.nextInt(); //input was read  by scanner
		}
		int arraySum = recursiveSum(myArray,0);   //result analyzed
		
		System.out.println("The sum of array elements are : " +arraySum);  //result printed
	}
		
	}


