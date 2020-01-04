package com.spring.awesome.repository;

import java.util.List;

import com.spring.awesome.model.Student;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * StudentRepository
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
  List<Student> findByNameIgnoreCaseContaining(String name);
}