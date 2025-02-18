package com.questk2.main;

class InsufficientFundsException extends Exception 
{
    public InsufficientFundsException(String message) 
    {
        super(message);
    }
}
public class BankWithDrawl 
{

	 public static int withdraw(int balance, int amount) throws InsufficientFundsException
	 {
        if (amount > balance)
        {
           throw new InsufficientFundsException("Insufficient funds: Unable to withdraw " + amount);
        }
            return balance - amount;
       }

     public static void main(String[] args) 
     {
        int balance = 5000; 
        int amountToWithdraw = 4800;

        try 
        {
          int newBalance = withdraw(balance, amountToWithdraw);
          System.out.println("Withdrawl successsful . Newbalance: "+ newBalance);
        
        } 
        catch (InsufficientFundsException e) {
             System.out.println("Withdrawl failed " + e.getMessage());
        }
    }
}
