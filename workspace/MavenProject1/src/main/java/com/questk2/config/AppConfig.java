package com.questk2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.questk2.beans.Address;
import com.questk2.beans.Person;

@Configuration
@ComponentScan(basePackages = "com.questk2")
public class AppConfig {

    @Bean
    public Person person() {
        return new Person("Pallavi", 21, address());
    }

    @Bean
    public Address address() {
        return new Address("Chirala", "Bapatla Dist", "AP");
    }
}

