package com.questk2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.questk2.dao.StudentDAO;
import com.questk2.dao.StudentDAOImpl;

import java.beans.JavaBean;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver"); // PostgreSQL Driver
        dataSource.setUrl("jdbc:postgresql://localhost:5432/QUESTK2"); // PostgreSQL URL
        dataSource.setUsername("postgres"); // Replace with your PostgreSQL username
        dataSource.setPassword("postgres"); // Replace with your PostgreSQL password
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public EmployeeDAO employeeDAO() {
        return new EmployeeDAOImpl(jdbcTemplate());
    }
}
