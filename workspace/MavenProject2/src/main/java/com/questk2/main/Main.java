package com.questk2.main;

import com.questk2.beans.MyService;
import com.questk2.config.Configurations;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Spring Context...");

        // Initialize Spring context with the configurations class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configurations.class);

        // Retrieve the MyService bean from the Spring context
        MyService myService = context.getBean(MyService.class);

        // Call the serve method on the service
        myService.serve();

        System.out.println("Closing Spring Context...");
        context.close();
    }
}
