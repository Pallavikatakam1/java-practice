package com.questk2.demo;

public class Maths {
	public Integer operations(Integer first, Integer second) {
		return first + second;
	}
	public static void main(String[] args) {
		Maths maths = new Maths();
		System.out.println(maths.operations(1,4));
	}

}
