package com.ticketSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TicketSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketSystemApplication.class, args);
        System.out.println("Ticket System is running! Access API docs at: http://localhost:8080/swagger-ui.html");
    }

    
    // Enable CORS for all endpoints
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	 registry.addMapping("/api/**")
                 .allowedOrigins("http://localhost:5173") // Your frontend URL
                 .allowedMethods("GET", "POST", "PUT", "DELETE")
                 .allowCredentials(true);
            }
        };
    }
}