package com.spring.awesome.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResourceNotFoundException
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // 404
public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(String message) {
    super(message);
  }
}