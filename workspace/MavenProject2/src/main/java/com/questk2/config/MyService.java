package com.questk2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyService {
    
    // Factory method to create MyService bean
    @Bean
    public MyService myService() {
        return new MyService(); // Correct instantiation of MyService
    }
}
