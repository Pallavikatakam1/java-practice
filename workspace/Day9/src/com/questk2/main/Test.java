package com.questk2.main;

public class Test {

	public static void main(String[] args) {
	Customer aobj = new Customer();
	aobj.login();
	aobj.register();
	aobj.viewProfile();
	aobj.placeOrder();
	
		Restraunt bobj = new Restraunt();
		bobj . login();
		bobj.register();
		bobj.viewProfile();
		bobj.placeOrder();	
	
	
	    Biryani cobj= new Biryani();
	    cobj.price();
	    cobj.expireDate();
	
	
		Laddoo dobj = new Laddoo();
		dobj.price();
		dobj.expireDate();
	
	
		Payment eobj = new Payment();
		eobj.cartitem();
		eobj.amount();
		eobj.processPayment();
	
	
		Bawarchi fobj = new Bawarchi();
		fobj.name();
		fobj.address();
	
	
		PatabhiSweets gobj = new PatabhiSweets();
		gobj.name();
		gobj.address();
	
	
	
	}
}
