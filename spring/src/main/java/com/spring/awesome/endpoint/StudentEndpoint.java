package com.spring.awesome.endpoint;

import java.util.List;

import com.spring.awesome.model.Student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Arrays.asList;

/**
 * StudentEndpoint
 */
@RestController // Aqui é nosso endpoint
@RequestMapping("student") // onde ele vai acessar (Rota)
public class StudentEndpoint {

  @RequestMapping(method = RequestMethod.GET, path = "/list")
  public List<Student> listAll() {
    return asList(new Student("Leandro"), new Student("Thaísa"));
  }
}