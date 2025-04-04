package com.questk2.DAO;

import java.util.List;

import com.questk2.model.Employee;

public interface EmployeeDAO {
    void insertStudent(Employee employee);
    void updateStudent(Employee employee);
    List<Employee> getAllStudents();
}