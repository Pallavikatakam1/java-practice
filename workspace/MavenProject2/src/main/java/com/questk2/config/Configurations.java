package com.questk2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.questk2.beans.MyService;
@Configuration
public class Configurations {
    @Bean
    public MyService myService() {
        return new MyService();  // Instantiate your service class here
    }
}
