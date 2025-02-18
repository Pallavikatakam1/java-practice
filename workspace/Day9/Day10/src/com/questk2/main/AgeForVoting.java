package com.questk2.main;
import java.util.Scanner;
public class AgeForVoting {
    	 public static void main(String[] args) 
    	 {	    
    		 Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your Age: ");
        int age = scanner.nextInt();

        try {
            if (age >= 18) {
                System.out.println("You are eligible for voting.");
            } else {
                // Throwing an exception when age is less than 18
                throw new IllegalArgumentException("You are not eligible for voting.");
            }
        } catch (IllegalArgumentException e) {
            // Directly handling the exception by printing the message
            System.out.println(e.getMessage());
        }
    }

}

