package com.questk2.main;

public class BankAccount
{
	private int accountNumber=66666;
	private int balance = 5000;

	public void  setAccountNumber(int accountNumber) 
	{
		this.accountNumber = accountNumber;
	}
	public int getAccountNumber(int accountNumber)
	{
		return accountNumber;
	}
	public void setBalance(int balance)
	{
		this.balance = balance;
	}
	public int getBalance(int balance)
	{
		return balance;
	}
	
	public void deposit(int amount) throws InvalidAmountException
	{
		if(amount<0)
		{
			throw new InvalidAmountException("Enter valid amount");
		}
		else
		{
			balance = balance+amount;
			System.out.println("For account number : "+accountNumber);
			System.out.println("Deposited amount : "+balance);
		}
	}
	
	public void withdraw(int withdrawAmount) throws InsufficientFundsException
	{
		if(withdrawAmount > balance)
		{
			throw new InsufficientFundsException("Insufficient balance to withdrawl");
		}
		else
		{
			int deduction = balance - withdrawAmount;
			System.out.println("After withdrawl remaining balance is : " +deduction);
		}	
	}

	public void checkBalance()
	{
		System.out.println("Available balance : "+balance);
	}
}
