package com.questk2.main;

import java.util.*;

public class TrackingSystem {
	public void trackBorrowedBooks(int bookId, int memberId) {
		System.out.println("Tracking borrowed book. Book ID: " + bookId + ", Member ID: " + memberId + ", Borrowed on: "
				+ new Date());
	}
}
