package com.questk2.main;
import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankAccount bankaccount = new BankAccount();
		System.out.println("Enter account number : ");
		int accountNumber = scanner.nextInt();
		try
		{
			if(accountNumber == 66666);
			{
				System.out.println("Enter option : ");
				String option = scanner.next();
				switch(option)
				{
				case "deposit":
					System.out.println("Enter amount to deposit : ");
					int amount = scanner.nextInt();
					try
					{
						bankaccount.deposit(amount);
					}
					catch(InvalidAmountException e)
					{
						e.printStackTrace();
						System.exit(amount);
					}
					break;
				case "balance":
					bankaccount.checkBalance();
					break;
				case "withdraw":
					System.out.println("Enter amount to be withdrawl : ");
					int withdrawAmount = scanner.nextInt();
					try
					{
						bankaccount.withdraw(withdrawAmount);
					}
					catch(InsufficientFundsException e)
					{
						e.printStackTrace();
					}
					break;
				}
			}
			
			{
				throw new InvalidAccountException("Enter valid account number");
			}
		}
		catch(InvalidAccountException e)
		{
			System.out.println(e);
		}
	}

}
