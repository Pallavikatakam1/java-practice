package com.questk2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.questk2.entity.Student;
import com.questk2.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository repo;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		List<Student> students = repo.findAll();
		return students;
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		return student;
	}

	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
	}

	@PutMapping("/student/update/{id}")
	public Student updateStudents(@PathVariable int id, @RequestBody Student updatedStudent) {
	    return repo.findById(id).map(student -> {
	        student.setName(updatedStudent.getName());
	        student.setPercentage(updatedStudent.getPercentage());
	        student.setBranch(updatedStudent.getBranch());
	        return repo.save(student);
	    }).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
	}


	@DeleteMapping("/student/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
	}
}


