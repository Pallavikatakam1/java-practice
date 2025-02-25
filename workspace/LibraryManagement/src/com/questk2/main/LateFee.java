package com.questk2.main;

public class LateFee {
	public void makePayment(int bookId, int memberId, int daysLate) {
		System.out.println(
				"Member " + memberId + " paid for late return of book with ID: " + bookId + ". Days late: " + daysLate);
	}
}
