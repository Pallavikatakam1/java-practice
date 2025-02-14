package com.questk2.main;


interface Vehicle
{
	public void start();
}

class Car implements Vehicle
{
	public void start()
	{
		System.out.println("Vehicle is  starting");
		System.out.println("It has 4 wheels");
		System.out.println("It is costly");
	}
}
class Bike implements Vehicle
{
	public void start()
	{
		System.out.println("Vehicle is  starting");
		System.out.println("It has 2 wheels");
		System.out.println("It is not costly");
	}
}

public class CarAndBike {

	public static void main(String[] args) {
		Car car = new Car();
		car.start();
		
		Bike Bike = new Bike();
		car.start();
		
	}

}
