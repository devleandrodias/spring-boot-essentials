package com.spring.awesome.repository;

import com.spring.awesome.model.User;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * UserRepository
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

  User findByUsername(String username);
}