package com.questk2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questk2.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
