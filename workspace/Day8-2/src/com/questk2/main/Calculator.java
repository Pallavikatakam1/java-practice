package com.questk2.main;

public class Calculator
{
	public int add(int num1 , int num2)
	{
		return num1+num2;
	}
public int subtract(int num1,int num2)
{
	return num1-num2;
}
public int add(int num1 , int num2 ,int num3  )
	{
		return num1+num2+num3;
	}	



	public static void main(String[] args) 
	{
		Calculator calculator = new Calculator();
		System.out.println("Addition of two integers : " +calculator.add(10,20));
		
		System.out.println("Subtraction of two integers : " +calculator.subtract(20,15));
		
		System.out.println("Addition of three integer values :" +calculator.add(10,20,30));
		
	}

}
