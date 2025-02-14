package com.questk2.main;

abstract class Shape
{
	abstract double calculateArea();
}
class Circle extends Shape
{
  private double radius;
  
public Circle(double radius)
{
	this.radius = radius;
}
public double calculateArea()
{
	return Math.PI * radius * radius;
}
}

class Rectangle extends Shape
{
	private double length;
	private double width;
	
	public Rectangle(double length, double width)
	{
		this.length = length;
		this.width = width;
	}
	
	public double calculateArea()
	{
		return length * width;
	}
}

public class Area {

	public static void main(String[] args) {
		
		Shape circle = new Circle(5);
		System.out.println("Circle area: " +circle.calculateArea());
		
		Shape rectangle = new Rectangle(5,7);
		System.out.println("Rectangle area: " +rectangle.calculateArea());
		
	}

}






















