package com.questk2.main;
import java.util.*;
public class PersonObject {

	/* the private fields are declared here like 
	   ->Name
	   ->age
	   ->city
	   ->subject */
	private String name;
	private int age;
	private String city;
	private List<String> subject;
	
	/* The constructor was initialized  to the person object */
	public PersonObject(String name, int age, String city, List<String> subject)
	{
		this.name = name;
		this.age = age;
		this.city = city;
		this.subject = subject;
	}
	
	public String toString()
	{
		return "name : " +name+ "age : " +age+ "city : " +city+ "subject : " +subject ;
	}
	
	/* using getter method to get the input to the field objects */
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	public String getCity()
	{
		return city;
	}
	public List<String> getSubject()
	{
		return subject;
	}
			
}