package com.questk2.main;

import com.questk2.config.AppConfig;
import com.questk2.dao.StudentDAO;
import com.questk2.model.Employee;
import com.questk2.model.Student;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);

        // Insert Student
        Employee student1 = new Employee(0, "Pallavi", 22, "pallavi@gmail.com");
        employeeDAO.insertStudent(employee1);

        // Update Student
        employee1.setName("Poojitha");
        employee1.setEmail("poojitha@gmail.com");
        employeeDAO.updateStudent(student1);

        // Retrieve and Display Students
        List<Employee> employees = employeeDAO.getAllEmployees();
        for (Employee e : employees) {
            System.out.println(s);
        }
    }
}

