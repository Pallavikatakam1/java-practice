package com.questk2.main;
import java.util.*;
public class TestObject {

	public static void main(String[] args) {
		
		/* Creating the list of the objects of 4 persons */
		
		//1st person
		//List of subject
		List<String> subject1 = new ArrayList<>();
		subject1.add("Signals");
		subject1.add("Networks");
		
		PersonObject person1 = new PersonObject("Pallavi", 21, "Hyderabad",subject1);

		//2nd person
		//List of subject
		List<String> subject2 = new ArrayList<>();
		subject2.add("Power systems");
		subject2.add("Machines");
		
		PersonObject person2 = new PersonObject("Poojitha", 15, "Chirala",subject2);

		//3rd person
		//List of subject
		List<String> subject3 = new ArrayList<>();
		subject3.add("Embedded");
		subject3.add("Electric Fields");
		
		PersonObject person3 = new PersonObject("Mahija", 22, "Nellore",subject3);

		//4th person
		//List of subject
		List<String> subject4 = new ArrayList<>();
		subject4.add("Solar");
		subject4.add("Electronics");
		
		PersonObject person4 = new PersonObject("Indhu", 20, "Ongole",subject4);
		
		/* Creating an array list */
		List<PersonObject> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person4);
		
		
		/* creating a HashSet */
		Set<PersonObject> set = new HashSet<>();
		set.add(person1);
		set.add(person2);
		set.add(person4);
		
		/* creating a vector  */
		Vector<PersonObject> vector = new Vector<>();
		vector.add(person1);
		vector.add(person2);
		vector.add(person4);
		
		/* creating  a queue*/
		Queue<PersonObject> queue = new LinkedList<>();
		queue.add(person1);
		queue.add(person2);
		queue.add(person4);
		
		System.out.println("Arraylist output : ");
		for(int value=0;value<list.size();value++)
		{
			PersonObject personobject = list.get(value);
			System.out.println("Name : " +personobject.getName()+ "Age : " +personobject.getAge()+ "city : " +personobject.getCity()+"subject : " +personobject.getSubject());
		}
		
		System.out.println("list is empty :" +list.isEmpty());	
		List<PersonObject> listset = new ArrayList<>(set);
	
		System.out.println("HashSet Output : ");
		for(int value=0;value<listset.size();value++)
		{
			PersonObject personobject = listset.get(value);
			System.out.println("Name : " +personobject.getName()+ "Age : " +personobject.getAge()+ "city : " +personobject.getCity()+"subject : " +personobject.getSubject());
		}
		
		
		System.out.println("Vector contains person4 : " + vector.contains(person4)); 
	       
        System.out.println("Queue using LinkedList : ");
        List<PersonObject> listqueue=new ArrayList<>(queue);
        for(int value=0;value<listqueue.size();value++)
        {
        	PersonObject person=listqueue.get(value);
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge() + ", City: " + person.getCity() + ", Subjects: " + person.getSubject());
        }
		
	}

}
