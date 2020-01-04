package com.spring.awesome.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * RestExceptionHandler
 */
@ControllerAdvice // Permite usar a classe em diversas camadas do spring
public class RestExceptionHandler {

  // Cada vez que a execção for lançada o spring vai executar o ExceptionHandler
  // (Aula 11 quando aprender sobre Builder)

  /**
   * @ExceptionHandler(ResourceNotFoundException.class) public ResponseEntity<?>
   *                                                    handleResourceNotFoundException(ResourceNotFoundException
   *                                                    resourceNotFoundException)
   *                                                    { // Builder de
   *                                                    ResourceNotFoundException
   *                                                    }
   */
}