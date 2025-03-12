package com.questk2.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.questk2.beans.Person;
import com.questk2.config.AppConfig;

public class Main {

    public static void main(String[] args) {
        // Load Spring Configuration (app config class)
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve bean from context
        Person person = context.getBean(Person.class);

        // Call the method on the bean to display details
        person.displayDetails();
    }
}



