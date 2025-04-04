package com.questk2.DAO;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.questk2.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

public abstract class EmployeeDAOImpl<JdbcTemplate> implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   
    public void insertStudent(Employee employee) {
        String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
        (jdbcTemplate).update(sql, employee.getId(), employee.getName(), employee.getSalary(), employee.getShift());
        System.out.println("Student inserted successfully!");
    }

   
    public void updateStudent(Employee employee) {
        String sql = "UPDATE students SET name=?, age=?, email=? WHERE id=?";
        ((Object) jdbcTemplate).update(sql, employee.getId(), employee.getName(), employee.getSalary(), employee.getShift());
        System.out.println("Student updated successfully!");
    }

    
    public List<Employee> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new RowMapper<Employee>() {
           
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                );
            }
        });
    }
}

