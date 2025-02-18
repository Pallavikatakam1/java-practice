package com.questk2.main;

class InvalidSalaryException extends Exception
{
	public  InvalidSalaryException(String message)
	{
		super(message);
	}
}
public class EmployeeSalary
{
	public static void setSalary(double salary) throws InvalidSalaryException
	{
		if(salary < 5000)
		{
			throw new InvalidSalaryException("Salary must be atleast 5000." + salary);
		}
		else
		{
			System.out.println("Salary set successfully ");
		}
	}
	
	public static void main(String[] args)
	{
		double salaryToTest = 6000;
		try
		{
			setSalary(salaryToTest);
		}
		catch(InvalidSalaryException e)
		{
			System.err.println("Error :" + e.getMessage());
		}
	}
}