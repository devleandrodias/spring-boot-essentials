package com.spring.awesome.repository;

import java.util.List;

import com.spring.awesome.model.Student;

import org.springframework.data.repository.CrudRepository;

/**
 * StudentRepository
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
  List<Student> findByNameIgnoreCaseContaining(String name);
}